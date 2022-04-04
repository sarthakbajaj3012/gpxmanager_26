package softwaredesign.sports;


import softwaredesign.GPXData;
import softwaredesign.metrics.*;
import softwaredesign.sports.Sports;

import java.util.ArrayList;


public class Running extends Sports {

    public Running(GPXData gpx){
        super.name = "Running";
            ArrayList<Metrics> metrics = getMetrics();
            metrics.add(new Distance(gpx));
            metrics.add(new Time(gpx));
            metrics.add(new Speed(metrics.get(0).value, metrics.get(1).value));
            metrics.add(new MaxElevation(gpx));
            metrics.add(new MinElevation(gpx));
    }

}
