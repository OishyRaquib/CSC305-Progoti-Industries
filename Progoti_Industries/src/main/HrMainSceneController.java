/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user1pkj;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class HrMainSceneController implements Initializable {

    @FXML
    private Button salarayGen;
    @FXML
    private Button seeEmployeeList;
    @FXML
    private Button seeLeaveList;
    @FXML
    private Button notice;
    @FXML
    private Button viewPolicy;
    @FXML
    private Label hrName;
    @FXML
    private Label hrID;
    @FXML
    private Label hREmail;
    @FXML
    private Label hrContactnumber;
    @FXML
    private Button hrUpdateContactNumber;
    @FXML
    private Button hrUpdateEmail;
    @FXML
    private Button Recruitement;
    @FXML
    private Button retiredList;
    @FXML
    private TextArea noticeAreaCommon;
    @FXML
    private Button viewCommonNottice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToSalGenOnClick(ActionEvent event)throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("CalcGen.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        //stage.setScene(scene2);
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 

        
        stg2.setScene(scene2);
        stg2.show();
    }
      @FXML
    private void goToNoticeOnClick(ActionEvent event) throws IOException {
        Parent scene3Parent = FXMLLoader.load(getClass().getResource("Notice.fxml"));
        Scene scene3 = new Scene(scene3Parent);
        //stage.setScene(scene2);
        Stage s3 = new Stage(); s3.setScene(scene3);  s3.show();
               
        Stage stg3 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
       
        
        stg3.setScene(scene3);
        stg3.show();
    
    }

    @FXML
    private void goToEmployeeListOnCLick(ActionEvent event) {

        try {
            Parent scene4Parent = FXMLLoader.load(getClass().getResource("employeeList.fxml"));
            Scene scene4 = new Scene(scene4Parent);
           
            Stage s4 = new Stage(); s4.setScene(scene4);  s4.show();
            
            Stage stg4 = (Stage)((Node)event.getSource()).getScene().getWindow();
          
            
            stg4.setScene(scene4);
            stg4.show();
        } catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void goToRetiredList(ActionEvent event) {
           

        try {
            Parent scene5Parent = FXMLLoader.load(getClass().getResource("retiredEmployees.fxml"));
            Scene scene5 = new Scene(scene5Parent);
         
            Stage s5 = new Stage(); s5.setScene(scene5);  s5.show();
            
            Stage stg5 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            stg5.setScene(scene5);
            stg5.show();
        } catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void goToPolicyOnClick(ActionEvent event) {
        try {
            Parent scene5Parent = FXMLLoader.load(getClass().getResource("policy.fxml"));
            Scene scene5 = new Scene(scene5Parent);
          
            Stage s5 = new Stage(); s5.setScene(scene5);  s5.show();
            
            Stage stg5 = (Stage)((Node)event.getSource()).getScene().getWindow();
           
            
            stg5.setScene(scene5);
            stg5.show();
        } catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewCommonNoticeOnClick(ActionEvent event) {
   
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("NoticeText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                noticeAreaCommon.setText("Notice"+"\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                    noticeAreaCommon.setText(
                            str+ "\n"
                    );
                }
            }
            else 
               noticeAreaCommon.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }  
    }

    @FXML
    private void goToRecruitOnClick(ActionEvent event) {
              try {
            Parent scene9Parent = FXMLLoader.load(getClass().getResource("recruite.fxml"));
            Scene scene9 = new Scene(scene9Parent);
          
            Stage s9 = new Stage(); s9.setScene(scene9);  s9.show();
            
            Stage stg9 = (Stage)((Node)event.getSource()).getScene().getWindow();
           
            
            stg9.setScene(scene9);
            stg9.show();
        } catch (IOException ex) {
            Logger.getLogger(HrMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
  


    

  






