
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
public class Withdrawal implements Transaction{
    private static final int CANCELED = 6;    
    private Account account;
    private CashDispenser cashDispenser;

    public Withdrawal(Account account) {
        this.account = account;
        cashDispenser = new CashDispenser();
    }
    
    private int promptForAmount(){  
     int userChoice = 0;
     Scanner scanner = new Scanner(System.in);
     int[] amounts = {0, 20, 40, 60, 100, 200};       
     while(userChoice == 0){         
       System.out.println("\nWithdrawal Menu : ");  
       System.out.println("1 - $20");  
       System.out.println("2 - $40");  
       System.out.println("3 - $60");  
       System.out.println("4 - $100");  
       System.out.println("5 - $200");  
       System.out.println("6 - Cancel Transaction");  
       System.out.print("\nChoose a withdrawal amount : ");  
       int input = scanner.nextInt();         
       switch(input){           
         case 1 :  
         case 2 :  
         case 3 :  
         case 4 :  
         case 5 :  
           userChoice = amounts[input];    // save user's choice  
           break;  
         case CANCELED :             
           userChoice = CANCELED;
           break;  
         default :             
           System.out.println("\nInvalid selection.");  
           System.out.println("Try again.");  
       }
     }
     return userChoice;
   }

    @Override
    public void onTransaction() {        
        boolean cashDispensed = false;
        Scanner scanner = new Scanner(System.in);
        do{ 
            int amount = promptForAmount();         
            if(amount != CANCELED){
                if(account.getBalance().getAvailableBalance() >= amount ){             
                    if(cashDispenser.isSufficientCashAvailable(amount)){  
                        account.debit((double) amount);
                        cashDispenser.dispenseCash(amount);
                        cashDispensed = true;
                        System.out.println("\nYour cash has been dispensed. Please take your cash now.");  
                    }else{  
                        System.out.println("\nInsufficient cash available in the ATM.");  
                        System.out.println("\nPlease choose a smaller amount.");  
                    }           
                }else{             
                    System.out.println("\nInsufficient funds in your account.");  
                    System.out.println("\nPlease choose a smaller amount.");             
                }
            }else{           
                System.out.println("\nCancelling transactions...");  
                return;
            }
        }  while(!cashDispensed);          
    }      
}