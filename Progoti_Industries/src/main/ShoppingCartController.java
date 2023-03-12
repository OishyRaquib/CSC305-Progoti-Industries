
package main;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ShoppingCartController implements Initializable {

    @FXML
    private Text brand_id;
    @FXML
    private Text model_id;
    @FXML
    private ComboBox colorCombo;
    @FXML
    private ComboBox wheelCombo;
    @FXML
    private Text price_id;
    
    public void changeFields(String model, CustomerInd customer){
        System.out.println("I am here with "+model);
        ObjectInputStream object=null;
        try{
            FileInputStream file=new FileInputStream("vehiclesList.bin");
            object = new ObjectInputStream(file);
            Vehicle v;
            while(true){
                v=(Vehicle) object.readObject();
                String temp=v.getModelName();
                //System.out.println(temp+"temp");
                if (temp.equals(model)){
                    //PurchasedVehicle vehicle;
                    //System.out.println("Found model!!"+model);
                    //brand_label.setText(v.getBrandName());
                    //model_label.setText(model);
                    brand_id.setText(v.getBrandName());
                    model_id.setText(model);
                    price_id.setText(v.getPrice());
                    v.setVehicleColor(colorCombo.getValue().toString());
                    v.setWheelSize(Integer.parseInt(wheelCombo.getValue().toString()));
                    customer.purchase(v);
                    
                    
                    
                    //customer.purchase(v);
                    object.close();
                    break;
                }
            }
         }
        catch (Exception e){
            System.out.println("Exception caught!");
            try {
                if(object!=null)
                    object.close();
            } catch (IOException ex1) { 
                System.out.println("Exception caught2!");
            }   
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wheelCombo.getItems().addAll(14,15,16,17,18,19);
        colorCombo.getItems().addAll("Black","Red","Blue","Green","Yellow","Pink","Maroon","Gray", "White");
        
    }    

    @FXML
    private void GoToProfile(ActionEvent event) throws IOException{
//        Parent profile=FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        Scene profileScene=new Scene(profile);
//        Stage stage=new Stage();
//        stage.setScene(profileScene);
//        stage.show();
    }

    @FXML
    private void ConfirmPurchase(ActionEvent event) throws IOException{
        Alert confirm=new Alert(AlertType.CONFIRMATION);
        confirm.setHeaderText("Confirm your purchase");
        confirm.setContentText("Are you sure you want to proceed?");
        confirm.showAndWait();
        
        Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    private void GoBackToHomePage(ActionEvent event) throws IOException{
        Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
    
}
