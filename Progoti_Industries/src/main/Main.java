/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Helper helper=new Helper();
        helper.addVehiclestoList();
        
//        helper.seeCustomersList();
//        helper.seeComplainList();
        
//        ArrayList<Vehicle> vehicles=new ArrayList<Vehicle>();
//        vehicles.add(new Vehicle("MITSUBISHI","PAJERO SPORT QX","5,000,000"));
//        vehicles.add(new Vehicle("MITSUBISHI","OUTLANDER PHEV","2,500,000"));
//        vehicles.add(new Vehicle("MITSUBISHI","ASX JEEP","5,000,000"));
//        vehicles.add(new Vehicle("MITSUBISHI","L200 PICKUP","1,600,000"));
//        vehicles.add(new Vehicle("MITSUBISHI","SCORPIO D/C","200,000"));
//        
//        for(Vehicle v:vehicles){
//            System.out.println(v);
//        }   
//            File file=null;
//            ObjectOutputStream ds=null;
//        try{
//            file=new File("vehiclesList.bin");
//            FileOutputStream fs=new FileOutputStream(file);
//            ds=new ObjectOutputStream(fs);
//            System.out.println("Writing vehicles into file ...");
//            for(Vehicle v:vehicles){
//                Vehicle temp=new Vehicle();
//                temp=v;
//                System.out.println(temp);
//                ds.writeObject(temp);
//            }
//            
//        }
//        catch(Exception ex){
//            if(ds!=null){
//                ds.close();
//            }
//            System.out.println("I could not write vehicles");
//        }
            

         

        
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        
        Scene scene = new Scene(root);
       // Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
