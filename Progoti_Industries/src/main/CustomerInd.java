package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;

public class CustomerInd extends User implements Serializable{
    String name;
    int phoneNumber;
    String address;
    String nidNumber;
    LocalDate dateOb;
    String emailAddress;
    int AccountNumber;
    ArrayList<PurchasedVehicle> purchasedVehicles;
    public CustomerInd(){}
    public CustomerInd(String name, int phoneNumber, String address, String nidNumber, LocalDate dateOb, String emailAddress){
         this.name=name;
         this.phoneNumber=phoneNumber;
         this.address=address;
         this.nidNumber=nidNumber;
         this.dateOb=dateOb;
         this.emailAddress=emailAddress;
    }
    public CustomerInd(String username, String password) {
        super(username, password);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }

    public LocalDate getDateOb() {
        return dateOb;
    }

    public void setDateOb(LocalDate dateOb) {
        this.dateOb = dateOb;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    public CustomerInd getCustomerIndividual(){
        return this;
    }

    @Override
    public String toString() {
        return "CustomerInd{" + "name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", nidNumber=" + nidNumber + ", dateOb=" + dateOb + ", emailAddress=" + emailAddress + ", username="+username+ ", password="+password+"}";
    }
    
    public void purchase(Vehicle v){
        LocalDate date=LocalDate.now();
        PurchasedVehicle v_bought=new PurchasedVehicle(username,date,0,v.getVehicleMFD(),v.getModelName(),v.getVehicleColor(),v.getWheelSize());
        purchasedVehicles.add(v_bought);
        
        
    }
    public ArrayList<PurchasedVehicle> trackProducts(){
        return purchasedVehicles;
    }
}
