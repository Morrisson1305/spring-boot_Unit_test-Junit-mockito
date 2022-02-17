public class BankAcc {
    private  double bal;
    private double minbal;
    private boolean isActive =true;
    private String holdName;

    public BankAcc(double bal, double minbal) {
        this.bal = bal;
        this.minbal = minbal;

    }

    public String getHoldName() {
        return holdName;
    }

    public void setHoldName(String holdName) {
        this.holdName = holdName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getBal() {
        return bal;
    }

    public double getMinbal() {
        return minbal;
    }

    public  double withdraw(double amt){
        if(bal - amt > minbal){
            bal -=amt;
            return amt;
        }
        else
            throw new RuntimeException();
    }

    public double deposit(double amt){
        return  bal += amt;
    }

}
