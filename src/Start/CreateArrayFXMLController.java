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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class CreateArrayFXMLController implements Initializable {

   @FXML
    private ImageView rec1;
    @FXML
    private ImageView rec2;
    @FXML
    private ImageView rec3;
    @FXML
    private ImageView rec4;
    @FXML
    private ImageView wrong;
    @FXML
    private ImageView right;
    @FXML
    private ImageView exit;
    @FXML
    private ImageView exit2;
    @FXML
    private ImageView next;
    @FXML
    private ImageView back;
    @FXML
    private ImageView hint;
    @FXML
    private ImageView hintWindow;
    @FXML
    private ImageView win;
   
    
    @FXML
    private Button b1; // for rec1
    @FXML
    private Button b2; // for rec1
    @FXML
    private Button b3; // for rec3
    @FXML
    private Button b4; // for rec4
    @FXML
    private Button b5; // right/correct window exit button
    @FXML
    private Button b6 = new Button(); // next button
    @FXML
    private Button b7; // wrong window exit button
    @FXML
    private Button b8; // back button
    @FXML
    private Button b9; // hint button
    
     @FXML
    private ImageView loon;
    
   
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
    void hintEntered() {
        
           b9.setOnMouseEntered(e -> {
            hintWindow.setVisible(true);
            });
    }
    
    @FXML
    void hintExited() {
        
           b9.setOnMouseExited(e -> {
            hintWindow.setVisible(false);
            });
    }
    
    @FXML
    void bigger() {
        
           b1.setOnMouseEntered(e -> {
            rec1.setFitWidth(rec1.getFitWidth() + 15);
            rec1.setFitHeight(rec1.getFitHeight() + 15);
            });
    }
    
    @FXML
    void smaller() {
        
           b1.setOnMouseExited(e -> {
            rec1.setFitWidth(rec1.getFitWidth() - 15);
            rec1.setFitHeight(rec1.getFitHeight() - 15);
          
            });
    }
          
    @FXML
    void clicked() {
        click();
            b1.setOnAction(e -> {
            correct();
            right.setVisible(true);
            exit.setVisible(true);
            b5.setVisible(true);
            
       
            });
        }
    
    
    @FXML
    void RightExit() {
            b5.setOnAction(e -> {
            right.setVisible(false);
            exit.setVisible(false);
            b5.setVisible(false);
            next.setVisible(true);
            win.setVisible(true);
            b6.setVisible(true);
            });
        }
    
     @FXML
    void WrongExit() {
            b7.setOnAction(e -> {
            wrong.setVisible(false);
            exit2.setVisible(false);
            b7.setVisible(false);
            next.setVisible(false);
            b6.setVisible(false);
            });
        }
    
 
    @FXML
    void bigger2() {
        
           b2.setOnMouseEntered(e -> {
            rec2.setFitWidth(rec2.getFitWidth() + 15);
            rec2.setFitHeight(rec2.getFitHeight() + 15);
            });
    }
    
    @FXML
    void smaller2() {
        
           b2.setOnMouseExited(e -> {
            rec2.setFitWidth(rec2.getFitWidth() - 15);
            rec2.setFitHeight(rec2.getFitHeight() - 15);
            });
    }
          
    @FXML
    void clicked2() {
        click();
            b2.setOnAction(e -> {
            wrong();
            wrong.setVisible(true);
            exit2.setVisible(true);
            b7.setVisible(true);
            next.setVisible(false);
            b6.setVisible(false);
            }); 
           
        }
    
  //////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    void bigger3() {
        
           b3.setOnMouseEntered(e -> {
            rec3.setFitWidth(rec3.getFitWidth() + 15);
            rec3.setFitHeight(rec3.getFitHeight() + 15);
            });
    }
    
    @FXML
    void smaller3() {
        
           b3.setOnMouseExited(e -> {
            rec3.setFitWidth(rec3.getFitWidth() - 15);
            rec3.setFitHeight(rec3.getFitHeight() - 15);
            });
    }
          
    @FXML
    void clicked3() {
        click();
            b3.setOnAction(e -> {
            wrong();
            wrong.setVisible(true);
            exit2.setVisible(true);
            b7.setVisible(true); // wrong answer window exit
            next.setVisible(false);
            b6.setVisible(false); // next button
            }); 
        }
    
   
    //////////////////////////////////////////////////////////////////////////////////////
    
     
    @FXML
    void bigger4() {
        
           b4.setOnMouseEntered(e -> {
            rec4.setFitWidth(rec4.getFitWidth() + 15);
            rec4.setFitHeight(rec4.getFitHeight() + 15);
            });
    }
    
    @FXML
    void smaller4() {
        
           b4.setOnMouseExited(e -> {
            rec4.setFitWidth(rec4.getFitWidth() - 15);
            rec4.setFitHeight(rec4.getFitHeight() - 15);
            });
    }
          
    @FXML
    void clicked4() {
        click();
            b4.setOnAction(e -> {
            wrong();
            wrong.setVisible(true);
            exit2.setVisible(true);
            b7.setVisible(true);
            next.setVisible(false);
            b6.setVisible(false);
            }); 
        }
    
    private Parent root ;
    private Stage stage;
    private Scene scene;
    
    @FXML
    void nextPressed(MouseEvent e) throws Exception{
        click();
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
        oldScaleX = next.getScaleX();
        oldScaleY = next.getScaleY();
        next.setScaleX(1.2);
        next.setScaleY(1.2);
    } 
    
    @FXML
    void nextExited(MouseEvent e){
        next.setScaleX(oldScaleX);
        next.setScaleY(oldScaleY);
    } 
    
    @FXML
    void helpEntered(MouseEvent e){
        hintWindow.setVisible(true);
    }
    @FXML
    void helpExited(MouseEvent e){
        hintWindow.setVisible(false);
    }
    @FXML
    void clickLoon(MouseEvent event) throws IOException {
        click();
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
      loon.setFitWidth(88);
      loon.setFitHeight(157);
    }
   
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
TranslateTransition(Duration.seconds(0.9),next);
TranslateTransition2(Duration.seconds(0.9),loon);
 
    }    
      
    
}

