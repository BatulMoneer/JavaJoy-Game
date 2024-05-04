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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author aseel
 */
public class AccountFXMLController implements Initializable {
    
    @FXML
    private  Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Button home;
    
   
            
    @FXML
    public void textbinding() {
        checkDatabase();
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
            if( Check.getId()==(u.getNumber())){
                text1.setText(u.getUserName());
                text2.setText(u.getName());
                text3.setText(String.valueOf(u.getLevel()));
                c = true;
            }
        } 
       if(!c){
           text1.setText("No Data");
           text2.setText("No Data");
           text3.setText("No Data");
       }
       
       return c;
    }
    
    
     public void click(){
            String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\Click.mp3";     
            Media sound = new Media(new File(voice).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
    }
    
    @FXML
    public void goHome(ActionEvent event) throws Exception {
        click();
        Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
