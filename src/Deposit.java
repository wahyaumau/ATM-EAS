
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wahyu mau
 */
public class Deposit implements Transaction{
    private final static int CANCELED = 0;
    private Account account;

    public Deposit(Account account) {
        this.account = account;
    }
    
    private int promptForAmount(){       
        System.out.println("\nPlease enter a deposit amount in CENTS (or 0 to cancel)");  
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();     
        if(input == CANCELED) return CANCELED;  
     else{  
       return input / 100;
     }
   }
        
    @Override
    public void onTransaction() {
        int amount = promptForAmount();
        if(amount != CANCELED){         
            System.out.println("\nPlease insert a deposit envelope containing ");  
            System.out.println(amount);                
            account.credit(amount);
        }else{         
            System.out.println("\nCanceling transaction...");  
        }
    }    
}
