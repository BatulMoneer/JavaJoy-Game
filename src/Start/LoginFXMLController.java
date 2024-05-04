/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    Label name;
     
    @FXML
    private Button done;
    
     @FXML
    private Button signUpButt;
     
     @FXML
    private Button goHome;
     
     @FXML
     public  TextField usernameField;
     
     @FXML
     private Label signupComment;
         
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
    void signUpButtClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("SignUpMenuFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
         signUpButt.setDisable(false);
         
    }
   
    String usernameData;
    @FXML
    void donePressed(ActionEvent event)  throws Exception {
       click();
         if( usernameField.getText().equals("")){
            signupComment.setVisible(true);  
        }
        else{
            usernameData = usernameField.getText();
            if(checkDatabase()){
                root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);  
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    
    boolean checkDatabase(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<user> uList = null;
        
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
        boolean  c = false;
       
       for(user u: uList){
            if( usernameField.getText().equals(u.getUserName())){
                Check.setId(u.getNumber());
                Check.setLevel(u.getLevel());
                //Check.done = u.getLevel() ;
                c = true;
            }
        } 
       if(!c){
           signupComment.setText("username is not found");
           signupComment.setVisible(true);
       }
       
       return c;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.textProperty().bind(usernameField.textProperty());
    }    
    
}
