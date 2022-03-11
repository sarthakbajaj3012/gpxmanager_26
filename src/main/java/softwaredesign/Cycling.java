package softwaredesign;

import java.io.FileNotFoundException;

public class Cycling extends Sports {

    public Cycling() throws FileNotFoundException {
        this.name = "Cycling";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
