package mypkg;


public class Orders{
    private String agentName , orgName,carName;
    private int amountOfcars,agentPhone;

    public Orders(String agentName, String orgName, String carName, int amountOfcars, int agentPhone) {
        this.agentName = agentName;
        this.orgName = orgName;
        this.carName = carName;
        this.amountOfcars = amountOfcars;
        this.agentPhone = agentPhone;
    }


    public Orders(String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAgentName() {
        return agentName;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getCarName() {
        return carName;
    }

    public int getAmountOfcars() {
        return amountOfcars;
    }

    public int getAgentPhone() {
        return agentPhone;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setAmountOfcars(int amountOfcars) {
        this.amountOfcars = amountOfcars;
    }

    public void setAgentPhone(int agentPhone) {
        this.agentPhone = agentPhone;
    }
    
}