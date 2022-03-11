package softwaredesign;

import java.io.FileNotFoundException;

public class Running extends Sports{

    public Running() throws FileNotFoundException {
        this.name = "Running";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
