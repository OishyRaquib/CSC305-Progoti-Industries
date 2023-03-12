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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class CalcGenController implements Initializable {

    @FXML
    private TextField Salary;
    @FXML
    private TextField Pension;
    @FXML
    private TextField TotalEmployee;
    @FXML
    private TextField TotalRetired;
    @FXML
    private Label sectionName1;
    @FXML
    private Label sectionname2;
    @FXML
    private Button CalculateSalary;
    @FXML
    private Button CalculatePension;
    @FXML
    private Button grandtotal;
    @FXML
    private Label TotalSalaryL;
    @FXML
    private Label TotalPensionL;
    @FXML
    private Label GrandTotalSalGenL;
    @FXML
    private Button backFromSalGen;
    @FXML
    private Button saveGrandTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickCalcSalary(ActionEvent event) {
        String salaryStr, employeeStr;
        double salaryVal,multi;
        int employeeVal;
        salaryStr = Salary.getText();
        employeeStr = TotalEmployee.getText();
        salaryVal=Double.parseDouble(salaryStr);
        
        employeeVal=Integer.parseInt(employeeStr);
        
              if(employeeVal>0 && salaryVal>0)         
        {
         
        multi=salaryVal*employeeVal;
        //TotalSalary.setText(Integer.toString(multi));
        TotalSalaryL.setText(Double.toString(multi));
          
        }
              else 
              {
              Alert a = new Alert(Alert.AlertType.ERROR);
              a.setContentText("Employee or Salary cannot be 0, cannot be negetive. Number of Employees Cannot be fractional");
              a.showAndWait();
              }
              

    }

    @FXML
    private void onClickCalcPension(ActionEvent event) {
         String PensionStr, RetiredStr;
        double PensionVal,multi2;
        int RetiredVal;
        PensionStr = Pension.getText();
        RetiredStr = TotalRetired.getText();
        PensionVal=Double.parseDouble(PensionStr);
        RetiredVal=Integer.parseInt(RetiredStr);
        if(PensionVal>0 && RetiredVal>0)
        {multi2=PensionVal*RetiredVal;
        //TotalPension.setText(Integer.toString(multi2));
        TotalPensionL.setText(Double.toString(multi2));
        }
    }

    @FXML
    private void onClickCalcGtotal(ActionEvent event) {
        double sal,pen,granTottal;
        String salSt,penSt;
        salSt = TotalSalaryL.getText();
        penSt = TotalPensionL.getText();
        sal=Double.parseDouble(salSt);
        pen=Double.parseDouble(penSt);
        granTottal = sal+pen;
        //GrandTotalSalGen.setText(Integer.toString(grandtotal));
        GrandTotalSalGenL.setText(Double.toString(granTottal));
        
        
    }

    @FXML
    private void goBackOnClick(ActionEvent event) {
    
    
    try {
            Parent scene4Parent = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
            Scene scene4 = new Scene(scene4Parent);
            //stage.setScene(scene2);
            Stage s4 = new Stage(); s4.setScene(scene4);  s4.show();
            
            Stage stg4 = (Stage)((Node)event.getSource()).getScene().getWindow();
            //Stage stg2 = (Stage)((Node)b1).getScene().getWindow();
            //if b1 is the fxid of thee button
            
            stg4.setScene(scene4);
            stg4.show();
        } catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @FXML
    private void storeSalaryPension(ActionEvent event) {
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
            int counter=1;

            f = new File("SalaryPensionText.txt");      
            
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	"Total From Pension AND Salary" + " "+GrandTotalSalGenL.getText() +"\n"		
                   
            );           
             
        } catch (IOException ex) {
            Logger.getLogger(CalcGenController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CalcGenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    
    
   

