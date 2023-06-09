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
import javafx.stage.Stage;


public class HomePageQCController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewSurveys(ActionEvent event) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("viewSurveys.fxml"));
        
        Scene homescene = new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homescene);
        stage.show();
    }

    @FXML
    private void viewComplaints(ActionEvent event) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("viewComplaints.fxml"));
        
        Scene homescene = new Scene(homepage);
        Stage stage=new Stage();
        stage.setScene(homescene);
        stage.show();
    }
    
}
