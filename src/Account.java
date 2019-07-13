/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahyu mau
 */
public class Account {
    private int accountNumber;
    private int pin;
    private Balance balance;

    public Account(int accountNumber, int pin, Balance balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
        

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
    
    public void debit(int amount){        
        this.balance.setAvailableBalance(this.balance.getAvailableBalance()-amount);
        this.balance.setTotalBalance(this.balance.getTotalBalance()-amount);
    }
    
    public void credit(int amount){
        this.balance.setTotalBalance(this.balance.getTotalBalance()+amount);
    }
    
    public boolean validatePin(int pin){
        return (this.pin == pin);
    }
    
    
}
