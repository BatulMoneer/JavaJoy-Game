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
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.util.*;

public class ColoringLoopsFXMLController implements Initializable {

    @FXML
    private Button JavaJoy;
    
     @FXML
    private Button FeedBack;
     
      @FXML
    private Button Music;
      
       @FXML
    private Button Account;
       
       @FXML 
       private Button settings;
    
     @FXML
      private Button aboutUs;
      
     
   @FXML 
    private Slider slider;
    
    @FXML
    private Label sliderLabel;//for the slider label ( appear based on used choise )
   
    @FXML 
    private Label hint1 = new Label("");//hint for the game if the answer is not correct or correct
    
     @FXML 
    private Label hint2;//hint for the game if the answer is not correct or correct
    
      @FXML 
    private Label hint3;//hint for the game if the answer is not correct or correct
    
      
       @FXML 
    private Label hint4;//hint for the game if the answer is not correct or correct
    
    @FXML
    private TextArea code1;//Text Area for the first code 
    
     @FXML
    private TextArea code2;//Text Area for the second code 
     
     
      @FXML
    private TextArea code3;//Text Area for the third code 
      
       @FXML
    private TextArea code4;//Text Area for the fourth code 
       
     @FXML
    private ComboBox <String> c1;//colors for the first code 
    
     @FXML
    private ComboBox <String> c2;//colors for the second code 
     
      @FXML
    private ComboBox <String> c3;//colors for the third code 
      
      @FXML
    private ComboBox <String> c4;//colors for the fourth code 
      
     
      @FXML 
      private ImageView deleteCode;
      
      @FXML
      private ImageView saveCode;
      
      @FXML 
      private Label QuestionHint=new Label();
      
       
      @FXML
      private ImageView nextImage;
      
      @FXML
      private Button nextButt;
      
     
      @FXML 
      private ImageView next;
      
      @FXML 
              private ImageView ballon;
      
      @FXML 
              private ImageView Win;
      boolean mute=false;//the music is not muted 
      
      public void TranslateTransition(Duration duration, Node node){
//Instantiating TranslateTransition class 
javafx.animation.TranslateTransition translate = new javafx.animation.TranslateTransition(); 

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
      
      public void Translation(Duration duration, Node node){
      javafx.animation.TranslateTransition translateTransition = new javafx.animation.TranslateTransition(Duration.seconds(0.5), ballon);
        translateTransition.setFromY(0);
        translateTransition.setToY(-15);
        translateTransition.setInterpolator(javafx.animation.Interpolator.LINEAR);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(javafx.animation.Animation.INDEFINITE);

        // Start the animation
        translateTransition.play();}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> choice=FXCollections.observableArrayList("Save Code","Delete Code");
       c1.setItems(choice);
       c2.setItems(choice);
       c3.setItems(choice);
       c4.setItems(choice);
       c1.setValue("Save Code ? Or Delete Code ?");
       c2.setValue("Save Code ? Or Delete Code ?");
       c3.setValue("Save Code ? Or Delete Code ?");
       c4.setValue("Save Code ? Or Delete Code ?");
      // TranslateTransition(Duration.seconds(0.9),next);
       Translation(Duration.seconds(0.9),ballon);
       TranslateTransition2(Duration.seconds(0.9),nextImage);
    }    
    int check=0;
    
