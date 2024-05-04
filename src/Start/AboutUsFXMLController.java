/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Start;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class AboutUsFXMLController implements Initializable {
 
    @FXML
    private Button home;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextArea AboutUsInfo;

    @FXML
    private Button Click;

    Session session;

   
    
   

    /*this code is for switching pages between (About us) page and (Home) page*/
    @FXML
    public void goHome(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        Stage window = (Stage) home.getScene().getWindow();
        window.setScene(new Scene(root));
    }//the end of the method 

    /*This method to read from file and display the information in the textArea */
    public void GetAboutUsInfo() throws Exception {
        try {
            Scanner inputFile = new Scanner(new File("C:\\Users\\albat\\Documents\\NetBeansProjects\\Game\\src\\File\\AboutUsInfo.txt")).useDelimiter("\\s+");
            while (inputFile.hasNext()) {
                if (inputFile.hasNextInt()) { // check if next token is an int
                    AboutUsInfo.appendText(inputFile.next() + " "); // display the found integer
                } else {
                    AboutUsInfo.appendText(inputFile.next() + " "); // else read the next token
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
        AboutUsInfo.setFont(new Font("Arial", 35));

    }//the end of the method

    /* 
    The initialize method will insert data in the Stages relation and retrieve them 
    to be dispalyed in the About Us interface for more information about the game 
    also it will read information from a file.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            GetAboutUsInfo();//call method to display info once the scene appear
        } //the end of the try block 
        catch (Exception ex) {
        }//the end of the catch  block 
       
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
        
        AboutUsInfo.appendText("\n");
      List<Stages>StagesList=RetreiveStagesInfo();//retreive the data from the database 
      for(Stages stages:StagesList)
      {
          AboutUsInfo.appendText("\n"+stages.toString()+"\n");
      }//the end of the for each loop
    }//the end of the method 

    /*
    This method will return a list that contains data from the database 
    so it can be displayed on the textArea 
    */
    public List<Stages> RetreiveStagesInfo()
    {
        int stagesNumber[]={1,2,3,4,5,6};
        List<Stages>stagesList=new ArrayList<Stages>();//arrayList to store the Stages 
        for(int i:stagesNumber){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //go to the relation correspond to the Stages class at the specified primary key 
        Stages stage = (Stages) session.get(Stages.class, i);
        stagesList.add(stage);//add the stage into the List 
        session.close();
        }//the end of the for loop 
       return stagesList;
    }//the end of the method 
    

}//the end of the class
   

