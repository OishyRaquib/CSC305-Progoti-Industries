
package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;


public class Vehicle implements Serializable {
    int vehicleNumber;
    String brandName;
    LocalDate vehicleMFD;
    String modelName;
    String vehicleColor;
    String price;
    int wheelSize;
    boolean safetyStatus;
    boolean QCpassed;
    boolean compabilityStatus;
    
    public Vehicle(){
        safetyStatus=false;
        QCpassed=false;
        compabilityStatus=false;
    }
    public Vehicle(int vehicleNumber, LocalDate vehicleMFD, String modelName, String vehicleColor, int wheelSize) {
        this.vehicleNumber = 2000;
        this.vehicleMFD = vehicleMFD;
        this.modelName = modelName;
        this.vehicleColor = vehicleColor;
        this.wheelSize = wheelSize;
        safetyStatus=true;
        QCpassed= true;
        compabilityStatus=true;
    }
    public Vehicle(String brandName, String modelName,String price) {
        this.brandName= brandName;
        this.price=price;
        //Random rand=new Random();
        //this.vehicleNumber = rand.range(1000);
        this.vehicleMFD = LocalDate.of(2022,1,1);
        this.modelName = modelName;
//        this.vehicleColor = "White";
//        this.wheelSize = wheelSize;
        safetyStatus=true;
        QCpassed= true;
        compabilityStatus=true;
    }
    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public LocalDate getVehicleMFD() {
        return vehicleMFD;
    }

    public void setVehicleMFD(LocalDate vehicleMFD) {
        this.vehicleMFD = vehicleMFD;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public boolean isSafetyStatus() {
        return safetyStatus;
    }

    public void setSafetyStatus(boolean safetyStatus) {
        this.safetyStatus = safetyStatus;
    }

    public boolean isQCpassed() {
        return QCpassed;
    }

    public void setQCpassed(boolean QCpassed) {
        this.QCpassed = QCpassed;
    }

    public boolean isCompabilityStatus() {
        return compabilityStatus;
    }

    public void setCompabilityStatus(boolean compabilityStatus) {
        this.compabilityStatus = compabilityStatus;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleNumber=" + vehicleNumber + ", vehicleMFD=" + vehicleMFD + ", modelName=" + modelName + ", vehicleColor=" + vehicleColor + ", wheelSize=" + wheelSize + ", safetyStatus=" + safetyStatus + ", QCpassed=" + QCpassed + ", compabilityStatus=" + compabilityStatus + " ,price="+price+'}';
    }
    
    public Vehicle getVehicle(){
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
