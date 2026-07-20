import java.util.Scanner;
public class BankAccount
{
    private String name;
    private int accNo;
    private double balance;

    public void createAcc(int accNo)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n<-----Account Creation Wizard----->\n");
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        this.accNo = accNo;
        balance = 0.0D;
        System.out.println("\nAccount Created Successfully!\n");
        display();
    }

    public void deposit()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n<-----Money Deposit Wizard----->\n");
        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();
        if(amount > 0)
        {
            balance += amount;
            System.out.println("\nAmount Deposited Successfully!\n");
        }
        else
        {
            System.out.println("\nInvalid Amount!\n");
        }
        display();
    }

    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n<-----Money Withdrawel Wizard----->\n");
        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();
        if(amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("\nAmount Withdrawn Successfully!\n");
        }
        else
        {
            System.out.println("\nInvalid Amount! Please enter a positive value less than or equal to your balance.\n");
            withdraw();
        }
        display();
    }

    public void display()
    {
        System.out.println("\n<-----Account Details----->\n");
        System.out.println("Name: "+name);
        System.out.println("Account Number: "+accNo);
        System.out.println("Balance: Rs. "+balance+"\n");
    }

    public void balance()
    {
        System.out.println("\nCurrent Balance: Rs." + balance+"\n");
    }

    
}