/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author albat
 */
public class AddMedicineController implements Initializable {
    
    @FXML
    private Button AccButt;

    @FXML
    private Button ChatButt;

    @FXML
    private Button HomeButt;

    @FXML
    private Button SearchButt;
    
    @FXML
    private Circle addMedCir = new Circle();
    
    @FXML
    private Rectangle[] medsRecs = new Rectangle[100];
    
    @FXML 
    private VBox recsBoxContainer = new VBox();
    
    @FXML
    private ScrollPane scrollPaneOfRecs = new ScrollPane();
    
    
    static int CurrentRec = 0;

    @FXML
    void HoverOnAcc(MouseEvent event) {
        AccButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnChat(MouseEvent event) {
        ChatButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnHome(MouseEvent event) {
        HomeButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOnSearch(MouseEvent event) {
        SearchButt.setStyle("-fx-background-color: rgb(84, 170, 201);");
    }

    @FXML
    void HoverOutAcc(MouseEvent event) {
        AccButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutChat(MouseEvent event) {
        ChatButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutHome(MouseEvent event) {
        HomeButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }

    @FXML
    void HoverOutSearch(MouseEvent event) {
        SearchButt.setStyle("-fx-background-color: rgb(255, 255, 255);");
    }
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    
    
    @FXML
    void AddNewMedicine(MouseEvent event)throws Exception{
        
        root = FXMLLoader.load(getClass().getResource("SearchMedicine.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    
    void AddMedicine(String image, String name, String start, String end, String dose){
        
        medsRecs[CurrentRec] = new Rectangle();
        medsRecs[CurrentRec].setFill(Paint.valueOf("rgb(255, 255, 255)"));
        medsRecs[CurrentRec].setHeight(90);
        medsRecs[CurrentRec].setWidth(280);
        medsRecs[CurrentRec].setArcWidth(20); // Set the horizontal corner radius
        medsRecs[CurrentRec].setArcHeight(20);
        recsBoxContainer.setPadding(new Insets(10,10,10,10));
        recsBoxContainer.setSpacing(10);
        Text text1 = new Text(name);
        text1.setFont(Font.font("Times New Roman",26));
        Text text2 = new Text("Start date: "+start);
        text2.setFont(Font.font("Times New Roman",12));
        text2.setFill(Paint.valueOf("rgb(101, 158, 106)"));
        Text text3 = new Text("End date: "+end);
        text3.setFont(Font.font("Times New Roman",12));
        text3.setFill(Paint.valueOf("rgb(101, 158, 106)"));
        Text text4 = new Text("Dose: "+dose);
        text4.setFont(Font.font("Times New Roman",12));
        text4.setFill(Paint.valueOf("rgb(158, 101, 101)"));
        VBox box0 = new VBox();
        box0.setAlignment(Pos.CENTER);
        box0.getChildren().addAll(text1, text2, text3, text4);
        HBox box1 = new HBox();
        box1.setAlignment(Pos.CENTER_LEFT);
        box1.setPadding(new Insets(0,0,0,20));
        box1.setSpacing(20);
        Image im = new Image(image);
        ImageView imv = new ImageView(im);
        imv.setFitHeight(60);
        imv.setFitWidth(60);
        box1.getChildren().addAll(imv, box0);
        
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(medsRecs[CurrentRec], box1);
        recsBoxContainer.getChildren().addAll(pane);
        CurrentRec++;
        
      
    }
    
    @FXML
    void HoverOnCir(MouseEvent event) {
        addMedCir.setFill(Paint.valueOf("rgb(140, 170, 138)"));
    }

    @FXML
    void HoverOutCir(MouseEvent event) {
        addMedCir.setFill(Paint.valueOf("rgb(52, 121, 185)"));
    }
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPaneOfRecs.setFitToWidth(true);
        
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        List<mymedicine> uList2 = null;
        
        String queryStr2 = "from mymedicine";
        Query query2 = session2.createQuery(queryStr2);
        uList2 = query2.list();
        session2.getTransaction().commit();
        session2.close();
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<medicine> uList = null;
        
        String queryStr = "from medicine";
        Query query = session.createQuery(queryStr);
        uList = query.list();
        session.getTransaction().commit();
        session.close();
        
        for(medicine u: uList){
            for(mymedicine u2: uList2){
            if(u2.getMedicinename().equals(u.getMedicinename()))
                AddMedicine(u.getImage(), u.getMedicinename(), u.getStartdate(), u.getEnddate(), u.getDoseno());
            }
        }
    }
}

