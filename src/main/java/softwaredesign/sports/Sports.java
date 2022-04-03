package softwaredesign.sports;


import softwaredesign.Map;
import softwaredesign.metrics.Metrics;

import java.util.ArrayList;

public abstract class Sports {
    public String name ="Sports" ;
    private ArrayList<Metrics> metrics = new ArrayList<Metrics>();
    private Map map;

    public ArrayList<Metrics> getMetrics() {
        return metrics;
    }

    public  String printdata(){
        StringBuilder s = new StringBuilder();
        for (Metrics metric : metrics) {
            s.append(metric.name).append(": ").append(metric.value.toString()).append("\n");
        }
        return s.toString();
    }
}
