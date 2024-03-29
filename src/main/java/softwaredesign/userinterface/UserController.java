package softwaredesign.userinterface;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import softwaredesign.User;

public class UserController implements Initializable {
    @FXML
    private  Label label1;

    @FXML
    private  Label label2;

    @FXML
    private  Label label3;

    @FXML
    private  Label label4;

    @FXML
    private  Label label5;

    @FXML
    private Button button1;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private ChoiceBox text3;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private User user;


    public void setUser(ActionEvent e) throws IOException {
        this.user = new User(text1.getText(),Integer.parseInt(text2.getText()),
                text3.getValue().toString(),Integer.parseInt(text4.getText()),Integer.parseInt(text5.getText()));
        System.out.println(user.getGender());
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/softwaredesign/fileinterface.fxml")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text3.setItems(FXCollections.observableArrayList("Male","Female"));
    }
}

