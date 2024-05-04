/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author wasse
 */
public class WhichIsTrueFXMLController implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Label label;
    @FXML
    private ImageView image;
    @FXML
    private Button next1;
    @FXML
    private ImageView hintmass;
    @FXML
    private ImageView lamb;
    @FXML
    private ImageView palon2;

     
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
    @FXML
    public void trueFor1(ActionEvent event) throws IOException {
        wrong();
        Parent root = FXMLLoader.load(getClass().getResource("false.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void falseFor1(ActionEvent event) throws IOException {
        correct();
        Parent root = FXMLLoader.load(getClass().getResource("true.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    public void next1(ActionEvent event) throws IOException {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrue2FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
//=====================================================================================

    @FXML
    public void trueFor2(ActionEvent event) throws IOException {
        wrong();
        Parent root = FXMLLoader.load(getClass().getResource("false2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void falseFor2(ActionEvent event) throws IOException {
        correct();
        Parent root = FXMLLoader.load(getClass().getResource("true2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void next2(ActionEvent event) throws IOException {
  click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrue3FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
     public void befor2(ActionEvent event) throws IOException {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrueFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//================================================================================
    @FXML
    public void trueFor3(ActionEvent event) throws IOException {
        correct();
        Parent root = FXMLLoader.load(getClass().getResource("true3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void next3(ActionEvent event) throws IOException {
          click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrue4FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void falseFor3(ActionEvent event) throws IOException {
        wrong();
        Parent root = FXMLLoader.load(getClass().getResource("false3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
 public void befor3(ActionEvent event) throws IOException {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrue2FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //=====================================================================================
    @FXML
    public void trueFor5(ActionEvent event) throws IOException {
        Check.setStage(2);
        Check.Done();
        correct();
        Parent root = FXMLLoader.load(getClass().getResource("true4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void falseFor5(ActionEvent event) throws IOException {
        Check.setStage(2);
        Check.Done();
        wrong();
        Parent root = FXMLLoader.load(getClass().getResource("false4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    public void laststage5(ActionEvent event) throws IOException {
          click();
        Parent root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }

    @FXML
    public void befor5(ActionEvent event) throws IOException {
          click();
        Parent root = FXMLLoader.load(getClass().getResource("WhichIsTrue3FXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //==========================================
    @FXML
    public void showHintS5(MouseEvent event) {
        hintmass.setVisible(true);
    }

    @FXML
    public void dontShowHintS5(MouseEvent event) {
        hintmass.setVisible(false);
    }
//===========================================
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
      palon2.setFitWidth(palon2.getFitWidth()+5);
      palon2.setFitHeight(palon2.getFitHeight()+5);
    }
    @FXML
    void loonEx(MouseEvent event) {
      palon2.setFitWidth(60);
      palon2.setFitHeight(155);
    }
    
    public void TranslateTransition(Duration duration, Node node) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), palon2);
        translateTransition.setFromY(0);
        translateTransition.setToY(-15);
        translateTransition.setInterpolator(Interpolator.LINEAR);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Animation.INDEFINITE);

        // Start the animation
        translateTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition(Duration.seconds(0.9),palon2);
    }

}
