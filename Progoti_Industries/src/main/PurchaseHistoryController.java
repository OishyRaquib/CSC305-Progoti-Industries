/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AshMan
 */
public class PurchaseHistoryController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TableColumn<PurchasedVehicle, String> model_column;
    @FXML
    private TableColumn<PurchasedVehicle, String> color_column;
    @FXML
    private TableColumn<PurchasedVehicle, String> wheel_column;
    @FXML
    private TableColumn<PurchasedVehicle, String> price_column;
    private CustomerInd customer;
    @FXML
    private TableView<PurchasedVehicle> tableView;
    
    public void receiveCustomer(CustomerInd customer_){
        customer=customer_;
        System.out.println("I received: "+customer.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setItems(getVehicles());    
        
    }    
    public ObservableList<PurchasedVehicle> getVehicles(){
        ObservableList<PurchasedVehicle> v = FXCollections.observableArrayList();
        
        for(PurchasedVehicle vehicle: customer.purchasedVehicles){
            v.add(vehicle);
        }
   
        return v;
    }
    @FXML
    private void goBackOnClick(ActionEvent event) throws IOException {
        Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();

    }
    
}
