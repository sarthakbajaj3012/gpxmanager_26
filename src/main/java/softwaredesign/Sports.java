package softwaredesign;


import softwaredesign.metrics.Metrics;

import java.util.ArrayList;

public abstract class Sports {
    public String name ="Sports" ;
    private ArrayList<Metrics> metrics = new ArrayList<Metrics>();
    private Map map;

    public ArrayList<Metrics> getMetrics() {
        return metrics;
    }
}
