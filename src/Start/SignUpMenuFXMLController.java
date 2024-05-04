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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.*;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class SignUpMenuFXMLController implements Initializable {
    
    @FXML
    Button signupOk;
    
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
    
    private  String nameData ;
    private  String usernameData ;
    
    @FXML
    Label signupComment;
    
    @FXML
    Label name;
    
    @FXML
    TextField usernameField;
    
    @FXML
    TextField nameField;
    
     @FXML
    private Button logInButt;
     
     

    @FXML
    void logInButtClicked(ActionEvent event) throws Exception {
        click();
        root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
         logInButt.setDisable(false);
    }
    
        user u1 ;
    
     @FXML
    void donePressed(ActionEvent event) throws Exception {
        click();
         if(nameField.getText().equals("") || usernameField.getText().equals("")){
            signupComment.setVisible(true);  
        }
        else{
            nameData = nameField.getText();
            usernameData = usernameField.getText();
            
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<user> uList = null;
        
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
        boolean  c = true;
       
    
       
       /*
        usernameField.textProperty().addListener((observable, oldvalue, newvalue) -> {
                    String id = (usernameField.getText()+" is already used");
                    signupComment.setText(id);
        });
       */
       
       
       for(user u: uList){
            if( usernameField.getText().equals(u.getUserName())){
              // signupComment.textProperty().addListener((observable, oldvalue, newvalue) -> {
                 //  String name = usernameField.getText();
                    //signupComment.setText((signupComment.getText()));
                  // });
              // label2.textProperty().bind(field.textProperty());
                //signupComment.textProperty().bind(usernameField.textProperty());
                String x = ("username is already used");
                signupComment.setText(x);
                signupComment.setVisible(true);
                c = false;
            }
        }
       
       if(c){
           
        if(usernameData.length()>10){
                signupComment.setText("username is too long");
                signupComment.setVisible(true);
                signupComment.setTextFill(Color.RED);
        }
        else if(!(Character.isUpperCase(nameData.charAt(0)))){
            signupComment.setText("the first letter must be capital");
                signupComment.setVisible(true);
                signupComment.setTextFill(Color.RED);
        }
        else if(!(nameData.matches("^[a-zA-Z]*$"))){
            signupComment.setText("no special charaters or numbers");
                signupComment.setVisible(true);
                signupComment.setTextFill(Color.RED);
        }
        else{
        
        u1 = new user();
        
        u1.setNumber(uList.size()+1);
        Check.setId(uList.size()+1);
        u1.setName(nameData);
        Check.done =1;
        
        u1.setLevel(1);
        Check.setLevel(1);
        
        u1.setUserName(usernameData);
        SignUpMenuFXMLController s = new SignUpMenuFXMLController();
        s.insertActor(u1);
        signupComment.setText("Welcome "+nameData+"!");
                signupComment.setVisible(true);
                root = FXMLLoader.load(getClass().getResource("StagesFXML.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);  
                stage.setScene(scene);
                stage.show();

        }           
       }
                
            
        }
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
    
    public long insertActor(user us) {
        String SQL = "INSERT INTO user(id_user,user_name,name,level) "
                + "VALUES(?,?,?,?)";

        long id = 0;

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, us.getNumber());
            pstmt.setString(2, us.getUserName());
            pstmt.setString(3, us.getName());
            pstmt.setInt(4, 1);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.textProperty().bind(usernameField.textProperty());
    }    
    
}
