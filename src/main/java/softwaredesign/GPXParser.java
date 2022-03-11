package softwaredesign;


import io.jenetics.jpx.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GPXParser {
    private FileInputStream file;
    private GPX gpx;


    public GPXParser() throws FileNotFoundException {
        Input in = new Input();
        System.out.println("Enter FilePath:");
        String filepath = in.getScan();
        this.file = new FileInputStream(filepath);
        try {
            this.gpx =  GPX.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GPX getGpx() {
        return this.gpx;
    }
}
