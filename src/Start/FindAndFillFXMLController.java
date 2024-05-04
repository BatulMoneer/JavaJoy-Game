/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

//mport test.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author albat
 */
public class FindAndFillFXMLController implements Initializable {
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    private String nameData ;
    private String usernameData ;
    private Parent root ;
    private Stage stage;
    private Scene scene;
    private TextField nameField;
    private TextField usernameField;
    private Label signupComment ;
    @FXML
    ImageView win ;
    @FXML
    private Button findAndFillIntButt;
    @FXML
    private ImageView findAndFillIntCircle;
    @FXML
    private Button findAndFillStringButt;
    @FXML
    private ImageView findAndFillStringCircle;
    @FXML
    private Button findAndFillDoubleButt;
    @FXML
    private ImageView findAndFillDoubleCircle;
    @FXML
    private Button findAndFillStringArrButt;
    @FXML
    private ImageView findAndFillStringArrCircle;
    private ImageView ffff;
    @FXML
    private ImageView nextImage;
    @FXML
    private Button nextButt;
    @FXML
    private ImageView helpIns;
    @FXML
    private ComboBox FindAndFillLevelOneDoubleCombobox;

    @FXML
    private ComboBox FindAndFillLevelOneIntCombobox;

    @FXML
    private ComboBox FindAndFillLevelOneStringArrCombobox;

    @FXML
    private ComboBox FindAndFillLevelOneStringCombobox;
    
    int findDone=0;
    int correct=0;
    
    @FXML
    private ImageView tryAgain;
    
    @FXML 
    private ImageView loon;
    
    @FXML
    private Button loonButt;
    
    @FXML
    private void loonButtPressed(ActionEvent event) throws Exception {
        //go to baloons
    }
    
    
    @FXML
    public void TranslateTransition(Duration duration, Node node){
//Instantiating TranslateTransition class 
TranslateTransition translate = new TranslateTransition(); 
//shifting the X coordinate of the centre of the circle by 400 
translate.setByX(-30); 
//setting the duration for the Translate transition 
 translate.setDuration(duration); 
//setting cycle count for the Translate transition 
translate.setCycleCount(500); 
//the transition will set to be auto reversed by setting this to true 
translate.setAutoReverse(true); 
//setting Circle as the node onto which the transition will be applied 
translate.setNode(node); 
//playing the transition 
translate.play(); 
}
    
