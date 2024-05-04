/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class HomeFXMLController implements Initializable {

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
    private ImageView javajoy;
    
     @FXML
    private ImageView feedback;
     
      @FXML
    private ImageView music;
      
       @FXML
    private ImageView account;
       
       @FXML 
       private ImageView setting;
    
     @FXML
      private ImageView aboutus;
     
     boolean mute=false;//the music is not muted
     
     public void click(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Click.mp3";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
     
     //When the mouse entered the about us icon 
   double oldScaleX;
    double oldScaleY;
    @FXML
    void AboutUsEntered(MouseEvent e){
        oldScaleX = aboutus.getScaleX();
        oldScaleY = aboutus.getScaleY();
        aboutus.setScaleX(1.2);
        aboutus.setScaleY(1.2);
    } 
    
    @FXML
    void AboutUsExited(MouseEvent e){
        aboutus.setScaleX(oldScaleX);
        aboutus.setScaleY(oldScaleY);
    } 
   //When the mouse entered the setting icon 
    double oldScaleXsetting;
    double oldScaleYsetting;
    @FXML
    void settingEntered(MouseEvent e){
        oldScaleXsetting = setting.getScaleX();
        oldScaleYsetting = setting.getScaleY();
        setting.setScaleX(1.2);
        setting.setScaleY(1.2);
    } 
    
    @FXML
    void settingExited(MouseEvent e){
        setting.setScaleX(oldScaleXsetting);
        setting.setScaleY(oldScaleYsetting);
    }  
   
   //When the mouse entered the account icon
    double oldScaleXaccount;
    double oldScaleYaccount;
    @FXML
    void accountEntered(MouseEvent e){
        oldScaleXaccount = account.getScaleX();
        oldScaleYaccount = account.getScaleY();
        account.setScaleX(1.2);
        account.setScaleY(1.2);
    } 
    
    @FXML
    void accountExited(MouseEvent e){
        account.setScaleX(oldScaleXaccount);
        account.setScaleY(oldScaleYaccount);
    }  
   
   
   //When the mouse entered the  music icon 
    double oldScaleXmusic;
    double oldScaleYmusic;
    @FXML
    void musicEntered(MouseEvent e){
        oldScaleXmusic = music.getScaleX();
        oldScaleYmusic = music.getScaleY();
        music.setScaleX(1.2);
        music.setScaleY(1.2);
    } 
    
    @FXML
    void musicExited(MouseEvent e){
        music.setScaleX(oldScaleXmusic);
        music.setScaleY(oldScaleYmusic);
    } 
   
   //When the mouse entered the feedback icon 
    double oldScaleXfeedback;
    double oldScaleYfeedback;
    @FXML
    void feedbackEntered(MouseEvent e){
        oldScaleXfeedback = feedback.getScaleX();
        oldScaleYfeedback = feedback.getScaleY();
        feedback.setScaleX(1.2);
        feedback.setScaleY(1.2);
    } 
    
    @FXML
    void feedbackExited(MouseEvent e){
        feedback.setScaleX(oldScaleXfeedback);
        feedback.setScaleY(oldScaleYfeedback);
    } 
   
   //When the mouse entered the java joy game icon 
   
   double oldScaleXjavajoy;
    double oldScaleYjavajoy;
    @FXML
    void javajoyEntered(MouseEvent e){
        oldScaleXjavajoy = javajoy.getScaleX();
        oldScaleYjavajoy = javajoy.getScaleY();
        javajoy.setScaleX(1.2);
        javajoy.setScaleY(1.2);
    } 
    
    @FXML
    void javajoyExited(MouseEvent e){
        javajoy.setScaleX(oldScaleXjavajoy);
        javajoy.setScaleY(oldScaleYjavajoy);
    } 
   
   public void check()
   {
       mute=!mute;
   }//the end of the method 
   
   private Parent root ;
    private Stage stage;
    private Scene scene;

    @FXML
    void javajoyClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("StartUpFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void accountClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("AccountFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void aboutUsClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("AboutUsFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void feedBackClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("FeedBackFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
   
   
   //to make the music on or off (muted or not muted )
   @FXML
   private void MuteMusic(MouseEvent Action)
   {
       click();
       if(mute==false)//if the icon clicked to mute the music muted
       {
          Main.mediaPlayer.setMute(true);
          ImageView muted=new ImageView("images/MuteMusic.png");
          muted.setFitWidth(45);
          muted.setFitHeight(45);
          Node mutedNode=muted;
           Music.setGraphic(mutedNode);
       }//the end of the if 
       else //if the music clicked and sound on 
       {
          Main.mediaPlayer.setMute(false);
          ImageView muted=new ImageView("images/MusicR.png");
          muted.setFitWidth(45);
          muted.setFitHeight(45);
          Node NotmutedNode=muted;
          Music.setGraphic(NotmutedNode);
       }//the end of the else 
        check();
   }//the end of the method
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        //go to the relation correspond to the Stages class at the specified primary key 
         Stages stage = (Stages) session.get(Stages.class, 1);
         session.close();
         
            if (stage!=null) {//check if there is data in the table or not 
                // If there is at least one row, the ID value is present in the relationship table
                System.out.println("The ID value " + 1 + " is present in the stageinfor table");
            } //the end of the else bloco 
            else {
                Stages stage1 = new Stages(1, "Data type and variables", 1);
                Stages stage2 = new Stages(2, "Arthimatic operations", 4);
                Stages stage3 = new Stages(3, "Print Statement", 4);
                Stages stage4 = new Stages(4, "If Statement", 2);
                Stages stage5 = new Stages(5, "Loop", 1);
                Stages stage6 = new Stages(6, "Array", 1);

                //Add stage 1 to the relation in the DB
                Session ADDsession1 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt1 = ADDsession1.beginTransaction();
                ADDsession1.save(stage1);
                Addt1.commit();
                ADDsession1.close();
                
                 //Add stage 2 to the relation in the DB
                Session ADDsession2 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt2 = ADDsession2.beginTransaction();
                ADDsession2.save(stage2);
                Addt2.commit();
                ADDsession2.close();
                
                 //Add stage 3 to the relation in the DB
                Session ADDsession3 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt3 = ADDsession3.beginTransaction();
                ADDsession3.save(stage3);
                Addt3.commit();
                ADDsession3.close();
                //Add stage 4 to the relation in the DB
                Session ADDsession4 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt4 = ADDsession4.beginTransaction();
                ADDsession4.save(stage4);
                Addt4.commit();
                ADDsession4.close();
 
                 //Add stage 5 to the relation in the DB
                Session ADDsession5 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt5 = ADDsession5.beginTransaction();
                ADDsession5.save(stage5);
                Addt5.commit();
                ADDsession5.close();
 
                 //Add stage 6 to the relation in the DB
                Session ADDsession6 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt6 = ADDsession6.beginTransaction();
                ADDsession6.save(stage6);
                Addt6.commit();
                ADDsession6.close();
            }//the end of the else block
        // TODO
    }    
    
}
