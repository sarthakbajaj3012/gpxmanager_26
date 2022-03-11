package softwaredesign;

import java.io.FileNotFoundException;


public class Main   {
    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Software Design");
        Integer i = 1;
        User user = new User();
        MetricsBuffer buffer = new MetricsBuffer();

        System.out.println("Hello,"+ user.getName());

        do {
            System.out.println("Choose from running and cycling or type exit for terminating");
            Input in = new Input();
            Sports data = null;
            String temp = in.getScan();
            if(temp.equalsIgnoreCase("running")) data = new Running();
            else if(temp.equalsIgnoreCase("cycling")) data = new Cycling();
            else {
                if(!temp.equalsIgnoreCase("exit")) System.out.println("Invalid sport!");
                System.exit(0);
            }
            data.setID(i);
            i++;
            buffer.add(data);
            data.getData();
        } while(i > 0);

    }



}
