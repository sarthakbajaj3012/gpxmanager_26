package softwaredesign.sports;

import softwaredesign.GPXData;

public class SportsFactory {

    public Sports getSports(String s , GPXData gpx){
        if(s.equalsIgnoreCase("Running")) return new Running(gpx);
        else if(s.equalsIgnoreCase("Cycling")) return new Cycling(gpx);
        else return null;
    }
}
