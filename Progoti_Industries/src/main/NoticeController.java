/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user1pkj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahnaf
 */
public class NoticeController implements Initializable {

    public TextArea noticeFieldForHR;
    @FXML
    private Button updateNoticeButton;
    @FXML
    private TextArea noticeFieldForHR1;
    private Label noticelabelHr;
    @FXML
    private Button updateNoticeButton1;
    private TextArea noticePosted;
    @FXML
    private TextArea postedNotice;
    @FXML
    private Button goBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void updateNoticeOnClick(ActionEvent event) {
    
    
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        
        try {
          
            f = new File("NoticeText.txt");      
          
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	noticeFieldForHR1.getText()
                	
                   
            );   
                    
                      
        
        } catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        
 

    @FXML
    private void clickGoBack(ActionEvent event) {
        
    try{
     Parent scene5Parent = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
            Scene scene5 = new Scene(scene5Parent);
            //stage.setScene(scene2);
            Stage s5 = new Stage(); s5.setScene(scene5);  s5.show();
            
            Stage stg5 = (Stage)((Node)event.getSource()).getScene().getWindow();
            //Stage stg2 = (Stage)((Node)b1).getScene().getWindow();
            //if b1 is the fxid of thee button
            
            stg5.setScene(scene5);
            stg5.show();
        } catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void postNoticeOnClick(ActionEvent event) {
  
    //outputTextArea.setText("");
        postedNotice.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("NoticeText.txt");
            sc = new Scanner(f);
            if(f.exists()){
                postedNotice.setText("Content of RetiredEmployee.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split("..");
                    postedNotice.setText(
                            str+ "\n"
                    );
                }
            }
            else 
                postedNotice.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(NoticeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }  
    }
}



    
   

 

    


    
    
    

