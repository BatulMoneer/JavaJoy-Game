/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author albat
 */
public class Main2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("AddMedicine.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("C:\\Users\\albat\\Documents\\NetBeansProjects\\Taafi\\src\\taafi\\Style.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               launch(args);
    }
    
    
}
