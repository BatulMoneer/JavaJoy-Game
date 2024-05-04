/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author sarts
 */
public class FillTheBlank2FXMLController implements Initializable {

   @FXML
    private ImageView numButt;

    @FXML
    private Label numTex1;
    //------for label(the number is 0)
     @FXML
    private Label numTex2;
      @FXML
    private Label numText2;
       @FXML
    private ImageView numButt2;
       @FXML
    private Label numTe2;
       @FXML
    private Label numTe;
    //------
     @FXML
    private ImageView numButt3;
    
    @FXML
    private ImageView arcButt1;
    @FXML
    private ImageView arcButt2;
    @FXML
    private ImageView arcButt3;
    @FXML
    private ImageView arcButt4;
    //---
      @FXML
    private ImageView lampButt;
       @FXML
    private ImageView hintButt;
    //---
    @FXML
    private ImageView win;
    //---
    @FXML
    private ImageView bt1;
    @FXML
    private ImageView bt2;
    @FXML
    private ImageView bt3;
     @FXML
    private ImageView bt4;
     //---
    @FXML
    private ImageView arrow1;
    @FXML
    private ImageView arrow2;
    //---
    @FXML
    private Label numTex;
    //----
     @FXML
    private Label arrc1;
     @FXML
    private Label arrcLab1;
     //----
     
      //----
     @FXML
    private Label arrc2;
     @FXML
    private Label arrcLab2;
     //----
      @FXML
    private ImageView loon;
    
    int flag=1;
    
    
    
     
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
    void clickNum(MouseEvent event) {
    if(flag==1){
    correct();
    bt1.setVisible(true);
    numTex1.setVisible(true);
    numButt.setVisible(false);
    numTex.setVisible(false);
    
    flag=2;
    }
    else{
    wrong();
        
    
    }
    }//end method clickNum
    
    
     @FXML
    void clickArc1(MouseEvent event) {
     if(flag==2){
    correct();
      bt2.setVisible(true);
      arcButt1.setVisible(false); 
      arrc1.setVisible(true);
      arrcLab1.setVisible(false);
      
      flag=3;
     }
     else{
     wrong();
    }
    }//end method clickArc1
    
    @FXML
    void clickArc2(MouseEvent event) {
     if(flag==3){
       correct();
      bt3.setVisible(true);
      arcButt2.setVisible(false); 
      arrc2.setVisible(true);
      arrcLab2.setVisible(false);
      
      flag=4;
     }
     else{
   wrong();
    }
    }//end method clickArc2
    
    
     @FXML
    void clickNum2(MouseEvent event) {
    if(flag==4){
        
   correct();
    bt4.setVisible(true);
    numTex2.setVisible(false);
    numText2.setVisible(false);
    numButt2.setVisible(false);
    numTe.setVisible(true);
    numTe2.setVisible(true);
    flag=5;
    if(flag==5){
    arrow2.setVisible(true);
    Check.Done();
    win.setVisible(true);
    Check.setStage(4);
     
        

    }
    
    }
    else{
    wrong();
    
    }
    
    }//end method clickNum2
    
    
     @FXML
    void clickArrow1(MouseEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("StagesFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           
//           Level1Controller controller= loader.getController();
//           controller.setUserName(username.getText());
           
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    
    @FXML
    void clickArrow2(MouseEvent event) throws IOException {
        click();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("FillTheBlank1FXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           
//           Level1Controller controller= loader.getController();
//           controller.setUserName(username.getText());
           
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    
    
    
    
    
    //-------
     @FXML
    void recEn1(MouseEvent event) {
           //balloon stage1
          numButt.setFitWidth(numButt.getFitWidth()+5);
          numButt.setFitHeight(numButt.getFitHeight()+5);
    }
    @FXML
    void recEn2(MouseEvent event) {
         //balloon stage2
          numButt3.setFitWidth(numButt3.getFitWidth()+5);
          numButt3.setFitHeight(numButt3.getFitHeight()+5);
    }
     @FXML
    void recEn3(MouseEvent event) {
         //balloon stage3
          numButt2.setFitWidth(numButt2.getFitWidth()+4);
          numButt2.setFitHeight(numButt2.getFitHeight()+4);
    }
    @FXML
    void recEn4(MouseEvent event) {
         //balloon stage4
          arcButt1.setFitWidth(arcButt1.getFitWidth()+5);
          arcButt1.setFitHeight(arcButt1.getFitHeight()+5);
    }
    @FXML
    void recEn5(MouseEvent event) {
         //balloon stage5
          arcButt3.setFitWidth(arcButt3.getFitWidth()+5);
          arcButt3.setFitHeight(arcButt3.getFitHeight()+5);
    }
    @FXML
    void recEn6(MouseEvent event) {
         //balloon stage6
          arcButt2.setFitWidth(arcButt2.getFitWidth()+5);
          arcButt2.setFitHeight(arcButt2.getFitHeight()+5);
    }
        @FXML
    void recEn7(MouseEvent event) {
         //balloon stage6
          arcButt4.setFitWidth(arcButt4.getFitWidth()+5);
          arcButt4.setFitHeight(arcButt4.getFitHeight()+5);
    }
    
    
    @FXML
    void recEx1(MouseEvent event) {
         //balloon stage1
          numButt.setFitWidth(250);
          numButt.setFitHeight(120);
    }
     @FXML
     void recEx2(MouseEvent event) {
      //balloon stage2
          numButt3.setFitWidth(238);
          numButt3.setFitHeight(125);
     }
      @FXML
     void recEx3(MouseEvent event) {
      //balloon stage2
          numButt2.setFitWidth(250);
          numButt2.setFitHeight(120);
     }
      @FXML
     void recEx4(MouseEvent event) {
      //balloon stage2
          arcButt1.setFitWidth(117);
          arcButt1.setFitHeight(120);
     }
      @FXML
     void recEx5(MouseEvent event) {
      //balloon stage2
          arcButt3.setFitWidth(113);
          arcButt3.setFitHeight(136);
     }
      @FXML
     void recEx6(MouseEvent event) {
      //balloon stage2
          arcButt2.setFitWidth(115);
          arcButt2.setFitHeight(142);
     }
     @FXML
     void recEx7(MouseEvent event) {
      //balloon stage2
          arcButt4.setFitWidth(117);
          arcButt4.setFitHeight(120);
     }
     
     //---------------------
     @FXML
     void recEnArr1(MouseEvent event) {
         //balloon stage3
          arrow1.setFitWidth(arrow1.getFitWidth()+5);
          arrow1.setFitHeight(arrow1.getFitHeight()+5);
    }
     
     @FXML
    void recExArr1(MouseEvent event) {
      //balloon stage2
          arrow1.setFitWidth(95);
          arrow1.setFitHeight(72);
     }
     @FXML
     void recEnArr2(MouseEvent event) {
         //balloon stage3
          arrow2.setFitWidth(arrow2.getFitWidth()+5);
          arrow2.setFitHeight(arrow2.getFitHeight()+5);
    }
     
     @FXML
    void recExArr2(MouseEvent event) {
      //balloon stage2
          arrow2.setFitWidth(95);
          arrow2.setFitHeight(72);
     }
     
     
     
    //-------------
    
    @FXML
    void recEnLam(MouseEvent event) {
       hintButt.setVisible(true);
    }
    @FXML
    void recExLam(MouseEvent event) {
       hintButt.setVisible(false);
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


TranslateTransition(Duration.seconds(0.9),arrow1);
TranslateTransition(Duration.seconds(0.9),arrow2);
TranslateTransition2(Duration.seconds(0.9),loon);


}


    
}

