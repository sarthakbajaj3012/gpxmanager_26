package softwaredesign;

import java.io.FileNotFoundException;

public class Cycling extends Sports {

    public Cycling() throws FileNotFoundException {
    }

    @Override
    public String getName() {
        return "Cycling";
    }
}
