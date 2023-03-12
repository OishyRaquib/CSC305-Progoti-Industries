/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user1pkj;

/**
 *
 * @author Ahnaf
 */
public class employeeList {
    int id;  
    String name;
    int serial;
    String designation;
    public employeeList(int id, String name, int serial, String designation) {  
        this.id = id;  
        this.name = name;
         this.serial=serial;
        this.designation = designation;
       
    }

 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSerial() {
        return serial;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }
    
 
      public void setserial(int serial) {
        this.serial = serial;
    }
        
         public void setdesignation(String designation) {
        this.designation = designation;
    }
    @Override
    public String toString() {
        return "employeeList{" + "id=" + id + ", name=" + name + ", serial=" + serial + ", designation=" + designation + '}';
    }

    
 
}
