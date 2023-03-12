/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aman
 */
public class SeniorOrganizerSceneController implements Initializable {

    @FXML
    private Button profileButton;
    @FXML
    private Button viewStockButton;
    @FXML
    private Label balanceView;
    @FXML
    private Button purchasedProductScene;
    @FXML
    private TextArea showStock;
    @FXML
    private Button requestBalanceOnClick;
    @FXML
    private Button stopAllPurchases;
    @FXML
    private MenuItem createFile;
    @FXML
    private MenuItem viewFile;
    @FXML
    private MenuItem viewFiles;
    @FXML
    private MenuItem deleteFiles;
    @FXML
    private MenuItem purchasedShowTextFile;
    @FXML
    private MenuItem viewPurchaseRequest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profileButtonClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show();    }

    @FXML
    private void viewStockOncCick(ActionEvent event) throws FileNotFoundException, IOException {
        //outputTextArea.setText("");
        showStock.clear();
        File f = null;
        Scanner sc; String str; 
        try {
            f = new File("ViewStock.txt");
            sc = new Scanner(f);
            if(f.exists()){
                
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                   
                    showStock.appendText(
                            
                                 str +" \n"

                    );
                }
            }
            else 
                showStock.setText("oops! ViewStock.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(SeniorOrganizerSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }


   
        
    }
        
      

    
    @FXML
   private void purchasedProductScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("comparingScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show();    }

    @FXML
    private void requestBalanceOnClick(ActionEvent event) {
          File f = null;
        FileWriter fw = null;
        try {
           
            String str = "Low balance,need balance for further production";
            FileWriter fw2 = new FileWriter("lowFund.txt");
            fw2.write( str);
            fw2.close();

           
                      
  
        } catch (IOException ex) {
            Logger.getLogger(SeniorOrganizerSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
    }

    @FXML
    private void stopAllPurchases(ActionEvent event) {
           File f = null;
        FileWriter fw = null;
        try {
           
            String str = "All purchases are stopped for now";
            FileWriter fw2 = new FileWriter("stop.txt");
            fw2.write( str);
            fw2.close();

           
                      
  
        } catch (IOException ex) {
            Logger.getLogger(SeniorOrganizerSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           
        }
    }

    @FXML
    private void createFile(ActionEvent event) {
    }

    @FXML
    private void viewFile(ActionEvent event) {
    }

    @FXML
    private void viewFiles(ActionEvent event) {
    }

    @FXML
    private void deleteFiles(ActionEvent event) {
    }

    @FXML
    private void purchasedShowTextFile(ActionEvent event) {
    }

    @FXML
    private void viewPurchaseRequest(ActionEvent event) {
    }
    }

    

    


