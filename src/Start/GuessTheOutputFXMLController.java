/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * @author Manar Hasan Hakami
 */
public class GuessTheOutputFXMLController implements Initializable {
// ---------------------------------- scene1 ----------------------------------      
    @FXML
    private TextField t;
    
    @FXML
    private Button check;
    
    @FXML
    private Button next;
    
    @FXML
    private ImageView img;
    
    @FXML
    private ImageView arrow;
    
    @FXML
    private ImageView hint;
    
    @FXML
    private ImageView hintMsg;
    
    public void correct(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Correct.m4a";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
    public void wrong(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Wrong.mp3";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
    public void click(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Click.mp3";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
     private Parent root ;
    private Stage stage;
    private Scene scene;
    
    @FXML
    void buttonEvent(ActionEvent event){
            String input = t.getText();
            if(input.equalsIgnoreCase("error")) {
                correct();
            } else {
                wrong();
            }
    }
     @FXML
    void nextKey(KeyEvent event)throws Exception{
        if(event.getCode() == KeyCode.RIGHT){
           correct();
         root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
        }
        
    }
    
    @FXML
    public void onMouseEntered(MouseEvent event) {
        double newWidth = (img.getFitWidth()*1.1);
        double newHeight = (img.getFitHeight()*1.1);
        img.setFitWidth(newWidth);
        img.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited(MouseEvent event) {
        img.setFitWidth(61);
        img.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered2(MouseEvent event) {
        double newWidth = (arrow.getFitWidth()*1.1);
        double newHeight = (arrow.getFitHeight()*1.1);
        arrow.setFitWidth(newWidth);
        arrow.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited2(MouseEvent event) {
        arrow.setFitWidth(61);
        arrow.setFitHeight(58);
    }
    
    @FXML
    public void showHint(MouseEvent event) {
        hintMsg.setVisible(true);
    }
    
    @FXML
    public void dontShowHint(MouseEvent event) {
        hintMsg.setVisible(false);
    }
    
    @FXML
    public void scene2(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput2FXML.fxml"));
        Stage window = (Stage) next.getScene().getWindow();
        window.setScene(new Scene(root));
    }
// ---------------------------------- scene1 ----------------------------------  
    
// ---------------------------------- scene2 ----------------------------------   
    @FXML
    private TextField tS2;
    
    @FXML
    private Button checkS2;
    
    @FXML
    private Button nextS2;
    
    @FXML
    private Button backS2;
    
    @FXML
    private ImageView imgS2;
    
    @FXML
    private ImageView arrowS2;
    
    @FXML
    private ImageView backArrowS2;
    
    @FXML
    private ImageView hintS2;
    
    @FXML
    private ImageView hintMsgS2;
    
    @FXML
    void buttonEventS2(ActionEvent event){
            String input = tS2.getText();
            if (input.equalsIgnoreCase("java")) {
                correct();
            } else {
                wrong();
            }
    }
    
    @FXML
    public void onMouseEnteredS2(MouseEvent event) {
        double newWidth = (imgS2.getFitWidth()*1.1);
        double newHeight = (imgS2.getFitHeight()*1.1);
        imgS2.setFitWidth(newWidth);
        imgS2.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExitedS2(MouseEvent event) {
        imgS2.setFitWidth(61);
        imgS2.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered2S2(MouseEvent event) {
        double newWidth = (arrowS2.getFitWidth()*1.1);
        double newHeight = (arrowS2.getFitHeight()*1.1);
        arrowS2.setFitWidth(newWidth);
        arrowS2.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited2S2(MouseEvent event) {
        arrowS2.setFitWidth(61);
        arrowS2.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered3S2(MouseEvent event) {
        double newWidth = (backArrowS2.getFitWidth()*1.1);
        double newHeight = (backArrowS2.getFitHeight()*1.1);
        backArrowS2.setFitWidth(newWidth);
        backArrowS2.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited3S2(MouseEvent event) {
        backArrowS2.setFitWidth(61);
        backArrowS2.setFitHeight(58);
    }
    
    @FXML
    public void showHintS2(MouseEvent event) {
        hintMsgS2.setVisible(true);
    }
    
    @FXML
    public void dontShowHintS2(MouseEvent event) {
        hintMsgS2.setVisible(false);
    }
    
    @FXML
    public void scene1(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput1FXML.fxml"));
        Stage window = (Stage) backS2.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void scene3(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput3FXML.fxml"));
        Stage window = (Stage) nextS2.getScene().getWindow();
        window.setScene(new Scene(root));
    }    
// ---------------------------------- scene2 ----------------------------------
    
// ---------------------------------- scene3 ----------------------------------    
    @FXML
    private TextField tS3;
    
    @FXML
    private Button checkS3;
    
    @FXML
    private Button nextS3;
    
    @FXML
    private Button backS3;
    
    @FXML
    private ImageView imgS3;
    
    @FXML
    private ImageView arrowS3;
    
    @FXML
    private ImageView backArrowS3;
    
    @FXML
    private ImageView hintS3;
    
    @FXML
    private ImageView hintMsgS3;
    
    @FXML
    void buttonEventS3(ActionEvent event){
            String input = tS3.getText();
            if (input.equalsIgnoreCase("1+25")) {
                correct();
            } else {
                wrong();
            }
    }
    
    @FXML
    public void onMouseEnteredS3(MouseEvent event) {
        double newWidth = (imgS3.getFitWidth()*1.1);
        double newHeight = (imgS3.getFitHeight()*1.1);
        imgS3.setFitWidth(newWidth);
        imgS3.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExitedS3(MouseEvent event) {
        imgS3.setFitWidth(61);
        imgS3.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered2S3(MouseEvent event) {
        double newWidth = (arrowS3.getFitWidth()*1.1);
        double newHeight = (arrowS3.getFitHeight()*1.1);
        arrowS3.setFitWidth(newWidth);
        arrowS3.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited2S3(MouseEvent event) {
        arrowS3.setFitWidth(61);
        arrowS3.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered3S3(MouseEvent event) {
        double newWidth = (backArrowS3.getFitWidth()*1.1);
        double newHeight = (backArrowS3.getFitHeight()*1.1);
        backArrowS3.setFitWidth(newWidth);
        backArrowS3.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited3S3(MouseEvent event) {
        backArrowS3.setFitWidth(61);
        backArrowS3.setFitHeight(58);
    }
    
    @FXML
    public void showHintS3(MouseEvent event) {
        hintMsgS3.setVisible(true);
    }
    
    @FXML
    public void dontShowHintS3(MouseEvent event) {
        hintMsgS3.setVisible(false);
    }
    
    @FXML
    public void scene2S3(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput2FXML.fxml"));
        Stage window = (Stage) backS3.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void scene4(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput4FXML.fxml"));
        Stage window = (Stage) nextS3.getScene().getWindow();
        window.setScene(new Scene(root));
    }    
// ---------------------------------- scene3 ----------------------------------
    
// ---------------------------------- scene4 ----------------------------------   
    @FXML
    private TextField tS4;
    
    @FXML
    private Button checkS4;
    
    @FXML
    private Button nextS4;
    
    @FXML
    private Button backS4;
    
    @FXML
    private ImageView imgS4;
    
    @FXML
    private ImageView arrowS4;
    
    @FXML
    private ImageView backArrowS4;
    
    @FXML
    private ImageView hintS4;
    
    @FXML
    private ImageView hintMsgS4;
    
    @FXML
    void buttonEventS4(ActionEvent event){
            String input = tS4.getText();
            if(input.equalsIgnoreCase("error")) {
                correct();
            } else {
                wrong();
            }
    }
    
    @FXML
    public void onMouseEnteredS4(MouseEvent event) {
        double newWidth = (imgS4.getFitWidth()*1.1);
        double newHeight = (imgS4.getFitHeight()*1.1);
        imgS4.setFitWidth(newWidth);
        imgS4.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExitedS4(MouseEvent event) {
        imgS4.setFitWidth(61);
        imgS4.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered2S4(MouseEvent event) {
        double newWidth = (arrowS4.getFitWidth()*1.1);
        double newHeight = (arrowS4.getFitHeight()*1.1);
        arrowS4.setFitWidth(newWidth);
        arrowS4.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited2S4(MouseEvent event) {
        arrowS4.setFitWidth(61);
        arrowS4.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered3S4(MouseEvent event) {
        double newWidth = (backArrowS4.getFitWidth()*1.1);
        double newHeight = (backArrowS4.getFitHeight()*1.1);
        backArrowS4.setFitWidth(newWidth);
        backArrowS4.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited3S4(MouseEvent event) {
        backArrowS4.setFitWidth(61);
        backArrowS4.setFitHeight(58);
    }
    
    @FXML
    public void showHintS4(MouseEvent event) {
        hintMsgS4.setVisible(true);
    }
    
    @FXML
    public void dontShowHintS4(MouseEvent event) {
        hintMsgS4.setVisible(false);
    }
    
    @FXML
    public void scene3S4(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput3FXML.fxml"));
        Stage window = (Stage) backS4.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void scene5(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput5FXML.fxml"));
        Stage window = (Stage) nextS4.getScene().getWindow();
        window.setScene(new Scene(root));
    }   
// ---------------------------------- scene4 ----------------------------------
    
// ---------------------------------- scene5 ----------------------------------   
    @FXML
    private TextField tS5;
    
    @FXML
    private Button checkS5;
    
    @FXML
    private Button backS5;
    
    @FXML
    private ImageView imgS5;
    
    @FXML
    private ImageView backArrowS5;
    
    @FXML
    private ImageView winS5;
    
    @FXML
    private ImageView nS5;
    
    @FXML
    private ImageView bS5;
    
    @FXML
    private ImageView hintS5;
    
    @FXML
    private ImageView hintMsgS5;
    
    @FXML
    private ImageView ballonS5;
    
    @FXML
    void buttonEventS5(ActionEvent event){
            String input = tS5.getText();
            if(input.equalsIgnoreCase("nothing")) {
                correct();
                winS5.setVisible(true);
                nS5.setVisible(true);
                Check.Done();
                Check.setStage(3);
            } else {
                wrong();
            }
    }
    
        double oldScaleX;
    double oldScaleY;
    @FXML
    void nextEntered(MouseEvent e){
        oldScaleX = nS5.getScaleX();
        oldScaleY = nS5.getScaleY();
        nS5.setScaleX(1.2);
        nS5.setScaleY(1.2);
    } 
    
    @FXML
    void nextExited(MouseEvent e){
        nS5.setScaleX(oldScaleX);
        nS5.setScaleY(oldScaleY);
    } 
    
     @FXML
    public void TranslateTransition2(Duration duration, Node node){
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
    
    
    @FXML
     void goBackS1(MouseEvent event) throws Exception {
        click();
       FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("StagesFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
     }
     
     // here is the code of going to the next stage (STAGE 4)
     
     @FXML
   void goNextStage(MouseEvent event) throws Exception {
       
       click();
       Parent root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
     Stage window = (Stage) nS5.getScene().getWindow();
       window.setScene(new Scene(root));
    }
     
     public void TranslateTransition(Duration duration, Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), ballonS5);
        translateTransition.setFromY(0);
        translateTransition.setToY(-15);
        translateTransition.setInterpolator(Interpolator.LINEAR);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Animation.INDEFINITE);

        // Start the animation
        translateTransition.play();
}

    
    @FXML
    public void onMouseEnteredS5(MouseEvent event) {
        double newWidth = (imgS5.getFitWidth()*1.1);
        double newHeight = (imgS5.getFitHeight()*1.1);
        imgS5.setFitWidth(newWidth);
        imgS5.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExitedS5(MouseEvent event) {
        imgS5.setFitWidth(61);
        imgS5.setFitHeight(58);
    }
    
    @FXML
    public void onMouseEntered3S5(MouseEvent event) {
        double newWidth = (backArrowS5.getFitWidth()*1.1);
        double newHeight = (backArrowS5.getFitHeight()*1.1);
        backArrowS5.setFitWidth(newWidth);
        backArrowS5.setFitHeight(newHeight);
    }

    @FXML
    public void onMouseExited3S5(MouseEvent event) {
        backArrowS5.setFitWidth(61);
        backArrowS5.setFitHeight(58);
    }
    
    @FXML
    public void showHintS5(MouseEvent event) {
        hintMsgS5.setVisible(true);
    }
    
    @FXML
    public void dontShowHintS5(MouseEvent event) {
        hintMsgS5.setVisible(false);
    }
    
    // here is the code of going to the ballons page
    
    @FXML
   public void clickBallon(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
       Stage window = (Stage) backS5.getScene().getWindow();
       window.setScene(new Scene(root));
    }
    
    @FXML
    public void scene4S5(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("GuessTheOutput4FXML.fxml"));
        Stage window = (Stage) backS5.getScene().getWindow();
        window.setScene(new Scene(root));
    } 
// ---------------------------------- scene5 ----------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition(Duration.seconds(0.9),ballonS5);
         TranslateTransition2(Duration.seconds(0.9),nS5);
    }    
}
