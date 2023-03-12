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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class AssignBudgets1Controller implements Initializable {

    @FXML
    private TextField eventfield;
    @FXML
    private TextField salary;
    @FXML
    private TextField production;
    @FXML
    private TextArea textAreaASsignedBudgets;
    @FXML
    private Button assignBudget;
    @FXML
    private Button readAssignBudget1;
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
    private void clickToAssignBudget(ActionEvent event) {
         
         File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
      

            f = new File("AssignedBudget.txt");      
            
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	eventfield.getText()+","
                +salary.getText()+","	
                +production.getText()+"\n"		
                    
            );           
             
        } catch (IOException ex) {
            Logger.getLogger(AssignBudgets1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AssignBudgets1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void clickReadFromAssignBudget(ActionEvent event) {
        
        textAreaASsignedBudgets.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("AssignedBudget.txt");
            sc = new Scanner(f);
            if(f.exists()){
               textAreaASsignedBudgets.setText("Content of AssignedBudget.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    textAreaASsignedBudgets.setText(
                            "Event="+tokens[0]
                            +",Salary="+tokens[1]
                            +", Production="+tokens[2]+
                                    "\n"                    
                            
                    );
                }
            }
            else 
                textAreaASsignedBudgets.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(AssignBudgets1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }   
    }

    @FXML
    private void clickToBack(ActionEvent event) {
        try{
     Parent scene12Parent = FXMLLoader.load(getClass().getResource("CFAO1.fxml"));
            Scene scene12 = new Scene(scene12Parent);
           
            Stage s12 = new Stage(); s12.setScene(scene12);  s12.show();
            
            Stage stg12 = (Stage)((Node)event.getSource()).getScene().getWindow();
          
            
            stg12.setScene(scene12);
            stg12.show();
        } catch (IOException ex) {
            Logger.getLogger(CFAO1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }


   

