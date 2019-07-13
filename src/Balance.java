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
    private int totalBalance;
    private int availableBalance;

    public Balance(int totalBalance, int availableBalance) {
        this.totalBalance = totalBalance;
        this.availableBalance = availableBalance;
    }
        

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }
    
    public void displayBalance(){
        System.out.println(this.totalBalance);
        System.out.println(this.availableBalance);
    }
    
    
}
