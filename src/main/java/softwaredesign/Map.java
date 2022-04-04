package softwaredesign;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.javascript.object.*;
import io.jenetics.jpx.WayPoint;

import java.util.List;

public class Map {

    private GoogleMap map;
    private GoogleMapView mapView;

    public Map(GoogleMapView mapView){
        this.mapView = mapView;
    }

    public void configureMap() {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(9);
        map = mapView.createMap(mapOptions, false);

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

    public GoogleMap getMap() {
        return map;
    }
}