    public void Display()
    {
        if(check==4)
                {
                    Check.setStage(5);
                    Check.Done();
                    Win.setVisible(true);
                    nextImage.setVisible(true);
                }
                }//the end of the method
    
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
      ballon.setFitWidth(ballon.getFitWidth()+5);
      ballon.setFitHeight(ballon.getFitHeight()+5);
    }
    @FXML
    void loonEx(MouseEvent event) {
      ballon.setFitWidth(60);
      ballon.setFitHeight(155);
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
     void nextPressed(MouseEvent event) throws IOException {
       click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("StagesFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
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
    
    /*
    FeedBack Interface
    */
    @FXML
    private void Slider(MouseEvent e)
    {
        //This method will appear an appropiate text based on the Mouse Released
        String color=" ";//to know the color of the content of the Text object 
            double value = slider.getValue();
            String result = "";
            if (value >= 0 && value <= 40) {
                result = "Not very joyful";
                color="red";
            } else if (value >= 41 && value <= 71) {
                result = "Good experience";
                color="yellow";
            } else if (value >= 72 && value <= 100) {
                result = "Very Joyful";
                color="green";
            }
            sliderLabel.setText(result);
            if(color.equals("red"))
                sliderLabel.setTextFill(Color.RED);
            else if(color.equals("yellow"))
                sliderLabel.setTextFill(Color.GOLD);
            else 
                 sliderLabel.setTextFill(Color.GREEN);
    }//the end of the method
    
    /*
    Loop Game Interface 
    */
    
    //Method for change color of code 1 (TextArea )
      @FXML
    private void ColorOfCode1(ActionEvent a)
    {
        String voice =" ";
        if("Save Code".equals(c1.getValue()))
        {  /*if the user choose save code the color will not change cause of it is wrong
            but a hint will be appear in the label 
            */
            wrong();
            hint1.setText("ARE YOU SURE ?");
            hint1.setTextFill(Color.RED);
            code1.setStyle("-fx-text-fill: black");
    }//the end of the if block 
        else 
        {
            /*
            the correct answer, the color of the textArea will be changed 
            and correct message will be appear
            */
            correct();
            hint1.setText("Yes,correct");
            hint1.setTextFill(Color.GREEN);
            code1.setStyle("-fx-text-fill: red");
            
            check++;
        }//end of else 
        Display();
             c1.setDisable(false);
    }//the end of the method
    
    
    //Method for change color of code 2 (TextArea )
    @FXML
    private void ColorOfCode2(ActionEvent a)
    {
        String voice=" ";
        if("Save Code".equals(c2.getValue()))//the correcr answer 
        {
            /*
            this is the correct answer the color will change and hint will appear
            that answer is coorect
            */
              correct();
            code2.setStyle("-fx-text-fill: green");
            hint2.setText("Yes,correct");
            hint2.setTextFill(Color.GREEN);
            check++;
        }//the end of the if 
        
        else//wrong answer color will not change and hint will be appear
        {
            wrong();
             hint2.setText("ARE YOU SURE ?");
            hint2.setTextFill(Color.RED);
            code2.setStyle("-fx-text-fill: black");
        }//the end of else 
        Display();
         c2.setDisable(false);
    }//the end of the method
    
    
    //Method for change color of code 3 (TextArea )
    @FXML
    private void ColorOfCode3(ActionEvent a)
    {
        String voice=" ";
         if("Save Code".equals(c3.getValue()))//the correcr answer 
        {
            /*
            this is the correct answer the color will change and hint will appear
            that answer is coorect
            */
             correct();
            code3.setStyle("-fx-text-fill: green");
            hint3.setText("Yes,correct");
            hint3.setTextFill(Color.GREEN);
            check++;
        }//the end of the if 
        else//wrong answer color will not change and hint will be appear
        {
            wrong();
             hint3.setText("ARE YOU SURE ?");
            hint3.setTextFill(Color.RED);
            code3.setStyle("-fx-text-fill: black");
        }//the end of else 
         Display();
          c3.setDisable(false);
    }//the end of the method
    
    
    //Method for change color of code 4 (TextArea )
    @FXML
    private void ColorOfCode4(ActionEvent a)
    {
        String voice=" ";
      if("Save Code".equals(c4.getValue()))//the correcr answer 
        {
            /*
            this is the correct answer the color will change and hint will appear
            that answer is coorect
            */
            correct();
            hint4.setText("Yes,correct");
            
            hint4.setTextFill(Color.GREEN);
            code4.setStyle("-fx-text-fill: green");
            check++;
        }//the end of the if 
        else//wrong answer color will not change and hint will be appear
        {
            wrong();
            hint4.setText("ARE YOU SURE ?");
            hint4.setTextFill(Color.RED);
            code4.setStyle("-fx-text-fill: black");
        }//the end of else 
      Display();
      c4.setDisable(false);
    }//the end of the method
    
   @FXML
   private void label1(MouseEvent action)
   {
       if(c1.getValue()=="Save Code")
       { 
           hint1.setText("");
           code1.setStyle("-fx-text-fill: black");
       }
   }//the end of the method 
   
    @FXML
   private void label2(MouseEvent action)
   {
        if(c2.getValue()=="Delete Code")
       { 
           hint2.setText("");
           code2.setStyle("-fx-text-fill: black");
       }
   }//the end of the method 
   
   
    @FXML
   private void label3(MouseEvent action)
   {
         if(c3.getValue()=="Delete Code")
       { 
           hint3.setText("");
           code3.setStyle("-fx-text-fill: black");
       }
   }//the end of the method 
   
    @FXML
   private void label4(MouseEvent action)
   {
         if(c4.getValue()=="Delete Code")
       { 
           hint4.setText("");
           code4.setStyle("-fx-text-fill: black");
       }
   }//the end of the method 
    
   @FXML
   private void DeleteCode(MouseEvent action)
   {
       deleteCode.setFitHeight(deleteCode.getFitHeight()+5);
       deleteCode.setFitWidth(deleteCode.getFitWidth()+5);
   }
   
    @FXML
   private void SaveCode(MouseEvent action)
   {
         saveCode.setFitHeight(saveCode.getFitHeight()+5);
       saveCode.setFitWidth(saveCode.getFitWidth()+5);
   }
   
   //When the mouse entered the about us icon 
   @FXML
   private void AboutUs(MouseEvent Action)
   {
       ImageView aboutus=(ImageView)(Node)aboutUs.getGraphic();
       aboutus.setFitWidth(aboutus.getFitWidth()+3);
       aboutus.setFitHeight(aboutus.getFitHeight()+3);
   }//the end of the method 
   
   //When the mouse entered the setting icon 
   @FXML 
   private void Settings(MouseEvent Action)
   {
       ImageView setting=(ImageView)(Node)aboutUs.getGraphic();
       setting.setFitWidth(setting.getFitWidth()+3);
       setting.setFitHeight(setting.getFitHeight()+3);
   }//the end of the method 
   
   //When the mouse entered the account icon 
    @FXML 
   private void Account(MouseEvent Action)
   {
       ImageView account=(ImageView)(Node)aboutUs.getGraphic();
       account.setFitWidth(account.getFitWidth()+3);
       account.setFitHeight(account.getFitHeight()+3);
   }//the end of the method 
   
   
   //When the mouse entered the  music icon 
    @FXML 
   private void Music(MouseEvent Action)
   {
       ImageView music=(ImageView)(Node)Music.getGraphic();
       music.setFitWidth(music.getFitWidth()+3);
       music.setFitHeight(music.getFitHeight()+3);
   }//the end of the method 
   
   //When the mouse entered the feedback icon 
    @FXML 
   private void FeedBack(MouseEvent Action)
   {
       ImageView feedback=(ImageView)(Node)FeedBack.getGraphic();
       feedback.setFitWidth(feedback.getFitWidth()+3);
       feedback.setFitHeight(feedback.getFitHeight()+3);
   }//the end of the method 
   
   //When the mouse entered the java joy game icon 
   @FXML 
   private void JavaJoy(MouseEvent Action)
   {
       ImageView javajoy=(ImageView)(Node)JavaJoy.getGraphic();
       javajoy.setFitWidth(javajoy.getFitWidth()+3);
       javajoy.setFitHeight(javajoy.getFitHeight()+3);
   }//the end of the method 
   
   @FXML
   private ImageView helpIns;
   
   @FXML
   void helpEntered(MouseEvent e){
        helpIns.setVisible(true);
    }
    @FXML
    void helpExited(MouseEvent e){
        helpIns.setVisible(false);
    }
   
   public void check()
   {
       mute=!mute;
   }//the end of the method 
   
   
   //to make the music on or off (muted or not muted )
   @FXML
   private void MuteMusic(MouseEvent Action)
   {
       if(mute==false)//if the icon clicked to mute the music muted
       {
          ImageView muted=new ImageView("MuteMusic.png");
          muted.setFitWidth(45);
          muted.setFitHeight(45);
          Node mutedNode=muted;
           Music.setGraphic(mutedNode);
       }//the end of the if 
       else //if the music clicked and sound on 
       {
          ImageView muted=new ImageView("MusicR.png");
          muted.setFitWidth(45);
          muted.setFitHeight(45);
          Node NotmutedNode=muted;
          Music.setGraphic(NotmutedNode);
       }//the end of the else 
        check();
   }//the end of the method 
   
  public void NextStage(MouseEvent action)
  {
  }
  
  public void BackToStage(MouseEvent action)
  {
  }//the end of the method
  
}//the end of the class 
