/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SurveyForm implements Serializable{
    private int delayedDelivery;
    private int damagedProduct;
    private int employeeRating;
    private int overallRating;

    public SurveyForm(int delayedDelivery, int damagedProduct, int employeeRating, int overallRating) {
        this.delayedDelivery = delayedDelivery;
        this.damagedProduct = damagedProduct;
        this.employeeRating = employeeRating;
        this.overallRating = overallRating;
        
    }

    public int getDelayedDelivery() {
        return delayedDelivery;
    }

    public void setDelayedDelivery(int delayedDelivery) {
        this.delayedDelivery = delayedDelivery;
    }

    public int getDamagedProduct() {
        return damagedProduct;
    }

    public void setDamagedProduct(int damagedProduct) {
        this.damagedProduct = damagedProduct;
    }

    public int getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(int employeeRating) {
        this.employeeRating = employeeRating;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }
    public SurveyForm getSurveyForm(){
        
        return this;
    }
    
    @Override
    public String toString() {
        return "SurveyForm{" + "delayedDelivery=" + delayedDelivery + ", damagedProduct=" + damagedProduct + ", employeeRating=" + employeeRating + ", overallRating=" + overallRating + '}';
    }
    
    
}
