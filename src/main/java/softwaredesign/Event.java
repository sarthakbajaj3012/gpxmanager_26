package softwaredesign;

import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;
import io.jenetics.jpx.WayPoint;
import softwaredesign.sports.Sports;
import softwaredesign.sports.SportsFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class Event {
    private GPXData gpx;
    private Sports sport;
    private static Event eve = null;



    private Event(String filepath , String sportsname) throws FileNotFoundException , NullPointerException {
        this.gpx = new GPXData(filepath);
        this.sport = new SportsFactory().getSports(sportsname,gpx);
    }

    public Sports getSport() {
        return sport;
    }

    public static Event getInstance(String filepath , String sportsname) throws FileNotFoundException {
        if(eve == null)
            eve = new Event(filepath,sportsname);
        return eve;
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
