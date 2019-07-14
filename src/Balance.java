/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahyu mau
 */
public class Balance {
    private double totalBalance;
    private double availableBalance;

    public Balance(double totalBalance, double availableBalance) {
        this.totalBalance = totalBalance;
        this.availableBalance = availableBalance;
    }
        

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
    
    public void displayBalance(){
        System.out.printf("- Available balance: ");
        displayDollarAmount(this.availableBalance);
        
        System.out.printf("- Total balance: ");
        displayDollarAmount(this.totalBalance);
    }
    
    public void displayDollarAmount(double amount) {
      System.out.printf("$%,.2f\n", amount);   
    }
    
    
}
