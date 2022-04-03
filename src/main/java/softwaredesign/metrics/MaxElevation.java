package softwaredesign.metrics;

import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import softwaredesign.GPXData;

import java.util.List;

public class MaxElevation extends Metrics {

    public MaxElevation(GPXData gpx) {
        this.name ="MAX ELEVATION";
        this.value = 0.0;
        CalculateMaxElevation(gpx);
    }

    public void CalculateMaxElevation(GPXData file){
        if (file.getgpx().getRoutes().isEmpty() && file.getgpx().getTracks().isEmpty()) {
            List<WayPoint> lis = file.getgpx().getWayPoints();
            for (int f = 0; f < lis.size() - 1; f++) {
                if(lis.get(f).getElevation().get().doubleValue() > this.value) this.value = lis.get(f).getElevation().get().doubleValue();
            }
        } else if (file.getgpx().getRoutes().isEmpty()) {
            List<Track> track = file.getgpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    for (int f = 0; f < lis.size() - 1; f++) {
                        if(lis.get(f).getElevation().get().doubleValue()  > this.value) this.value = lis.get(f).getElevation().get().doubleValue();
                    }
                }
            }
        } else {
            List<Route> routes = file.getgpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> lis = routes.get(i).getPoints();
                for (int f = 0; f < lis.size() - 1; f++) {
                    if(lis.get(f).getElevation().get().doubleValue() > this.value) this.value = lis.get(f).getElevation().get().doubleValue();
                }
            }
        }
    }
}

