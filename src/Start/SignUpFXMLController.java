/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class SignUpFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Button signUpButt;
    
     @FXML
    private Button goHome;
         
          private Parent root ;
    private Stage stage;
    private Scene scene;
    
     public void click(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Click.mp3";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
    @FXML
    void goHomeClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void signUpButtPressed(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("SignUpMenuFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Label label;
    @FXML
    private ImageView sinin;
    @FXML
    private Button login;

    @FXML
    private void loginclick(ActionEvent event) throws IOException {
        click();
    Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));        
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
//    Parent root = FXMLLoader.load(getClass().getResource("enterLogin.fxml"));
//        Stage stage = (Stage) next.getScene().getWindow();
//        stage.setScene(new Scene(root));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
