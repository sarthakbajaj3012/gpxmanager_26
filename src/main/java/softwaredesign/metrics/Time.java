package softwaredesign.metrics;


import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import softwaredesign.GPXData;

import java.util.List;

public class Time extends Metrics {

    public Time(GPXData data) {
        this.name = "TIME";
        CalculateTime(data);
    }

    public void CalculateTime(GPXData file){
        if (file.getgpx().getTracks().isEmpty() && file.getgpx().getRoutes().isEmpty()) {
            List<WayPoint> lis = file.getgpx().getWayPoints();
            this.value = Double.valueOf(lis.get(lis.size() -1).getTime().get().toEpochSecond() - lis.get(0).getTime().get().toEpochSecond());
        }
        else if (file.getgpx().getRoutes().isEmpty()) {
            List<Track> track = file.getgpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    this.value = Double.valueOf(lis.get(lis.size() -1).getTime().get().toEpochSecond() - lis.get(0).getTime().get().toEpochSecond());
                }
            }
        }
        else {
            List<Route> routes = file.getgpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> trackSegments = routes.get(i).getPoints();
                this.value= Double.valueOf(trackSegments.get(trackSegments.size() - 1).getTime().get().toEpochSecond() - trackSegments.get(0).getTime().get().toEpochSecond());
            }
        }
    }
}
