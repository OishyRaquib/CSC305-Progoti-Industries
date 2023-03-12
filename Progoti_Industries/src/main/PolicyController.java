/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user1pkj;

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
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class PolicyController implements Initializable {

    @FXML
    private Button writePolicyButton;
    @FXML
    private Button readPolicy;
    @FXML
    private TextArea policyFieldForHR1;
    @FXML
    private TextArea postedPolicy;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void writePolicyOnClick(ActionEvent event) {
        
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
          
            f = new File("PolicyText.txt");      
          
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	policyFieldForHR1.getText()
                	
                   
            );   
                    
                      
        
        } catch (IOException ex) {
            Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void readPolicyOnClick(ActionEvent event) {
     postedPolicy.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("PolicyText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                postedPolicy.setText("Content of policy.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                    postedPolicy.setText(
                            str+ "\n"
                    );
                }
            }
            else 
               postedPolicy.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }  
    }
    

    @FXML
    private void backOnClick(ActionEvent event) {
          try{
     Parent scene7Parent = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
            Scene scene7 = new Scene(scene7Parent);
            //stage.setScene(scene2);
            Stage s7 = new Stage(); s7.setScene(scene7);  s7.show();
            
            Stage stg7 = (Stage)((Node)event.getSource()).getScene().getWindow();
            //Stage stg2 = (Stage)((Node)b1).getScene().getWindow();
            //if b1 is the fxid of thee button
            
            stg7.setScene(scene7);
            stg7.show();
        } catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
