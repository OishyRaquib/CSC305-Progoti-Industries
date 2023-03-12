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
public class RetiredEmployeesController implements Initializable {

    @FXML
    private Button readFRE;
    @FXML
    private TextField enterNameRE;
    @FXML
    private TextField iDRE;
    @FXML
    private TextField serialRE;
    @FXML
    private TextField designationRE;
    @FXML
    private Button addRetiredEmployee;
    @FXML
    private TextArea textAreaRE;
    @FXML
    private Label retiredEmployeeCount;
    @FXML
    private Button goBackRE;
    int counterRE=0;
    
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
        textAreaRE.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("RetEmpText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                textAreaRE.appendText("Content of RetiredEmployee.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    textAreaRE.appendText(
                            "Name="+tokens[0]
                            +", ID="+tokens[1]
                            +", Serieal="+tokens[2]+",Designation="+tokens[3]+
                                    "\n"                    
                            
                    );
                }
            }
            else 
                textAreaRE.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(EmployeeListController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
    
    
   
    }
    
    


    @FXML
    private void clickGoBack(ActionEvent event) {
         try{
     Parent scene6Parent = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
            Scene scene6 = new Scene(scene6Parent);
            //stage.setScene(scene2);
            Stage s6 = new Stage(); s6.setScene(scene6);  s6.show();
            
            Stage stg6 = (Stage)((Node)event.getSource()).getScene().getWindow();
            //Stage stg2 = (Stage)((Node)b1).getScene().getWindow();
            //if b1 is the fxid of thee button
            
            stg6.setScene(scene6);
            stg6.show();
        } catch (IOException ex) {
            Logger.getLogger(EmployeeListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        
    }

    @FXML
    private void addRetiredEmployeeOnClick(ActionEvent event) {
        
     counterRE=counterRE+1;
         File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        //fw = new FileWriter("abc.txt");
        try {
      

            f = new File("RetEmpText.txt");      
            
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	enterNameRE.getText()+","
                +iDRE.getText()+","	
                +serialRE.getText()+","+designationRE.getText()+"\n"		
                    
            );           
             
        } catch (IOException ex) {
            Logger.getLogger(EmployeeListController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EmployeeListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         retiredEmployeeCount.setText(Integer.toString(counterRE));
    }
    
}
