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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
/**
 *
 * @author sarts
 */
public class FillTheBlank1FXMLController implements Initializable {
    
     
    int flag=1;
    
    
     @FXML
    private ImageView opeButt;

    @FXML
    private ImageView elsButt;

    @FXML
    private ImageView arrcButt3;

    @FXML
    private ImageView condButt;

    @FXML
    private ImageView arrcButt2;

    @FXML
    private Label elsLab1;

    @FXML
    private Label arccLab1;

    @FXML
    private Label condLab1;

    @FXML
    private ImageView arrcButt4;

    @FXML
    private ImageView arrButt1;

    @FXML
    private Label arcLab1;

    @FXML
    private ImageView arrow1;

    @FXML
    private ImageView arrow2;

    @FXML
    private ImageView lampButt;

    @FXML
    private ImageView condButt1;

    @FXML
    private ImageView elsButt1;

    @FXML
    private ImageView arrBut1;

    @FXML
    private ImageView arrcBut3;

    @FXML
    private Label elsLab2;

    @FXML
    private Label condLab2;

    @FXML
    private Label arcLab2;

    @FXML
    private Label arccLab2;
     @FXML
    private ImageView hintButt;

       
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
    void clickButt2(MouseEvent event) {
      if(flag==1){
   correct();
    condButt1.setVisible(true);
    condLab2.setVisible(true);
    condButt.setVisible(false);
    condLab1.setVisible(false);
    
    flag=2;
    }
    else{
    wrong();
    }
    }
    @FXML
    void clicButt1(MouseEvent event) {
       if(flag==2){
   correct();
    elsButt1.setVisible(true);
    elsLab2.setVisible(true);
    elsLab1.setVisible(false);
    elsButt.setVisible(false);
    
    flag=3;
    }
    else{
   wrong();
    
    }
    }

    @FXML
    void clickAr1(MouseEvent event) {
     if(flag==3){
    correct();
    arrBut1.setVisible(true);
    arcLab2.setVisible(true);
    arrButt1.setVisible(false);
    arcLab1.setVisible(false);
    
    flag=4;
    }
    else{
   wrong();
    
    }
    }

    @FXML
    void clickAr3(MouseEvent event) {
    if(flag==4){
    correct();
    arrcBut3.setVisible(true);
    arccLab2.setVisible(true);
    arrcButt3.setVisible(false);
    arccLab1.setVisible(false);
    flag=5;
    if(flag==5){
      arrow2.setVisible(true);
      }
    }
    else{
   wrong();
    }
    }
    

    @FXML
    void clickArrow2(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("FillTheBlank2FXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           
//           Level1Controller controller= loader.getController();
//           controller.setUserName(username.getText());
           
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    
    @FXML
    void clickArrow1(MouseEvent event) throws IOException {
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
    void recEnArr1(MouseEvent event) {
      arrow1.setFitWidth(arrow1.getFitWidth()+5);
      arrow1.setFitHeight(arrow1.getFitHeight()+5);
    }

    @FXML
    void recEnArr2(MouseEvent event) {
       arrow2.setFitWidth(arrow1.getFitWidth()+5);
       arrow2.setFitHeight(arrow1.getFitHeight()+5);

    }

    @FXML
    void recEnLam(MouseEvent event) {
       hintButt.setVisible(true);
    }

    @FXML
    void recExArr1(MouseEvent event) {
      arrow1.setFitWidth(60);
      arrow1.setFitHeight(155);
    }

    @FXML
    void recExArr2(MouseEvent event) {
      arrow2.setFitWidth(95);
      arrow2.setFitHeight(72);
    }

    @FXML
    void recExLam(MouseEvent event) {
       hintButt.setVisible(false);
    }
    
    
    //-------
     @FXML
    void recEn1(MouseEvent event) {
           //balloon stage1
          elsButt.setFitWidth(elsButt.getFitWidth()+5);
          elsButt.setFitHeight(elsButt.getFitHeight()+5);
    }
    @FXML
    void recEn2(MouseEvent event) {
         //balloon stage2
          opeButt.setFitWidth(opeButt.getFitWidth()+5);
          opeButt.setFitHeight(opeButt.getFitHeight()+5);
    }
     @FXML
    void recEn3(MouseEvent event) {
         //balloon stage3
          condButt.setFitWidth(condButt.getFitWidth()+4);
          condButt.setFitHeight(condButt.getFitHeight()+4);
    }
    @FXML
    void recEn4(MouseEvent event) {
         //balloon stage4
          arrButt1.setFitWidth(arrButt1.getFitWidth()+5);
          arrButt1.setFitHeight(arrButt1.getFitHeight()+5);
    }
    @FXML
    void recEn5(MouseEvent event) {
         //balloon stage5
          arrcButt2.setFitWidth(arrcButt2.getFitWidth()+5);
          arrcButt2.setFitHeight(arrcButt2.getFitHeight()+5);
    }
    @FXML
    void recEn6(MouseEvent event) {
         //balloon stage6
          arrcButt3.setFitWidth(arrcButt3.getFitWidth()+5);
          arrcButt3.setFitHeight(arrcButt3.getFitHeight()+5);
    }
        @FXML
    void recEn7(MouseEvent event) {
         //balloon stage6
          arrcButt4.setFitWidth(arrcButt4.getFitWidth()+5);
          arrcButt4.setFitHeight(arrcButt4.getFitHeight()+5);
    }
    
    
    @FXML
    void recEx1(MouseEvent event) {
         //balloon stage1
          elsButt.setFitWidth(250);
          elsButt.setFitHeight(120);
    }
     @FXML
     void recEx2(MouseEvent event) {
      //balloon stage2
          opeButt.setFitWidth(238);
          opeButt.setFitHeight(125);
     }
      @FXML
     void recEx3(MouseEvent event) {
      //balloon stage2
          condButt.setFitWidth(250);
          condButt.setFitHeight(120);
     }
      @FXML
     void recEx4(MouseEvent event) {
      //balloon stage2
          arrButt1.setFitWidth(117);
          arrButt1.setFitHeight(120);
     }
      @FXML
     void recEx5(MouseEvent event) {
      //balloon stage2
          arrcButt2.setFitWidth(113);
          arrcButt2.setFitHeight(136);
     }
      @FXML
     void recEx6(MouseEvent event) {
      //balloon stage2
          arrcButt3.setFitWidth(115);
          arrcButt3.setFitHeight(142);
     }
     @FXML
     void recEx7(MouseEvent event) {
      //balloon stage2
          arrcButt4.setFitWidth(117);
          arrcButt4.setFitHeight(120);
     }
     
     //---------------------
        public void TranslateTransition(Duration duration, Node node){
//Instantiating TranslateTransition class 
TranslateTransition translate = new TranslateTransition(); 

//shifting the X coordinate of the centre of the circle by 400 
translate.setByX(-25); 

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
TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), arrow1);
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



TranslateTransition(Duration.seconds(0.9),arrow2);
TranslateTransition2(Duration.seconds(0.9),arrow1);

}
    
}
