package softwaredesign.metrics;

import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import io.jenetics.jpx.geom.Geoid;
import softwaredesign.GPXData;

import java.util.List;

public class Distance extends Metrics {


    public Distance(GPXData data){
        this.name = "DISTANCE";
        this.value = 0.0;
        CalculateDistance(data);
    }


    public  void CalculateDistance(GPXData file){
        if (file.getgpx().getRoutes().isEmpty() && file.getgpx().getTracks().isEmpty()) {
            List<WayPoint> lis = file.getgpx().getWayPoints();
            Double distance = 0.0;
            for (int f = 0; f < lis.size() - 1; f++) {
                distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
            }
            this.value = distance;

        } else if (file.getgpx().getRoutes().isEmpty()) {
            Double distance = 0.0;
            List<Track> track = file.getgpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    for (int f = 0; f < lis.size() - 1; f++) {
                        distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
                    }
                }
            }
            this.value = distance;
        } else {
            Double distance = 0.0;
            List<Route> routes = file.getgpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> lis = routes.get(i).getPoints();
                for (int f = 0; f < lis.size() - 1; f++) {
                    distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
                }
            }
            this.value = distance;
        }
    }

}
