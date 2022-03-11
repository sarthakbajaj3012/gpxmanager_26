package softwaredesign;


import io.jenetics.jpx.*;
import io.jenetics.jpx.geom.Geoid;
import java.io.FileNotFoundException;
import java.util.List;


public abstract class Sports {

    private Double speed;
    private Integer id;
    public String name;
    private Double totalDistance;
    private Double maxElevation;
    private Double minElevation;
    private GPXParser file;
    private Long timetaken;


    public Sports() throws FileNotFoundException {
       this.file = new GPXParser();
       this.name = "sports";
       this.id = 0;
       this.maxElevation =0.0;
       this.minElevation = 0.0;
       this.setDistance();
       this.setTime();
       this.setElevation();
       this.setSpeed();
    }

    public void setID(Integer number){
        this.id = number;
    }

    private void setDistance() {
        if (file.getGpx().getRoutes().isEmpty() && file.getGpx().getTracks().isEmpty()) {
            List<WayPoint> lis = file.getGpx().getWayPoints();
            Double distance = 0.0;
            for (int f = 0; f < lis.size() - 1; f++) {
                distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
            }
            this.totalDistance = distance;

        } else if (file.getGpx().getRoutes().isEmpty()) {
            Double distance = 0.0;
            List<Track> track = file.getGpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    for (int f = 0; f < lis.size() - 1; f++) {
                        distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
                    }
                }
            }
            this.totalDistance = distance;
        } else {
            Double distance = 0.0;
            List<Route> routes = file.getGpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> lis = routes.get(i).getPoints();
                for (int f = 0; f < lis.size() - 1; f++) {
                    distance += Geoid.WGS84.distance(lis.get(f), lis.get(f + 1)).doubleValue();
                }
            }
            this.totalDistance = distance;
        }
    }

    private void setElevation() {
        if (file.getGpx().getRoutes().isEmpty() && file.getGpx().getTracks().isEmpty()) {
            List<WayPoint> lis = file.getGpx().getWayPoints();
            for (int f = 0; f < lis.size() - 1; f++) {
                if(lis.get(f).getElevation().get().doubleValue() > this.maxElevation) this.maxElevation = lis.get(f).getElevation().get().doubleValue();
                if(lis.get(f).getElevation().get().doubleValue() < this.minElevation) this.minElevation = lis.get(f).getElevation().get().doubleValue();
            }
        } else if (file.getGpx().getRoutes().isEmpty()) {
            List<Track> track = file.getGpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    for (int f = 0; f < lis.size() - 1; f++) {
                        if(lis.get(f).getElevation().get().doubleValue() > this.maxElevation) this.maxElevation = lis.get(f).getElevation().get().doubleValue();
                        if(lis.get(f).getElevation().get().doubleValue() < this.minElevation) this.minElevation = lis.get(f).getElevation().get().doubleValue();
                    }
                }
            }
        } else {
            List<Route> routes = file.getGpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> lis = routes.get(i).getPoints();
                for (int f = 0; f < lis.size() - 1; f++) {
                    if(lis.get(f).getElevation().get().doubleValue() > this.maxElevation) this.maxElevation = lis.get(f).getElevation().get().doubleValue();
                    if(lis.get(f).getElevation().get().doubleValue() < this.minElevation) this.minElevation = lis.get(f).getElevation().get().doubleValue();
                }
            }
        }
    }

    private void setTime(){
        if (file.getGpx().getTracks().isEmpty() && file.getGpx().getRoutes().isEmpty()) {
            List<WayPoint> lis = file.getGpx().getWayPoints();
            this.timetaken = lis.get(lis.size() -1).getTime().get().toEpochSecond() - lis.get(0).getTime().get().toEpochSecond() ;
        }
        else if (file.getGpx().getRoutes().isEmpty()) {
            List<Track> track = file.getGpx().getTracks();
            for (int i = 0; i < track.size(); i++) {
                List<TrackSegment> trackSegments = track.get(i).getSegments();
                for (int j = 0; j < trackSegments.size(); j++) {
                    List<WayPoint> lis = trackSegments.get(i).getPoints();
                    this.timetaken = lis.get(lis.size() -1).getTime().get().toEpochSecond() - lis.get(0).getTime().get().toEpochSecond() ;
                }
            }
        }
        else {
            List<Route> routes = file.getGpx().getRoutes();
            for (int i = 0; i < routes.size(); i++) {
                List<WayPoint> trackSegments = routes.get(i).getPoints();
                this.timetaken = trackSegments.get(trackSegments.size() - 1).getTime().get().toEpochSecond() - trackSegments.get(0).getTime().get().toEpochSecond();
            }
        }
    }

    private void setSpeed(){
       this.speed =  this.totalDistance/ this.timetaken;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getTotalTime() {
        return timetaken;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void getData(){
        System.out.println(this.getName() +"\nSpeed:" + this.speed + "\nDistance covered:" + totalDistance + "\nTotal time taken:" + timetaken +"\nMaxelevation: " + this.maxElevation +"\nMinelevation: "+ this.minElevation);
    }
}
