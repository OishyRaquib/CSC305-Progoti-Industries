/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;


public class CustomerComplaint implements Serializable{
    private String customerId;
    private String rant;

    public CustomerComplaint(String customerId, String rant) {
        this.customerId = customerId;
        this.rant = rant;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRant() {
        return rant;
    }

    public void setRant(String rant) {
        this.rant = rant;
    }

    @Override
    public String toString() {
        return "CustomerComplaint{" + "customerId=" + customerId + ", rant=" + rant + '}';
    }
    
    
}
