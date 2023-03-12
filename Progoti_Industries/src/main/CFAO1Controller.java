/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usercfo;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class CFAO1Controller implements Initializable {

    @FXML
    private TextArea noticeBoardCFAO;
    @FXML
    private Button cfoViewFinacneReport;
    @FXML
    private Button cfoAssignBudget;
    @FXML
    private Button cfoCreateSummary;
    @FXML
    private Button cfoLogout;
    @FXML
    private Button cfoRiskAnalysis;
    @FXML
    private Button cfoProfitAnalysis;
    @FXML
    private Label cfoNameField;
    @FXML
    private Label cfoIDField;
    @FXML
    private Label cfoEmailField;
    @FXML
    private Label cfeEmailField1;
    @FXML
    private Button viewNoticeCFO;
    @FXML
    private Button cfoUpdateContactNo;
    @FXML
    private Button cfoUpdateMail;
    @FXML
    private Button cfoSuggestProduction;
    @FXML
    private Label companyBudget;
    @FXML
    private Label salesBudget;
    @FXML
    private Button cfoUpdateBudget;
    @FXML
    private Button eventBudget;
    @FXML
    private TextArea financeReport;
    @FXML
    private Button cfoUpdateSales;
    @FXML
    private Label eventBudget1;
    @FXML
    private TextField budget;
    @FXML
    private TextField event;
    @FXML
    private TextField sales;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewSales(ActionEvent event) {
     financeReport.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("SalesText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                financeReport.setText("Content of Sales.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                    financeReport.setText(
                            str+ "\n"
                    );
                }
            }
            else 
               financeReport.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(CFAO1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }  
    }
    

    @FXML
    private void assignBudgetOnCLick(ActionEvent event) {
             try{
     Parent scene11Parent = FXMLLoader.load(getClass().getResource("assignBudgets1.fxml"));
            Scene scene11 = new Scene(scene11Parent);
           
            Stage s11 = new Stage(); s11.setScene(scene11);  s11.show();
            
            Stage stg11 = (Stage)((Node)event.getSource()).getScene().getWindow();
          
            
            stg11.setScene(scene11);
            stg11.show();
        } catch (IOException ex) {
            Logger.getLogger(CFAO1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void createSummaryOnClick(ActionEvent event) {
        try{
        Parent scene13Parent = FXMLLoader.load(getClass().getResource("finSummary.fxml"));
            Scene scene13 = new Scene(scene13Parent);
           
            Stage s13 = new Stage(); s13.setScene(scene13);  s13.show();
            
            Stage stg13 = (Stage)((Node)event.getSource()).getScene().getWindow();
          
            
            stg13.setScene(scene13);
            stg13.show();
        } catch (IOException ex) {
            Logger.getLogger(CFAO1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void createRiskAnalysis(ActionEvent event) {
    }

    @FXML
    private void createProfitAnalysis(ActionEvent event) {
    }

    @FXML
    private void viewNoticeOnClick(ActionEvent event) {
           File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("NoticeText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                noticeBoardCFAO.setText("Notice"+"\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                noticeBoardCFAO.setText(
                            str+ "\n"
                    );
                }
            }
            else 
               noticeBoardCFAO.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(CFAO1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        } 
    }

    @FXML
    private void suggestProductionOnClick(ActionEvent event) {
        
    }

    @FXML
    private void updateBudgetOnClick(ActionEvent event) {
        
    }

    @FXML
    private void updateEventBudgetOnCLick(ActionEvent event) {
    
    }

    @FXML
    private void updateSalesOnClick(ActionEvent event) {
    
    }
    
}
