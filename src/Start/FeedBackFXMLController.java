/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class FeedBackFXMLController implements Initializable {
    @FXML 
    private Slider slider;
    
    @FXML
    private Label sliderLabel;//for the slider label ( appear based on used choise )
    
     @FXML
    private Button goHome;
         
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
    
     private final String url = "jdbc:mysql://localhost:3306/ap_project";
    private final String user = "root";
    private final String password = "Wren0966599731";
    
Connection conn;

    public FeedBackFXMLController() throws Exception {
        this.conn =  DriverManager.getConnection(url, user, password);
    }
    
    private Feed[] feedbackRecords = {
        new Feed(1, "not joyful", 0),
        new Feed(2, "good", 0),
        new Feed(3, "very joyful", 0)
    };
    
    @FXML
    private void Slider(MouseEvent e) throws SQLException
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
            
            
  /*          
String feed = sliderLabel.getText();

        //check where is the comment that matches the one in the feed String 
        int id = 0;
        Feed v = new Feed();
        for (Feed B : feedbackRecords) {
            if (B.getComment().equals(feed)) {
                id = B.getId();
                v = B;
                break;
            }

        }//the end of the for loop 
        v.setViewsNum(v.getViewsNum() + 1);
        // Update the feedback record in the database
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE feedback SET views = ? WHERE id = ?");
            stmt.setInt(1, v.getViewsNum());
            stmt.setInt(2, v.getId());
            stmt.executeUpdate();
        } //the end of the try block 
        catch (SQLException a) {
            a.printStackTrace();
        }//the end of the catch block
            */
        
            
String feed = sliderLabel.getText();

        //check where is the comment that matches the one in the feed String 
        System.out.println(feed);
        Feed v = new Feed();
            if (null != feed) switch (feed) {
            case "Not very joyful":
                System.out.println("1");
                v.setId(1);
                Check.setBad(Check.getBad()+1);
                v.setViewsNum(Check.getBad() );
                break;
            case "Very Joyful":
                System.out.println("2");
                v.setId(3);
                Check.setVery(Check.getVery()+1);
                v.setViewsNum(Check.getVery());
                break;
            case "Good experience":
                System.out.println("3");
                v.setId(2);
                Check.setOk(Check.getOk()+1);
                v.setViewsNum(Check.getOk());
                break;
            default:
                break;
        }
            
        
        // Update the feedback record in the database
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement("UPDATE feedback SET views=? WHERE id=?"); 
                                  // Create a PreparedStatement object        1 
        pstmt.setInt(1,v.getViewsNum());        // Assign first value to first parameter    2 
        pstmt.setInt(2,v.getId());      // Assign first value to second parameter 
                  
        
        int resultU = pstmt.executeUpdate();
        System.out.println("Rows affected: " + resultU);
        pstmt.close();                    // Close the PreparedStatement object       4 
        /*
            Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        System.out.println(v.getViewsNum()+" "+v.getId());
        Feed feedback = (Feed) session.get(Feed.class, v.getId());
        feedback.setViewsNum(v.getViewsNum());
        session.update(feedback);
        session.close();
        */
         
    }//the end of the method

    
    
    
    /**
     * Initializes the controller class.
     */
    /*
    private Feed[] feedbackRecords = {
        new Feed(1, "not joyful", 0),
        new Feed(2, "good", 0),
        new Feed(3, "very joyful", 0)
    };
*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       Session session = HibernateUtil.getSessionFactory().openSession();
        //go to the relation correspond to the Stages class at the specified primary key 
         Feed stage = (Feed) session.get(Feed.class, 1);
         session.close();
         
            if (stage!=null) {//check if there is data in the table or not 
                // If there is at least one row, the ID value is present in the relationship table
                
                System.out.println("The ID value " + 1 + " is present in the FeedBack table");
                
                Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        List<Feed> uList = null;
        
        String queryStr = "FROM Feed";
        Query query = session2.createQuery(queryStr);
        uList = query.list();
        session2.getTransaction().commit();
        session2.close();
        
        boolean  c = false;
       
       for(Feed u: uList){
            if( 1==(u.getId())){
                Check.setBad(u.getViewsNum());
            }
            else if( 2==(u.getId())){
                Check.setOk(u.getViewsNum());
            }
            else if( 3==(u.getId())){
                Check.setVery(u.getViewsNum());
            }
        } 
            } //the end of the else bloco 
            else {
                Feed comment1 = new Feed(1, "Not very joyful", 0);
                Feed comment2 = new Feed(2,"Good experience", 0);
                Feed comment3 = new Feed(3, "Very Joyful", 0);
               
                 Session ADDsession1 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt1 = ADDsession1.beginTransaction();
                ADDsession1.save(comment1);
                Addt1.commit();
                ADDsession1.close();
                
                 //Add stage 2 to the relation in the DB
                Session ADDsession2 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt2 = ADDsession2.beginTransaction();
                ADDsession2.save(comment2);
                Addt2.commit();
                ADDsession2.close();
                
                 //Add stage 3 to the relation in the DB
                Session ADDsession3 = HibernateUtil.getSessionFactory().openSession();
                Transaction Addt3 = ADDsession3.beginTransaction();
                ADDsession3.save(comment3);
                Addt3.commit();
                ADDsession3.close();
            }//The end of the else block 
    }  
    
}
