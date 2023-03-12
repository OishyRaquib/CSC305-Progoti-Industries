
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginPageController implements Initializable {
    
    @FXML
    private ComboBox typeBox;
    @FXML
    private Button login_button;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button signup_1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeBox.getItems().addAll("QC Manager","Customer Individual", "Customer Organizational","Senior Organizer", "Production Executive", "Sales Executive", "Chief of Finance & Accounts", "Human Resource Officer");
    }    
    @FXML
    private void loginOnClick(ActionEvent event) throws IOException {
        if (typeBox.getValue().toString().equals("Customer Individual"))  {
//            Helper help=new Helper();
             //   login_button.setText("Loggin in...");
//            if (help.checkCustomer(username.getText(), password.getText())==true){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("HomePage.fxml"));
                Parent homepage = loader.load();
        
                HomePageController controller=loader.getController();
                
                controller.receiveCustomer(username.getText());
                
                Scene homescene = new Scene(homepage);
                Stage stage=new Stage();
                stage.setScene(homescene);
                stage.show();
//            }
//            else{
//                Alert confirm=new Alert(AlertType.ERROR);
//                confirm.setHeaderText("Invalid user");
//                confirm.setContentText("Password or username may have been incorrect.");
//                confirm.showAndWait();
//            }  
        }
        else if (typeBox.getValue().toString().equals("QC Manager")) {
            Parent homepage = FXMLLoader.load(getClass().getResource("HomePageQC.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Senior Organizer")){
            Parent homepage = FXMLLoader.load(getClass().getResource("seniorOrganizer.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Production Executive")){
            Parent homepage = FXMLLoader.load(getClass().getResource("main.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Customer Organizational")){
            Parent homepage = FXMLLoader.load(getClass().getResource("CustomerDashboard.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Sales Executive")){
            Parent homepage = FXMLLoader.load(getClass().getResource("SalesExecutiveDashboard.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Chief of Finance & Accounts")){
            Parent homepage = FXMLLoader.load(getClass().getResource("CFAO1.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
        else if (typeBox.getValue().toString().equals("Human Resource Officer")){
            Parent homepage = FXMLLoader.load(getClass().getResource("hrMainScene.fxml"));
        
            Scene homescene = new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homescene);
            stage.show();
        }
    }

    @FXML
    private void CreateAccountScene(ActionEvent event) throws IOException {
        Parent child = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        
        Scene scene1 = new Scene(child);
        Stage stage1=new Stage();
        stage1.setScene(scene1);
        stage1.show();
    }


    }
