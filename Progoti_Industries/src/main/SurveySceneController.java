/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SurveySceneController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private ComboBox product_rate;
    @FXML
    private ComboBox delivery_rate;
    @FXML
    private ComboBox emp_rate;
    @FXML
    private ComboBox exp_rate;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        product_rate.getItems().addAll("1","2","3","4","5");
        delivery_rate.getItems().addAll("1","2","3","4","5");
        emp_rate.getItems().addAll("1","2","3","4","5");
        exp_rate.getItems().addAll("1","2","3","4","5");
    }    

    @FXML
    private void goBackOnClick(ActionEvent event) throws IOException {
        Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene homeScene=new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homeScene);
        stage.show();
    }

    @FXML
    private void submitSurveyForm(ActionEvent event) throws IOException{
        SurveyForm survey=new SurveyForm(
                Integer.parseInt(product_rate.getValue().toString()),
                Integer.parseInt(delivery_rate.getValue().toString()),
                Integer.parseInt(emp_rate.getValue().toString()),
                Integer.parseInt(exp_rate.getValue().toString())
        );
        Helper help=new Helper();
        if (help.addSurveysToList(survey)==true){
            Alert error=new Alert(Alert.AlertType.CONFIRMATION);
            error.setHeaderText("Success");
            error.setContentText("Survey has been recorded successfully.");
            error.showAndWait();
            
            Parent homepage=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homeScene=new Scene(homepage);
            Stage stage=new Stage();
            stage.setScene(homeScene);
            stage.show();
        }
        else{
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Unsuccessful");
            error.setContentText("Survey could not be recorded successfully.");
            error.showAndWait();
        }
        
        
        
    }
    
}
