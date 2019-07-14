
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
public class Atm {
    private BankDatabase bankDatabase;
    private CashDispenser cashDispenser;
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private Account currentAccount;
    
    //menu
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    
    public Atm(){
        userAuthenticated = false;        
        bankDatabase = new BankDatabase();
        cashDispenser = new CashDispenser();        
    }
    
    void run(){        
      while(true){
            while(!userAuthenticated){
                System.out.println("\nWelcome!");
                authenticateUser();    
            }             
            performTransactions();      
            userAuthenticated = false;  
            currentAccountNumber = 0;  
            System.out.println("\nThank You!\nGoodbye!");
        }
    }
    
    private void authenticateUser(){
        System.out.print("\nPlease enter your account number : ");
        Scanner scanner = new Scanner(System.in);
        int accountNumber = scanner.nextInt();
        System.out.printf("\nEnter your PIN : ");
        int pin = scanner.nextInt();
        Account account = bankDatabase.getAccount(accountNumber);
        if (account != null) {
            userAuthenticated = account.validatePin(pin);
            if(userAuthenticated){
            currentAccount = bankDatabase.getAccount(accountNumber);
            }else{
                System.out.println("Invalid PIN.");
                System.out.println("Please Try Again.");
            }            
        }else{
            System.out.println("Invalid Account Number.");
            System.out.println("Please Try Again.");
        }
    }    
    private int displayMainMenu(){
        System.out.println("\nMain Menu :");
        System.out.println("1 - View my balance");
        System.out.println("2 - Withdraw cash");
        System.out.println("3 - Deposit funds");
        System.out.println("4 - Exit\n");
        System.out.print("Enter a choice : ");
        Scanner scanner = new Scanner(System.in);        
        return scanner.nextInt();
    }
    
    private void performTransactions(){             
        boolean userExited = false;  
       
        while(!userExited){
            int mainMenuSelection = displayMainMenu();
            switch(mainMenuSelection){
                case BALANCE_INQUIRY :
                    currentAccount.getBalance().displayBalance();
                    break;
                case WITHDRAWAL :
                    Withdrawal withdrawal = new Withdrawal(currentAccount);
                    withdrawal.onTransaction();
                    break;
                case DEPOSIT :
                    Deposit deposit = new Deposit(currentAccount);
                    deposit.onTransaction();
                    break;                    
                case EXIT :
                    System.out.println("\nExiting the system...");
                    userExited = true;    
                    break;
                default :
                    System.out.println("\nYou did not enter a valid selection.");
                    System.out.println("Please try again.");
                    break;
            }  
        }
    }  
    
    
    
}
