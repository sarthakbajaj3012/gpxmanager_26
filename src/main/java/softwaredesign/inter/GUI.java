package softwaredesign.inter;

public class GUI {
    private Input in;
    private Output out;

    public GUI(){
        in = new Input();
        out = new Output();
    }

    public Input getIn() {
        return in;
    }

    public Output getOut() {
        return out;
    }

    public String getInput(String data){
        out.displaydata(data);
        return in.getScan();
    }
}
