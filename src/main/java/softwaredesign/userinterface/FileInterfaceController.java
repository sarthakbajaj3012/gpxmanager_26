package softwaredesign.userinterface;

import io.jenetics.jpx.WayPoint;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.TileFactoryInfo;
import softwaredesign.Event;
import softwaredesign.History;
import softwaredesign.Map;
import softwaredesign.metrics.Metrics;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FileInterfaceController implements Initializable {
    @FXML
    private ComboBox<String> list;

    @FXML
    private TextField filepath;

    @FXML
    private Button exit;

    @FXML
    private Button history;

    @FXML
    private TextArea speed;



    private Stage stage;
    private Scene scene;
    private Parent root;
    private History historydata = new History();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(FXCollections.observableArrayList("Running","Cycling"));
    }

    public void getData(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        Event eve = new Event(filepath.getText(),list.getValue());
        historydata.add(eve.getSport());
//        displaymap(eve.getWayPoints());
            speed.setText(eve.getSport().printdata());
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

    public void gethistory(ActionEvent actionEvent) {
        String s="";
        for(int i = 0; i< historydata.data().size();i++){
            s +="\n" + historydata.data().get(i).printdata();
        }
        speed.setText(s);
    }
}
