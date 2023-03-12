
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class FileComplainSceneController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TextArea complain_fxid;
    private String customerID;

    /**
     * Initializes the controller class.
     */
    public void takeID(String customer){
        customerID=customer;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void submitComplainOnClick(ActionEvent event) throws IOException {
        CustomerComplaint complain=new CustomerComplaint(
            customerID,
            complain_fxid.getText()
        );
        Helper help=new Helper();
        if (help.addComplainsToList(complain)==true){
            Alert error=new Alert(Alert.AlertType.CONFIRMATION);
            error.setHeaderText("Success");
            error.setContentText("Complaint has been recorded.");
            error.showAndWait();
        }
        else{
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Unsuccessful");
            error.setContentText("Complaint could not be recorded successfully.");
            error.showAndWait();
        }
    }
    
}
