/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aman
 */
public class ProceducedVehicleController implements Initializable {

    @FXML
    private Button dispatchButton;
    @FXML
    private Button mainSceneButton;
    @FXML
    private TextArea inQC;
    @FXML
    private TextArea typecarsinfo;
    @FXML
    private TextArea producedcars;
    @FXML
    private TextArea carsfromQc;
    @FXML
    private Button viewProduced;
    @FXML
    private Button sendToQc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dispatchButton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("delivery.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show(); 
    }

    @FXML
    private void mainSceneButton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show(); 
    }

    @FXML
    private void viewProduced(ActionEvent event) {
        //outputTextArea.setText("");
        producedcars.clear();
        File f = null;
        Scanner sc; String str; 
        try {
            f = new File("ViewStockCars.txt");
            sc = new Scanner(f);
            if(f.exists()){
                
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                   
                    producedcars.appendText(
                            
                                 str +" \n"

                    );
                }
            }
            else 
                producedcars.setText("oops! ViewStockCars.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }


   
    }


    @FXML
    private void sendToQc(ActionEvent event) {
        
    }
    
}
