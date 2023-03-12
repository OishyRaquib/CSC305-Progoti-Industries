/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercfo;

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
public class FinSummaryController implements Initializable {

    @FXML
    private Button writePolicyButton;
    @FXML
    private TextArea writeSummary;
    @FXML
    private Button readFile;
    @FXML
    private TextArea postedSummary;
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
    private void writeSummaryOnClick(ActionEvent event) {
               File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
          
            f = new File("SummaryFinText.txt");      
          
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	writeSummary.getText()
                	
                   
            );   
                    
                      
        
        } catch (IOException ex) {
            Logger.getLogger(FinSummaryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FinSummaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void backOnClick(ActionEvent event) {
         try{
     Parent scene14Parent = FXMLLoader.load(getClass().getResource("CFAO1.fxml"));
            Scene scene14 = new Scene(scene14Parent);
           
            Stage s14 = new Stage(); s14.setScene(scene14);  s14.show();
            
            Stage stg14 = (Stage)((Node)event.getSource()).getScene().getWindow();
          
            
            stg14.setScene(scene14);
            stg14.show();
        } catch (IOException ex) {
            Logger.getLogger(FinSummaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    

    @FXML
    private void readFileOnClick(ActionEvent event) {
        postedSummary.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("SummaryFinText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                postedSummary.setText("Content of policy.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                    postedSummary.setText(
                            str+ " "+"\n"
                    );
                }
            }
            else 
               postedSummary.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(FinSummaryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
        
    }
    
}

