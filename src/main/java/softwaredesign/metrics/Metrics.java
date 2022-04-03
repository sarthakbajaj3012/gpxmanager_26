package softwaredesign.metrics;



public abstract class Metrics {
    public String name;
    public Double value;

    public Metrics(){

    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
