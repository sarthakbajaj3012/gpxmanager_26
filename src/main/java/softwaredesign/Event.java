package softwaredesign;

import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import softwaredesign.sports.Cycling;
import softwaredesign.sports.Running;
import softwaredesign.sports.Sports;

import java.io.FileNotFoundException;
import java.util.List;

public class Event {
    private GPXData gpx;
    private Sports sport;


    public Event(String filepath , String sportsname) throws FileNotFoundException , NullPointerException {
        this.gpx = new GPXData(filepath);
        if(sportsname.equalsIgnoreCase("running")) sport = new Running(gpx);
        else sport = new Cycling(gpx);


    }

    public Sports getSport() {
        return sport;
    }

    public List<WayPoint> getWayPoints(){
        if (gpx.getgpx().getTracks().isEmpty() && gpx.getgpx().getRoutes().isEmpty()) {
            return  gpx.getgpx().getWayPoints();
        }
        else if (gpx.getgpx().getRoutes().isEmpty()) {
            List<Track> track = gpx.getgpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    return trackSegments.get(i).getPoints();
                }
            }
        }
        else {
            List<Route> routes = gpx.getgpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                return routes.get(i).getPoints();
            }
        }
        return null;
    }
}
