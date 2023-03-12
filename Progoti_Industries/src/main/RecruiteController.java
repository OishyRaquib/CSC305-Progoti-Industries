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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class RecruiteController implements Initializable {

    @FXML
    private Button readF;
    @FXML
    private TextField enterName;
    @FXML
    private TextField iD;
    @FXML
    private TextField serial;
    @FXML
    private TextField designation;
    @FXML
    private Button addRecruite;
    @FXML
    private TextArea textArea;
    @FXML
    private Label recruiteCount;
    @FXML
    private Button goBack;
    int counter=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void readFile(ActionEvent event) {
         //outputTextArea.setText("");
        textArea.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("ReqText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                textArea.appendText("Content of Emp.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    textArea.appendText(
                            "Name="+tokens[0]
                            +", ID="+tokens[1]
                            +", Serieal="+tokens[2]+",Designation="+tokens[3]+
                                    "\n"                    
                            
                    );
                }
            }
            else 
                textArea.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(RecruiteController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
    
    
    recruiteCount.setText(Integer.toString(counter));
    }

    @FXML
    private void addRecruiteOnClick(ActionEvent event) {
         counter=counter+1;
         File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
      

            f = new File("ReqText.txt");      
            
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	enterName.getText()+","
                +iD.getText()+","	
                +serial.getText()+","+designation.getText()+"\n"		
                    
            );           
             
        } catch (IOException ex) {
            Logger.getLogger(RecruiteController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(RecruiteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void clickGoBack(ActionEvent event) {
                  try{
     Parent scene10Parent = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
            Scene scene10 = new Scene(scene10Parent);
            //stage.setScene(scene2);
            Stage s10 = new Stage(); s10.setScene(scene10);  s10.show();
            
            Stage stg10 = (Stage)((Node)event.getSource()).getScene().getWindow();
            //Stage stg2 = (Stage)((Node)b1).getScene().getWindow();
            //if b1 is the fxid of thee button
            
            stg10.setScene(scene10);
            stg10.show();
        } catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    

