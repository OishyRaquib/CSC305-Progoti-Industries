/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HomePageController implements Initializable {

    @FXML
    private Text model_name;
    @FXML
    private Text model2_name;
    @FXML
    private Text model3_name;
    @FXML
    private Text model4_name;
    @FXML
    private Text model5_name;
    private CustomerInd customer;
    @FXML
    private Text fx_surveyButton;
    @FXML
    private Button history_fx;
    
    public void receiveCustomer(CustomerInd customer_){
        customer=customer_;
        System.out.println("I received: "+customer.toString());
    }
    public void receiveCustomer(String user){
        ObjectInputStream ois=null;
        try {
            CustomerInd c;
            ois = new ObjectInputStream(new FileInputStream("customersList.bin"));
            

            while(true){
               c = (CustomerInd) ois.readObject();
               //customers.add(c);
               if (user==c.getUsername()){
                   customer=c;
                   System.out.println("Customer found: "+customer.toString());
               }
            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //options.getItems().addAll("Track Product", "Preview Product" ,"File Complaint");
        
    }    

    @FXML
    private void GoToProfile(ActionEvent event) throws IOException{
//        Parent profile=FXMLLoader.load(getClass().getResource("Profile.fxml"));
//        Scene profileScene=new Scene(profile);
//        Stage stage= new Stage();
//        stage.setScene(profileScene);
//        stage.show();
    }

    @FXML
    private void BuyPHEV(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
        Parent cart=loader.load();
        
        ShoppingCartController controller=loader.getController();
        
        controller.changeFields(model_name.getText(),customer);

        Scene cartScene=new Scene(cart);
        Stage stage= new Stage();
        stage.setScene(cartScene);
        stage.show();
    }

    @FXML
    private void BuyQX(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
        Parent cart=loader.load();
        
        ShoppingCartController controller=loader.getController();
        
        controller.changeFields(model2_name.getText(),customer);

        Scene cartScene=new Scene(cart);
        Stage stage= new Stage();
        stage.setScene(cartScene);
        stage.show();
    }

    @FXML
    private void BuyASX(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
        Parent cart=loader.load();
        
        ShoppingCartController controller=loader.getController();
        
        controller.changeFields(model3_name.getText(),customer);

        Scene cartScene=new Scene(cart);
        Stage stage= new Stage();
        stage.setScene(cartScene);
        stage.show();
    }

    @FXML
    private void BuyPickup(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
        Parent cart=loader.load();
        
        ShoppingCartController controller=loader.getController();
        
        controller.changeFields(model4_name.getText(),customer);

        Scene cartScene=new Scene(cart);
        Stage stage= new Stage();
        stage.setScene(cartScene);
        stage.show();
    }

    @FXML
    private void BuyScorpio(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
        Parent cart=loader.load();
        
        ShoppingCartController controller=loader.getController();
        
        controller.changeFields(model5_name.getText(),customer);

        Scene cartScene=new Scene(cart);
        Stage stage= new Stage();
        stage.setScene(cartScene);
        stage.show();
    }

    @FXML
    private void openSurveyFormOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("SurveyScene.fxml"));
        Parent survey=loader.load();


        Scene surveyScene=new Scene(survey);
        Stage stage= new Stage();
        stage.setScene(surveyScene);
        stage.show();
    }


    @FXML
    private void complainOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FileComplainScene.fxml"));
        Parent complain=loader.load();

        FileComplainSceneController controller=loader.getController();

        controller.takeID(customer.getUsername());

        Scene complainScene=new Scene(complain);
        Stage stage= new Stage();
        stage.setScene(complainScene);
        stage.show();
    }

    @FXML
    private void purchaseHistoryOnClick(ActionEvent event) throws IOException {
//        FXMLLoader loader=new FXMLLoader();
//        loader.setLocation(getClass().getResource("PurchaseHistory.fxml"));
//        Parent history=loader.load();
//
//        PurchaseHistoryController controller=loader.getController();
//
//        controller.receiveCustomer(customer);
//
//        Scene historyScene=new Scene(history);
//        Stage stage= new Stage();
//        stage.setScene(historyScene);
//        stage.show();
    }

    @FXML
    private void previewOnClick(ActionEvent event) throws IOException{
        Parent homepage=FXMLLoader.load(getClass().getResource("PreviewVehicles.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();
    }
    
}