    public void TranslateTransition2(Duration duration, Node node){
TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), loon);
        translateTransition.setFromY(0);
        translateTransition.setToY(-15);
        translateTransition.setInterpolator(Interpolator.LINEAR);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Animation.INDEFINITE);

        // Start the animation
        translateTransition.play();
}
    
    
    
    FadeTransition fade2 = new FadeTransition(Duration.seconds(0.5), tryAgain);
    @FXML
    private ImageView help;
    private void fade2(){
        fade2.setFromValue(0);
    fade2.setToValue(0.5);
    fade2.setOnFinished(event -> {
    PauseTransition pause2 = new PauseTransition(Duration.seconds(0.2));
    pause2.setOnFinished(event2 -> {
        FadeTransition fadeOut2 = new FadeTransition(Duration.seconds(3), tryAgain);
        fadeOut2.setFromValue(3);
        fadeOut2.setToValue(0);
        fadeOut2.play();
    });
    pause2.play();
    });
    
    }
    
    @FXML
    private ImageView goodJob;
    
    
    FadeTransition fade = new FadeTransition(Duration.seconds(0.5), goodJob);
    private void fade(){
        fade.setFromValue(0);
    fade.setToValue(0.5);
    fade.setOnFinished(event -> {
    PauseTransition pause = new PauseTransition(Duration.seconds(0.2));
    pause.setOnFinished(event2 -> {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), goodJob);
        fadeOut.setFromValue(3);
        fadeOut.setToValue(0);
        fadeOut.play();
    });
    pause.play();
    });
    }
    
    String voiceC = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Correct.m4a";     
        Media soundC = new Media(new File(voiceC).toURI().toString());
        MediaPlayer mediaPlayerC = new MediaPlayer(soundC);
        
    String voiceW = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Wrong.mp3";     
        Media soundW = new Media(new File(voiceW).toURI().toString());
        MediaPlayer mediaPlayerW = new MediaPlayer(soundW);
        
    String voiceF = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Found.mp3";     
        Media soundF = new Media(new File(voiceF).toURI().toString());
        MediaPlayer mediaPlayerF = new MediaPlayer(soundF);
        
    String voiceCl = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Click.mp3";     
        Media soundCl = new Media(new File(voiceCl).toURI().toString());
        MediaPlayer mediaPlayerCl = new MediaPlayer(soundCl);
    
    
    
    private void startPressed(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("SignupFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    private void signupPressed(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("SignupMenuFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    private void donePressed(ActionEvent event) throws Exception {
        if(nameField.getText().equals("") || usernameField.getText().equals("")){
            signupComment.setVisible(true);  
        }
        else{
            nameData = nameField.getText();
            usernameData = usernameField.getText();
            // The username must be unique in the database so it must be compared before accepting the user 
            signupComment.setText("Welcome "+nameData+"!");
            signupComment.setVisible(true);
            // it also must go to the next FXML interface
        }
    }
    @FXML
    private void findAndFillLevelOneIntClicked(ActionEvent event) throws Exception {
        findAndFillIntButt.setVisible(true);
        findAndFillIntCircle.setVisible(true);
        
        mediaPlayerF.play();
        mediaPlayerF.seek(mediaPlayerF.getStartTime());
        findDone++;
        
        if(findDone==4){
            FindAndFillLevelOneDoubleCombobox.setVisible(true);
            FindAndFillLevelOneIntCombobox.setVisible(true);
            FindAndFillLevelOneStringCombobox.setVisible(true);
            FindAndFillLevelOneStringArrCombobox.setVisible(true);
        }
    }
    @FXML
    private void findAndFillLevelOneStringClicked(ActionEvent event) throws Exception {
        findAndFillStringButt.setVisible(true);
        findAndFillStringCircle.setVisible(true);
        mediaPlayerF.play();
        mediaPlayerF.seek(mediaPlayerF.getStartTime());
        findDone++;
        if(findDone==4){
            FindAndFillLevelOneDoubleCombobox.setVisible(true);
            FindAndFillLevelOneIntCombobox.setVisible(true);
            FindAndFillLevelOneStringCombobox.setVisible(true);
            FindAndFillLevelOneStringArrCombobox.setVisible(true);
        }
    }
    @FXML
    private void findAndFillLevelOneDoubleClicked(ActionEvent event) throws Exception {
        findAndFillDoubleButt.setVisible(true);
        findAndFillDoubleCircle.setVisible(true);
        mediaPlayerF.play();
        mediaPlayerF.seek(mediaPlayerF.getStartTime());
        findDone++;
        if(findDone==4){
            FindAndFillLevelOneDoubleCombobox.setVisible(true);
            FindAndFillLevelOneIntCombobox.setVisible(true);
            FindAndFillLevelOneStringCombobox.setVisible(true);
            FindAndFillLevelOneStringArrCombobox.setVisible(true);
        }
    }
    @FXML
    private void findAndFillLevelOneStringArrClicked(ActionEvent event) throws Exception {
        findAndFillStringArrButt.setVisible(true);
        findAndFillStringArrCircle.setVisible(true);
        mediaPlayerF.play();
        mediaPlayerF.seek(mediaPlayerF.getStartTime());
        findDone++;
        if(findDone==4){
            FindAndFillLevelOneDoubleCombobox.setVisible(true);
            FindAndFillLevelOneIntCombobox.setVisible(true);
            FindAndFillLevelOneStringCombobox.setVisible(true);
            FindAndFillLevelOneStringArrCombobox.setVisible(true);
        }
    }
    
    
    @FXML
    private void findAndFillLevelOneIntButtClicked(ActionEvent event) throws Exception {
        findAndFillIntButt.setStyle("-fx-background-color: rgb(232, 132, 155 );");
        
    }
    
    @FXML
    private void findAndFillLevelOneStringButtClicked(ActionEvent event) throws Exception {
         findAndFillStringButt.setStyle("-fx-background-color: rgb(232, 132, 155 );");
    }
    @FXML
    private void findAndFillLevelOneDoubleButtClicked(ActionEvent event) throws Exception {
         findAndFillDoubleButt.setStyle("-fx-background-color: rgb(232, 132, 155 );");
    }
    @FXML
    private void findAndFillLevelOneStringArrButtClicked(ActionEvent event) throws Exception {
         findAndFillStringArrButt.setStyle("-fx-background-color: rgb(232, 132, 155 );");
        
    }
    
    @FXML
    void FindAndFillLevelOneDoubleComboboxChoose(ActionEvent event) {
            if(FindAndFillLevelOneDoubleCombobox.getValue().equals("double")){
                fade();
                fade.play();
                correct++;
                mediaPlayerC.play();
                mediaPlayerC.seek(mediaPlayerC.getStartTime());
                if(correct==4){
                    Check.Done();
                    nextButt.setDisable(false);
                    nextImage.setVisible(true);
                    win.setVisible(true);
                }
            }
            else{
                fade2();
                fade2.play();
                mediaPlayerW.play();
                mediaPlayerW.seek(mediaPlayerW.getStartTime());
            }
        
    }

    @FXML
    void FindAndFillLevelOneIntComboboxChoose(ActionEvent event) {
        if(FindAndFillLevelOneIntCombobox.getValue().equals("int")){
                fade();
                fade.play();
                correct++;
                mediaPlayerC.play();
                mediaPlayerC.seek(mediaPlayerC.getStartTime());
                if(correct==4){
                    Check.Done();
                    nextButt.setDisable(false);
                    nextImage.setVisible(true);
                    win.setVisible(true);
                }
            }
            else{
                fade2();
                fade2.play();
                mediaPlayerW.play();
                mediaPlayerW.seek(mediaPlayerW.getStartTime());
            }

    }

    @FXML
    void FindAndFillLevelOneStringArrComboboxChoose(ActionEvent event) {
        if(FindAndFillLevelOneStringArrCombobox.getValue().equals("String[]")){
                fade();
                fade.play();
                mediaPlayerC.play();
                mediaPlayerC.seek(mediaPlayerC.getStartTime());
                correct++;
                if(correct==4){
                    Check.Done();
                    nextButt.setDisable(false);
                    nextImage.setVisible(true);
                    win.setVisible(true);
                }
            }
            else{
                fade2();
                fade2.play();
                mediaPlayerW.play();
                mediaPlayerW.seek(mediaPlayerW.getStartTime());
            }

    }
    
    @FXML
    void nextKey(KeyEvent event)throws Exception{
        if(event.getCode() == KeyCode.RIGHT){
            mediaPlayerCl.play();
        mediaPlayerCl.seek(mediaPlayerCl.getStartTime());
         root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
        }
        
    }
    

    @FXML
    void FindAndFillLevelOneStringComboboxChoose(ActionEvent event) {
        if(FindAndFillLevelOneStringCombobox.getValue().equals("String")){
                fade();
                fade.play();
                mediaPlayerC.play();
                
                correct++;
                if(correct==4){
                    
                    Check.Done();
                    nextButt.setDisable(false);
                    nextImage.setVisible(true);
                    win.setVisible(true);
                }
            }
            else{
                fade2();
                fade2.play();
                mediaPlayerW.play();
                mediaPlayerW.seek(mediaPlayerW.getStartTime());
            }

    }
    
    @FXML
    void nextPressed(ActionEvent e) throws Exception{
        mediaPlayerCl.play();
        mediaPlayerCl.seek(mediaPlayerCl.getStartTime());
         root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }     
    double oldScaleX;
    double oldScaleY;
    @FXML
    void nextEntered(MouseEvent e){
        oldScaleX = nextImage.getScaleX();
        oldScaleY = nextImage.getScaleY();
        nextImage.setScaleX(1.2);
        nextImage.setScaleY(1.2);
    } 
    
    @FXML
    void nextExited(MouseEvent e){
        nextImage.setScaleX(oldScaleX);
        nextImage.setScaleY(oldScaleY);
    } 
    
    @FXML
    void helpEntered(MouseEvent e){
        helpIns.setVisible(true);
    }
    @FXML
    void helpExited(MouseEvent e){
        helpIns.setVisible(false);
    }
    @FXML
    void clickLoon(MouseEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("StagesFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
     @FXML
    void loonEn(MouseEvent event) {
      loon.setFitWidth(loon.getFitWidth()+5);
      loon.setFitHeight(loon.getFitHeight()+5);
    }
    @FXML
    void loonEx(MouseEvent event) {
      loon.setFitWidth(60);
      loon.setFitHeight(155);
    }
    



    @Override
    public void initialize(URL location, ResourceBundle resources) {
            ObservableList<String> list = FXCollections.observableArrayList("int", "String[]", "String", "double");
            FindAndFillLevelOneDoubleCombobox.setItems(list);
            FindAndFillLevelOneIntCombobox.setItems(list);
            FindAndFillLevelOneStringCombobox.setItems(list);
            FindAndFillLevelOneStringArrCombobox.setItems(list);
            
            TranslateTransition(Duration.seconds(0.9),nextImage);
            TranslateTransition2(Duration.seconds(0.9), loon);
    }
    
     
    
}
