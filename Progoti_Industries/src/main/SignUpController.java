/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AshMan
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField name_fxid;
    @FXML
    private TextField phone_fxid;
    @FXML
    private TextField nid_fxid;
    @FXML
    private DatePicker dateofbirth_fxid;
    @FXML
    private TextArea address_fxid;
    @FXML
    private TextField email_fxid;
    
    private boolean checkInfo=false; 
   // private boolean setInfo=false;
    
    private CustomerInd customer;
    @FXML
    private TextField username_fxid;
    @FXML
    private PasswordField password_fxid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

//    private void SignUpOnClick(ActionEvent event) throws IOException{
////        signup_button.setText("Siging up...");
//            Alert error=new Alert(AlertType.ERROR);
//            error.setHeaderText("Error");
//            error.setContentText("All fields must be filled!");
//            error.showAndWait();
//            
//        //return stage;
//    }

    @FXML
    private void SignUpOnClick(ActionEvent event) throws IOException{
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("HomePage.fxml"));
                    Parent parent = loader.load();
                    
                    HomePageController controller = loader.getController();

                    Scene SignUpScene = new Scene(parent);
                    
                    customer=new CustomerInd();
                    
                    customer.setName(name_fxid.getText());
                    customer.setPhoneNumber(Integer.parseInt(phone_fxid.getText()));
                    customer.setAddress(address_fxid.getText());
                    customer.setNidNumber(nid_fxid.getText());
                    customer.setEmailAddress(email_fxid.getText());
                    customer.setDateOb(dateofbirth_fxid.getValue());
                    customer.setUsername(username_fxid.getText());
                    customer.setPassword(password_fxid.getText());
                    
                    System.out.println("Customer Adding: "+customer.toString());
            
                    File f = null;
                    FileOutputStream fos = null;      
                    ObjectOutputStream oos = null;

                    try {
                        f = new File("customersList.bin");
                        if(f.exists()){
                            fos = new FileOutputStream(f,true);
                        }
                        else{
                            fos = new FileOutputStream(f);
                        }

                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(customer);

                    } catch (IOException ex) {
                        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            if(oos != null) oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    //System.out.println(customer.toString());
                    //controller.initializeInst(name_fxid.getText(),Integer.parseInt(phone_fxid.getText()),address_fxid.getText(),nid_fxid.getText(),dateofbirth_fxid.getValue(),email_fxid.getText());
                    controller.receiveCustomer(customer);
                    
                    Stage stage=new Stage();
                    stage.setScene(SignUpScene);
                    stage.show();
    }
   
    
}
