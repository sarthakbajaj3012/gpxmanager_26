package softwaredesign;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

import static javafx.application.Application.launch;


public class Main extends Application {
    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/softwaredesign/scene.fxml")));
            Scene scene = new Scene(root);

            stage.setTitle("JavaFX and Gradle");
            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

//        Integer i = 1;
//        GUI inter = new GUI();
////        User user = new User(inter.getInput("Name:"),Integer.parseInt(inter.getInput("age:")) ,inter.getInput("Gender:"),Integer.parseInt(inter.getInput("Height:")),Integer.parseInt(inter.getInput("Weight:")));
//        History buffer = new History();
////        inter.getOut().displaydata("Hello" + user.getName() );
//
//        do {
//            inter.getOut().displaydata("Choose from running and cycling or type exit for terminating");
//            Sports data = null;
//            String temp = inter.getIn().getScan();
//            if(temp.equalsIgnoreCase("running")) data = new Running();
//            else if(temp.equalsIgnoreCase("cycling")) data = new Cycling();
//            else {
//                if(!temp.equalsIgnoreCase("exit")) inter.getOut().displaydata("Invalid Sport!");;
//                System.exit(0);
//            }
//            data.setID(i);
//            i++;
//            buffer.add(data);
//            data.getData();
//        } while(i > 0);
}
