/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahyu mau
 */
public class BankDatabase {
    private Account[] accounts;
   
   public BankDatabase() {
      accounts = new Account[2];
      accounts[0] = new Account(1234, 4321, new Balance(500.0,300.0));
      accounts[1] = new Account(8765, 5678, new Balance(300.0,100.0));        
   }
   
   public Account getAccount(int accountNumber) {
      for(int i = 0;i<accounts.length;i++){
          if(accountNumber == accounts[i].getAccountNumber()){
              return accounts[i];
          }
      }
       return null;
   }    
}
