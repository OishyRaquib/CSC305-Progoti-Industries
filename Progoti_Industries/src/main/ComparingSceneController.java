/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aman
 */
public class ComparingSceneController implements Initializable {
    FileChooser fileChooser = new FileChooser();

    @FXML
    private Button buttonToMainScene;
    @FXML
    private Button loadFiles1;
    @FXML
    private Button loadfiles2;
    @FXML
    private TextArea teaxtArea1;
    @FXML
    private TextArea textArea2;
    @FXML
    private Button buttonToUpdtaeVendorInfo;
    @FXML
    private TextArea textArea3;
    @FXML
    private Button viewVendorInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
   private void buttonToMainScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("seniorOrganizer.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        
        Stage s2 = new Stage(); s2.setScene(scene2);  s2.show();
               
        Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        
        stg2.setScene(scene2);
        stg2.show();    }

    @FXML
    private void loadFiles1(ActionEvent event) throws FileNotFoundException {
        File file= fileChooser.showOpenDialog(new Stage());
         try {
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                teaxtArea1.appendText(scanner.nextLine()+ "\n");
            }
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void loadfiles2(ActionEvent event) throws FileNotFoundException {
        File file= fileChooser.showOpenDialog(new Stage());
         try {
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                textArea2.appendText(scanner.nextLine()+ "\n");
            }
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void buttonToUpdtaeVendorInfo(ActionEvent event) throws FileNotFoundException {
        File file =fileChooser.showSaveDialog(new Stage());
        if(file!=null){
        saveSystem(file,textArea3.getText());
        }
    }

    @FXML
    private void viewVendorInfo(ActionEvent event) {
        File file= fileChooser.showOpenDialog(new Stage());
         try {
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                textArea3.appendText(scanner.nextLine()+ "\n");
            }
                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveSystem(File file,String content) throws FileNotFoundException{
        PrintWriter printWriter= new PrintWriter(file);
        printWriter.write(content);
        printWriter.close();
        
    }

    private static class printWriter {

        private static void close() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void write(String content) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public printWriter() {
        }
    }
}
