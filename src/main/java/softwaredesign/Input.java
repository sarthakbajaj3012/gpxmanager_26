package softwaredesign;

import java.util.Scanner;

public class Input {
    private Scanner scan;

    public Input(){
        this.scan = new Scanner(System.in);
    }

    public String getScan() {
        return scan.nextLine();
    }
}
