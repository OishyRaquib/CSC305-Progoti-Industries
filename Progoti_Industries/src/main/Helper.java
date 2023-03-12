
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper implements Serializable{
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<CustomerInd> customers = new ArrayList<CustomerInd>();
    
    public void addVehiclestoList() throws IOException {
        ArrayList<Vehicle> vehicles=new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("MITSUBISHI","PAJERO SPORT QX","5,000,000"));
        vehicles.add(new Vehicle("MITSUBISHI","OUTLANDER PHEV","2,500,000"));
        vehicles.add(new Vehicle("MITSUBISHI","ASX JEEP","5,000,000"));
        vehicles.add(new Vehicle("MITSUBISHI","L200 PICKUP","1,600,000"));
        vehicles.add(new Vehicle("MITSUBISHI","SCORPIO D/C","200,000"));
        
//        for(Vehicle v:vehicles){
//            System.out.println(v);
//        }   
        File file=null;
        ObjectOutputStream ds=null;
        try{
            file=new File("vehiclesList.bin");
            FileOutputStream fs=new FileOutputStream(file);
            ds=new ObjectOutputStream(fs);
            System.out.println("Writing vehicles into file ...");
            for(Vehicle v:vehicles){
                System.out.println(v);
                ds.writeObject(v);
            }
            
        }
        catch(Exception ex){
            if(ds!=null){
                ds.close();
            }
            System.out.println("I could not write vehicles");
        }
    }
    public void readVehiclesFromList() throws IOException{
        ObjectInputStream ois=null;
        try {
            Vehicle v;
            System.out.println("I can read vehicles");

            ois = new ObjectInputStream(new FileInputStream("vehiclesList.bin"));
            

            while(true){
               v = (Vehicle) ois.readObject();
               System.out.println(v.toString());

            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
         
    }
    
    public void addCustomersToList(CustomerInd customer) throws IOException{
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("customersList.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
            }
            else{
                fos = new FileOutputStream(f);
            }
            
            oos = new ObjectOutputStream(fos);
            oos.writeObject(customer);

        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void seeCustomersList()throws IOException{
        ObjectInputStream ois=null;
        try {
            
            CustomerInd c;
            System.out.println("I can read customers");

            ois = new ObjectInputStream(new FileInputStream("customersList.bin"));
            

            while(true){
               c = (CustomerInd) ois.readObject();
               System.out.println(c.toString());

            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }
    
    public boolean checkCustomerRedundency(CustomerInd customer) throws IOException{
        ObjectInputStream ois=null;
        try {
            CustomerInd c;
            System.out.println("I can read customers");

            ois = new ObjectInputStream(new FileInputStream("customersList.bin"));
            

            while(true){
               c = (CustomerInd) ois.readObject();
               //customers.add(c);
               if (customer.getUsername()==c.getUsername()){
                return true;
               }
            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return false;
    }
    
    public boolean checkCustomer(String username, String password) throws IOException{
        ObjectInputStream ois=null;
        try {
            CustomerInd c;
            //System.out.println("I can read customers");

            ois = new ObjectInputStream(new FileInputStream("customersList.bin"));
            

            while(true){
               c = (CustomerInd) ois.readObject();
               //customers.add(c);
               if ((username==c.getUsername()) && (password==c.getPassword())){
                    return true;
               }
            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return false;
    }
    
    public boolean addSurveysToList(SurveyForm survey) throws IOException{
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("surveysList.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
            }
            else{
                fos = new FileOutputStream(f);
            }
            
            oos = new ObjectOutputStream(fos);
            oos.writeObject(survey);

        } catch (IOException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
//                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    
    
    public boolean addComplainsToList(CustomerComplaint complain) throws IOException{
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("complaintsList.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
            }
            else{
                fos = new FileOutputStream(f);
            }
            
            oos = new ObjectOutputStream(fos);
            oos.writeObject(complain);

        } catch (IOException ex) {
//            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
//                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    public void seeComplainList()throws IOException{
        ObjectInputStream ois=null;
        try {
            
            CustomerComplaint c;
            System.out.println("I can read complains");

            ois = new ObjectInputStream(new FileInputStream("complaintsList.bin"));
            

            while(true){
               c = (CustomerComplaint) ois.readObject();
               System.out.println(c.toString());

            }

                       
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
    }
}
