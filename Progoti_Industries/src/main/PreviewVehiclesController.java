/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class PreviewVehiclesController implements Initializable {
    private CustomerInd customer;
    @FXML
    private TextArea preview_fx;
    @FXML
    private Button back;
    
    public void receiveCustomer(CustomerInd customer_){
        customer=customer_;
        System.out.println("I received: "+customer.toString());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String str;
        for(PurchasedVehicle v: customer.trackProducts()){
            str=v.getModelName()+ " "+v.getPrice()+"\n";
            preview_fx.setText(str);
        }
    }    
    
    @FXML
    public void goBackOnClick() throws IOException{
        Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
    
    
    
}
