/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Start;

import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
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
public class SearchMedicineController implements Initializable {

    
   


    @FXML
    private Button AccButt;

    @FXML
    private Button ChatButt;

    @FXML
    private Button HomeButt;

    @FXML
    private Button SearchButt;
    
    @FXML
    private Rectangle backHov;
    
    @FXML
    private TextField searchBar = new TextField("...") ;
    
    @FXML 
    private VBox RecsBoxContainer = new VBox();
    
    @FXML
    private Text MessageWarining1 = new Text();
    
    @FXML
    private Text MessageWarining2;
    
    @FXML
    private Text yesText;
    
    @FXML
    private Text noText;
    
    @FXML
    private Rectangle yesButt;
    
    @FXML
    private Rectangle noButt;
    
    @FXML
    private Rectangle warningPage = new Rectangle();
    
    
     

    
    @FXML
    void HoverOnBack(MouseEvent event) {
        backHov.setFill(Paint.valueOf("rgb(84, 170, 201);"));
    }

    @FXML
    void HoverOutBack(MouseEvent event) {
        backHov.setFill(Paint.valueOf("rgb(255, 255, 255);"));
    }

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
    void GoBack(MouseEvent event)throws Exception {
        root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void No(MouseEvent event)throws Exception {
        root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    String medName = " ";
    
    @FXML
    void Yes(MouseEvent event)throws Exception {
        SearchMedicineController s = new SearchMedicineController();
        mymedicine med = new mymedicine("2329463877", medName);
        s.insertActor(med);
        root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }
    
    int medExists=0;
    int noRep=0;
    @FXML
    void Search(MouseEvent event){
        
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
            if(u.getMedicinename().equalsIgnoreCase(searchBar.getText())){
                medExists =1;
                AddMedicine(u.getImage(), u.getMedicinename(), u.getStartdate(), u.getEnddate(), u.getDoseno());
                
                for(mymedicine u2: uList2){
                    if(u.getMedicinename().equalsIgnoreCase(u2.getMedicinename())){
                        MessageWarining1.setText("You already have this medicine");
                        MessageWarining1.setVisible(true);
                        warningPage.setVisible(true);
                        noText.setText("OK");
                        noText.setVisible(true);
                        noButt.setVisible(true);
                        noRep=1;
                    }
                    else if( u.getMedicinename().equalsIgnoreCase("Cetamol")&&u2.getMedicinename().equalsIgnoreCase("Augmentin")){
                        MessageWarining1.setText("This medicine has an interaction with");
                        MessageWarining2.setText("another medicine you can not add it");
                        MessageWarining1.setVisible(true);
                        MessageWarining2.setVisible(true);
                        warningPage.setVisible(true);
                        noText.setText("OK");
                        noText.setVisible(true);
                        noButt.setVisible(true);
                        noRep=1;
                    }
                    else if(u.getMedicinename().equalsIgnoreCase("Augmentin")&&u2.getMedicinename().equalsIgnoreCase("Cetamol")) {
                        MessageWarining1.setText("This medicine has an interaction with");
                        MessageWarining2.setText("another medicine you can not add it");
                        MessageWarining1.setVisible(true);
                        MessageWarining2.setVisible(true);
                        warningPage.setVisible(true);
                        noText.setText("OK");
                        noText.setVisible(true);
                        noButt.setVisible(true);
                        noRep=1;
                    }
                }
                if(noRep==0){
                    MessageWarining1.setVisible(true);
                    MessageWarining2.setVisible(true);
                    warningPage.setVisible(true);
                    yesText.setVisible(true);
                    noText.setVisible(true);
                    yesButt.setVisible(true);
                    noButt.setVisible(true);
                    medName = u.getMedicinename();
                }
            }
        }
        if(medExists==0){
            MessageWarining1.setText("Sorry, We could not find you medicine");
            MessageWarining1.setVisible(true);
        }
    }
    
    

    
    void AddMedicine(String image, String name, String start, String end, String dose){
        
        Rectangle rec = new Rectangle();
        rec.setFill(Paint.valueOf("rgb(255, 255, 255)"));
        rec.setHeight(90);
        rec.setWidth(280);
        rec.setArcWidth(20); // Set the horizontal corner radius
        rec.setArcHeight(20);
        RecsBoxContainer.setPadding(new Insets(10,10,10,10));
        RecsBoxContainer.setSpacing(10);
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
        pane.getChildren().addAll(rec, box1);
        RecsBoxContainer.getChildren().addAll(pane);
        
        
      
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    private final String url = "jdbc:mysql://localhost:3306/ap_project";
    private final String user = "root";
    private final String password = "Wren0966599731";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    
    public void insertActor(mymedicine us) {
        String SQL = "INSERT INTO mymedicine(myid,medicinename) "
                + "VALUES(?,?)";
        
        try (Connection conn = connect();
                
                PreparedStatement pstmt = conn.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, us.getMyid());
            pstmt.setString(2, us.getMedicinename());

            int affectedRows = pstmt.executeUpdate();
            // medExists the affected rows 
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
