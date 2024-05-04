/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.hibernate.*;
//export JVM_ARGS="-Xms1024m -Xmx1024m";
/**
 *
 * @author albat
 */
public class Main extends Application{
    public static void main(String[]args){
        launch(args);
        /*
        Main main =new Main();
        user u1 = new user();
        u1.setNumber(3);
        u1.setName("Henry");
        u1.setUserName("henry333");
        long id = main.insertActor(u1);
        *//*
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<user> uList = null;
        
        String queryStr = "from user";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
       System.out.println(uList.get(0));
       for(user u: uList){
            System.out.println(u.getNumber()+" "+u.getName()+" "+u.getUserName());
        }*/
        
        
    }    
    public static  MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws Exception {
        
         // create a Media object with the sound file path
         String voice = "C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\media\\music.mp3";     
         Media sound = new Media(new File(voice).toURI().toString());
        // create a MediaPlayer object with the Media object
        mediaPlayer = new MediaPlayer(sound);
        // set the MediaPlayer to loop indefinitely
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        // play the sound
        mediaPlayer.play();
        
        long minRunningMemory = (1024*1024);

        Runtime runtime = Runtime.getRuntime();

        if(runtime.freeMemory()<minRunningMemory)
            System.gc();
        
         Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        
    
        
    }
    @Override
    public void stop() throws Exception {
        // stop the MediaPlayer when the application is closed
        mediaPlayer.stop();
        super.stop();
        System.exit(0);
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
    
    public void insertActor(user us) {
        String SQL = "INSERT INTO user(id_user,user_name,name,level) "
                + "VALUES(?,?,?,?)";
        
        try (Connection conn = connect();
                
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setInt(1, us.getNumber());
            pstmt.setString(2, us.getUserName());
            pstmt.setString(3, us.getName());
            pstmt.setInt(4, us.getLevel());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
