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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ViewSurveysController implements Initializable {

    @FXML
    private TextArea surveys_fxid;
    @FXML
    private Button back;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String str;String str1;
        ObjectInputStream ois=null;
        try {
            
            SurveyForm s;
            //System.out.println("I can read customers");

            ois = new ObjectInputStream(new FileInputStream("surveysList.bin"));
            

            while(true){
               s = (SurveyForm) ois.readObject();
               str="Delivery Rating: "+s.getDelayedDelivery()+ " Product Rating: "+s.getDamagedProduct()+ " Staff Rating: "+s.getEmployeeRating()+ " Overall: "+s.getOverallRating();
               surveys_fxid.setText(str);
            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
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
