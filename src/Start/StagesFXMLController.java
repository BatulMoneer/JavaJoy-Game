/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author sarts
 */
public class StagesFXMLController implements Initializable {
    
    

     @FXML
    private ImageView recImag1;
     @FXML
    private ImageView recImag2;
     @FXML
    private ImageView recImag3;
      @FXML
    private ImageView recImag4;
       @FXML
    private ImageView recImag5;
        @FXML
    private ImageView recImag6;
        @FXML
    private ImageView recHomePage;
        
        @FXML
    private ImageView lock2;
     @FXML
    private ImageView lock3;
      @FXML
    private ImageView lock4;
       @FXML
    private ImageView lock5;
        @FXML
    private ImageView lock6;
        
        @FXML
    private ImageView star1;
     @FXML
    private ImageView star2;
      @FXML
    private ImageView star3;
       @FXML
    private ImageView star4;
        @FXML
    private ImageView star5;
        @FXML
    private ImageView star6;
        
         @FXML
    private Button goHome;
         
          private Parent root ;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Label signupComment;
    
    
    
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
    void recEn1(MouseEvent event) {
           //balloon stage1
          recImag1.setFitWidth(recImag1.getFitWidth()+10);
          recImag1.setFitHeight(recImag1.getFitHeight()+10);
    }
    @FXML
    void clickLoon1(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("FindAndFillFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    @FXML
    void recEn2(MouseEvent event) {
         //balloon stage2
          recImag2.setFitWidth(recImag2.getFitWidth()+12);
          recImag2.setFitHeight(recImag2.getFitHeight()+12);
    }
      
    
    @FXML
    void clickLoon2(MouseEvent event) throws IOException, ClassNotFoundException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("WhichIsTrueFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
     @FXML
    void recEn3(MouseEvent event) {
         //balloon stage3
          recImag3.setFitWidth(recImag3.getFitWidth()+12);
          recImag3.setFitHeight(recImag3.getFitHeight()+12);
    }
    @FXML
    void clickLoon3(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("GuessTheOutput1FXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    @FXML
    void recEn4(MouseEvent event) {
         //balloon stage4
          recImag4.setFitWidth(recImag4.getFitWidth()+12);
          recImag4.setFitHeight(recImag4.getFitHeight()+12);
    }
    @FXML
    void clickLoon4(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("FillTheBlank1FXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    @FXML
    void recEn5(MouseEvent event) {
         //balloon stage5
          recImag5.setFitWidth(recImag5.getFitWidth()+12);
          recImag5.setFitHeight(recImag5.getFitHeight()+12);
    }
    @FXML
    void clickLoon5(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("ColoringLoopsFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    @FXML
    void recEn6(MouseEvent event) {
         //balloon stage6
          recImag6.setFitWidth(recImag6.getFitWidth()+12);
          recImag6.setFitHeight(recImag6.getFitHeight()+12);
    }
    @FXML
    void clickLoon6(MouseEvent event) throws IOException {
        click();
      FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("CreateArrayFXML.fxml"));
           Parent next = loader.load();
           Scene scene = new Scene(next);
           Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
           window.setScene(scene);
           window.show();
    }
    
     @FXML
    void recEnHome(MouseEvent event) {
         //balloon stage6
          recHomePage.setFitWidth(recHomePage.getFitWidth()+3);
          recHomePage.setFitHeight(recHomePage.getFitHeight()+3);
    }
    @FXML
    void recEx1(MouseEvent event) {
         //balloon stage1
          recImag1.setFitWidth(308);
          recImag1.setFitHeight(394);
    }
     @FXML
     void recEx2(MouseEvent event) {
      //balloon stage2
          recImag2.setFitWidth(201);
          recImag2.setFitHeight(394);
     }
      @FXML
     void recEx3(MouseEvent event) {
      //balloon stage2
          recImag3.setFitWidth(298);
          recImag3.setFitHeight(394);
     }
      @FXML
     void recEx4(MouseEvent event) {
      //balloon stage2
          recImag4.setFitWidth(186);
          recImag4.setFitHeight(394);
     }
      @FXML
     void recEx5(MouseEvent event) {
      //balloon stage2
          recImag5.setFitWidth(165);
          recImag5.setFitHeight(394);
     }
      @FXML
     void recEx6(MouseEvent event) {
      //balloon stage2
          recImag6.setFitWidth(165);
          recImag6.setFitHeight(394);
     }
      @FXML
     void recExHome(MouseEvent event) {
      //balloon stage2
           recHomePage.setFitWidth(71);
           recHomePage.setFitHeight(72);
     }
     
   
     
     private final String url = "jdbc:mysql://localhost:3306/ap_project";
    private final String user = "root";
    private final String password = "Wren0966599731";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
     
       public void updateActor() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        
        String hqlUpdate = "update from user u set u.level ="+Check.getLevel()+" where u.id="+Check.getId()+"";
        Query query = session.createQuery(hqlUpdate);
        int resultU = query.executeUpdate();
        System.out.println("Rows affected: " + resultU);
        
        if(Check.getLevel()==1){
             Check.stage =1;
        }
        else if(Check.getLevel()==2){
            Check.stage =2;
             star1.setVisible(true);
            lock2.setVisible(false);
            recImag2.setDisable(false);
        }
        
        else if(Check.getLevel()==3){
            Check.stage =3;
            star2.setVisible(true);
             star1.setVisible(true);
             
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
        }
        
        else if(Check.getLevel()==4){
            Check.stage =4;
            star2.setVisible(true);
             star1.setVisible(true);
             star3.setVisible(true);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
        }
        
        else if(Check.getLevel()==5){
            Check.stage =5;
            star2.setVisible(true);
             star1.setVisible(true);
             star3.setVisible(true);
              star4.setVisible(true);
            lock5.setVisible(false);
            recImag5.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
        }
        
        else if(Check.getLevel()==6){
            star2.setVisible(true);
             star1.setVisible(true);
             star3.setVisible(true);
              star4.setVisible(true);
             star5.setVisible(true);
             star6.setVisible(true);
            lock6.setVisible(false);
            recImag6.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock5.setVisible(false);
            recImag5.setDisable(false);
        }
        else if(Check.getLevel()>=7){
            star2.setVisible(true);
             star1.setVisible(true);
             star3.setVisible(true);
              star4.setVisible(true);
             star5.setVisible(true);
              star6.setVisible(true);
            lock6.setVisible(false);
            recImag6.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock5.setVisible(false);
            recImag5.setDisable(false);
        }
       
        session.getTransaction().commit();
        session.close();
    }
       public void updateActor(int l) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String hqlUpdate = "update from user u set u.level ="+l+" where u.id="+Check.getId()+"";
        Query query = session.createQuery(hqlUpdate);
        int resultU = query.executeUpdate();
        System.out.println("Rows affected: " + resultU);
       
        session.getTransaction().commit();
        session.close();
    }
       
       
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<user> uList = null;
        
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
        for(user u: uList){
            if( Check.getId() == (u.getNumber())){
                signupComment.setText("Hello "+ u.getName());
            }
        } 
        
         if(Check.isDone()==1){
             System.out.println("hhhh");
            updateActor();
         }
        
    
        
         else if(Check.isDone()>=2 && Check.stage==1 ){
             System.out.println("jjjj");
             star1.setVisible(true);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            updateActor( 2);
        }
        
        else if(Check.isDone()>=3 && Check.stage==2){
            star1.setVisible(true);
             star2.setVisible(true);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            updateActor( 3);
        }
        
        else if(Check.isDone()>=4 && Check.stage==3){
            star1.setVisible(true);
            star2.setVisible(true);
             star3.setVisible(true);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            updateActor( 4);
        }
        
        else if(Check.isDone()>=5 && Check.stage==4){
            star1.setVisible(true);
            star2.setVisible(true);
            star3.setVisible(true);
             star4.setVisible(true);
             star5.setVisible(true);
            lock5.setVisible(false);
            recImag5.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            updateActor(5);
        }
        
        else if(Check.isDone()>=6 && Check.stage==5){
            star1.setVisible(true);
            star2.setVisible(true);
            star3.setVisible(true);
             star4.setVisible(true);
             star5.setVisible(true);
             star6.setVisible(true);
            lock6.setVisible(false);
            recImag6.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock5.setVisible(false);
            recImag5.setDisable(false);
            updateActor( 6);
        }
         else if(Check.isDone()>=7){
             star2.setVisible(true);
             star1.setVisible(true);
             star3.setVisible(true);
              star4.setVisible(true);
             star5.setVisible(true);
              star6.setVisible(true);
            lock6.setVisible(false);
            recImag6.setDisable(false);
            lock2.setVisible(false);
            recImag2.setDisable(false);
            lock3.setVisible(false);
            recImag3.setDisable(false);
            lock4.setVisible(false);
            recImag4.setDisable(false);
            lock5.setVisible(false);
            recImag5.setDisable(false);
            updateActor( 6);
        }
            
    }
    
}
