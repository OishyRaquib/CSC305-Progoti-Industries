/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aman
 */
public class MainController implements Initializable {

    @FXML
    private Button producedSceneButton;
    @FXML
    private Button machineSceneButton;
    @FXML
    private TextField duration;
    @FXML
    private Button clickToSaveDateTime;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea textArea1;
    @FXML
    private Button orgOrders;
    @FXML
    private TextArea textArea2;
    @FXML
    private TextField totalproductioncost;
    @FXML
    private Button saveproductioncost;
    @FXML
    private Button reqInventory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void producedSceneButton(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("producedVehicle.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show();    }
    

    @FXML
    private void machineSceneButton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("machine.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show(); 
    }

    @FXML
    private void dration(ActionEvent event) {
    }

    @FXML
    private void clickToSaveDateTime(ActionEvent event) {
    }

    @FXML
    private void datePicker(ActionEvent event) {
        
    }

    @FXML
    private void orgOrders(ActionEvent event) {
        //outputTextArea.setText("");
        textArea1.clear();
        File f = null;
        Scanner sc; String str; 
        try {
            f = new File("orgOrders.txt");
            sc = new Scanner(f);
            if(f.exists()){
                
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                   
                    textArea1.appendText(
                            
                                 str +" \n"

                    );
                }
            }
            else 
                textArea1.setText("oops! orgOrders.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }

    }

    @FXML
    private void totalproductioncost(ActionEvent event) {
    }

    @FXML
    private void saveproductioncost(ActionEvent event) {
    }

    @FXML
    private void reqInventory(ActionEvent event) {
         File f = null;
        FileWriter fw = null;
        try {
           
            String str = "low on inventory can't produce more vehicles ";
            FileWriter fw2 = new FileWriter("Need more Invventory ASAP.txt");
            fw2.write( str);
            fw2.close();

           
                      
  
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
    }
    
}
