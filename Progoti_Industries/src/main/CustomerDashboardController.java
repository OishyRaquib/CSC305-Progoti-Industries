/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
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
import mypkg.Orders;
import mypkg.SalesExcutive.SalesExecutiveDashboardController;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class CustomerDashboardController implements Initializable {

    @FXML private TextArea onSaleTextArea;
    @FXML private TextField carName;
    @FXML private TextField amountOfCars;
    @FXML private TextField orgName;
    @FXML private TextField agentName;
    @FXML private TextField agentPhone;
    @FXML private Button logOutBtn;
    @FXML private TextArea customRequirements;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutBtn(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/mypkg/MainScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewOnSaleBtn(ActionEvent event) {
        //outputTextArea.setText("");
        onSaleTextArea.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("OnSaleList.txt");
            sc = new Scanner(f);
            if(f.exists()){
                onSaleTextArea.appendText("The Cars Available are.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    onSaleTextArea.appendText(
                            "Name="+tokens[0]
                            +", Amount="+tokens[1]+
                                    "\n"

                    );
                }
            }
            else 
                onSaleTextArea.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void placeOrderBtn(ActionEvent event) {
               
//        Orders newOrder;
//        newOrder = new Orders();
//        newOrder.setAgentName(agentName.getText());
//        newOrder.setCarName(carName.getText());
//        newOrder.setAgentPhone(Integer.parseInt(agentPhone.getText()));
//        newOrder.setOrgName(orgName.getText());
//        newOrder.setAmountOfcars(Integer.parseInt(amountOfCars.getText()));;
        
        
        File f = null;
        FileWriter fw = null;
        FileChooser fc = null;
        try {

            f = new File("Orders.txt");      
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
//                    newOrder.getAgentName()+", "
//                    +newOrder.getAgentPhone()+", "
//                    +newOrder.getCarName()+", "
//                    +newOrder.getAmountOfcars()+", "
//                    +newOrder.getOrgName()+"\n"
            	carName.getText()+","
                +orgName.getText()+","	
                +agentName.getText()+","	
                +agentPhone.getText()+","
                +amountOfCars.getText()+","
               +customRequirements.getText()+"/n"
            );
            
            carName.clear();
            orgName.clear();
            agentName.clear();
            agentPhone.clear();
            amountOfCars.clear();
            customRequirements.clear();
            
        } catch (IOException ex) {
            Logger.getLogger(CustomerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CustomerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//end of controller method
    
}
