
package main;

import java.time.LocalDate;


class PurchasedVehicle extends Vehicle{
    String customerId;
    LocalDate purchasedDate;
    int installmentMonths;
    boolean installmentCreated;
    boolean warrantyStatus;
    
//    public PurchasedVehicle(){
//        
//    }
    
    public PurchasedVehicle(int vehicleNumber, LocalDate vehicleMFD, String modelName, String vehicleColor, int wheelSize) {
        super(vehicleNumber, vehicleMFD, modelName, vehicleColor, wheelSize);
    }

    public PurchasedVehicle(String customerId, LocalDate purchasedDate, int vehicleNumber, LocalDate vehicleMFD, String modelName, String vehicleColor, int wheelSize) {
        super(vehicleNumber, vehicleMFD, modelName, vehicleColor, wheelSize);
        this.customerId = customerId;
        this.purchasedDate = purchasedDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public int getInstallmentMonths() {
        return installmentMonths;
    }

    public void setInstallmentMonths(int installmentMonths) {
        this.installmentMonths = installmentMonths;
    }

    public boolean isInstallmentCreated() {
        return installmentCreated;
    }

    public void setInstallmentCreated(boolean installmentCreated) {
        this.installmentCreated = installmentCreated;
    }

    public boolean isWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(boolean warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    @Override
    public String toString() {
        return "PurchasedVehicle{" + "customerId=" + customerId + ", purchasedDate=" + purchasedDate + ", installmentMonths=" + installmentMonths + ", installmentCreated=" + installmentCreated + ", warrantyStatus=" + warrantyStatus + '}';
    }
    
    public PurchasedVehicle getPurchasedVehicle(){
        return this;
    }
}
