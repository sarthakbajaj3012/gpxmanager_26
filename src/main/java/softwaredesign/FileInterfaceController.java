package softwaredesign;

import io.jenetics.jpx.WayPoint;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import softwaredesign.metrics.Metrics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FileInterfaceController implements Initializable {
    @FXML
    private ComboBox<String> list;

    @FXML
    private TextField filepath;

    @FXML
    private Button exit;

    @FXML
    private TextArea speed;



    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(FXCollections.observableArrayList("Running","Cycling"));
    }

    public void getData(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        Event eve = new Event(filepath.getText(),list.getValue());

//        displaymap(eve.getWayPoints());

        String s = "";
            List<Metrics> data = eve.getSport().getMetrics();
            for (int i = 0; i < data.size(); i++) {
                s += data.get(i).name + ": " +data.get(i).value.toString() + "\n";
            }
            System.out.println(s);
            speed.setText(s);
        speed.setVisible(true);
    }

    public void displaymap(List<WayPoint> way){
        JXMapViewer mapViewer = new JXMapViewer();

        // Display the viewer in a JFrame
        JFrame frame = new JFrame("JXMapviewer2 Example 2");
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

//         Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer.setTileFactory(tileFactory);

        Map map = new Map(way);
        Painter<JXMapViewer> paint = map;
        mapViewer.setOverlayPainter(paint);
    }



    public void exit(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }
}
