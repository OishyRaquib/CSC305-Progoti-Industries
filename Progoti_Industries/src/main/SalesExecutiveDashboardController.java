/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg.SalesExcutive;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class SalesExecutiveDashboardController implements Initializable {

    @FXML private TextArea viewReport;
    @FXML
    private TextArea noticeBox;
    @FXML
    private TextArea previewNoticeBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutBtn(ActionEvent event) throws IOException {
         Parent mainSceneParent = FXMLLoader.load(getClass().getResource("/mypkg/MainScene.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void viewManufacturerReportbtn(ActionEvent event) {
        //outputTextArea.setText("");
        viewReport.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("ManufacturedCars.txt");
            sc = new Scanner(f);
            if(f.exists()){
                viewReport.appendText("The Cars Available are.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    viewReport.appendText(
                            "Name="+tokens[0]
                            +", Amount="+tokens[1]+
                                    "\n"

                    );
                }
            }
            else 
                viewReport.setText("oops! Emp.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void putOnSaleBtn(ActionEvent event) throws IOException {;
        try {
            File fr = new File("ManufacturedCars.txt");
            Scanner sc = new Scanner(fr);
            FileWriter fw = new FileWriter("OnSaleList.txt");
            String str="";
                while(sc.hasNextLine()){
                    str += sc.nextLine();
                }
                fw.write(str);
                fw.close();
            } catch (IOException ex) {
            }
    }

    private void While(boolean hasNextLine) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @FXML
    private void viewOrderBtn(ActionEvent event) {
       //outputTextArea.setText("");
        viewReport.clear();
        File f = null;
        //FileReader fw = null;
        Scanner sc; String str; String[] tokens;
        try {
            f = new File("Orders.txt");
            sc = new Scanner(f);
            if(f.exists()){
                viewReport.appendText("The that just arrived.txt:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    viewReport.appendText("Car Name= "+tokens[0]+"\nOrganization Name= "+tokens[1]+"\nAgent Name= "+tokens[2]+"\nAgent Phone= "+tokens[3]+"\nThe Number Of Cars Ordered= "+tokens[4]+"\nCustome Requirements= "+tokens[5]+"\n\n"

                    );
                }
            }
            else 
                viewReport.setText("No Orders Are Available Now");
        } 
        catch (IOException ex) {
            Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void postNoticeBtn(ActionEvent event) {

        noticeBox.clear();
        File notice = null;
        //FileReader fw = null;
        Scanner noticeSc; String noticeStr; String[] Ntokens;
        try {
            notice = new File("Notice.txt");
            noticeSc = new Scanner(notice);
            if(notice.exists()){
                noticeBox.setText("Content of policy.txt:\n");
                while(noticeSc.hasNextLine()){
                    noticeStr=noticeSc.nextLine();
                    Ntokens = noticeStr.split("..");
                    noticeBox.setText(
                            noticeStr+ "\n"
                    );
                }
            }
            else 
               noticeBox.setText("oops! policyText.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }
    }

    @FXML
    private void upsdateNoticeBtn(ActionEvent event) {
                File f = null;
        FileWriter fw = null;
        FileChooser fc = null;

        try {

            f = new File("Notice.txt");

            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);

            fw.write(
                previewNoticeBox.getText()


            );



        } catch (IOException ex) {
            Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(SalesExecutiveDashboardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
