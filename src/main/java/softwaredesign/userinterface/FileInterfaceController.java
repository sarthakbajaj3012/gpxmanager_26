package softwaredesign.userinterface;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.javascript.object.*;
import io.jenetics.jpx.WayPoint;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import softwaredesign.Event;
import softwaredesign.History;
import softwaredesign.Map;

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

    @FXML
    protected GoogleMapView mapView;

    private GoogleMap map;

    private History historydata = History.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(FXCollections.observableArrayList("Running","Cycling"));
        mapView.addMapInitializedListener(this::configureMap);
    }
    protected void configureMap() {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(9);
        map = mapView.createMap(mapOptions, false);

    }

    public void getData(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        Event eve =  Event.getInstance(filepath.getText(),list.getValue());
        historydata.add(eve.getSport());
        mapView.setVisible(true);
        addMarker(eve);
        speed.setText(eve.getSport().getData());
        speed.setVisible(true);
    }


    public void addMarker(Event e){
        List<WayPoint> list = e.getWayPoints();
        map.setCenter(new LatLong(list.get(0).getLatitude().doubleValue(),list.get(0).getLongitude().doubleValue()));
        for(int i= 0; i < list.size(); i++ ){

            MarkerOptions markeropt = new MarkerOptions();

            markeropt.position(new LatLong(list.get(i).getLatitude().doubleValue(),list.get(i).getLongitude().doubleValue()));
            Marker marker = new Marker(markeropt);
            map.addMarker(marker);
        }

    }

    public void exit(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }

    public void getHistory(ActionEvent actionEvent) {
       speed.setText(historydata.getHistory());
    }

}
