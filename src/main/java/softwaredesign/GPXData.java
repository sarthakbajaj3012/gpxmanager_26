package softwaredesign;

import io.jenetics.jpx.GPX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GPXData {
    private FileInputStream file;
    private GPX gpx;


    public GPXData(String filepath) throws FileNotFoundException {

        this.file = new FileInputStream(filepath);
        try {
            this.gpx =  GPX.read(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GPX getgpx() {
        return this.gpx;
    }
}
