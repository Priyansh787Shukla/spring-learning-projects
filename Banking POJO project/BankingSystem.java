import java.util.Scanner;
import java.util.HashMap;
public class BankingSystem 
{
    static HashMap<Integer, BankAccount> map = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        System.out.println("\n\n    Welcome to the Banking System");
        int choice = 0;
        boolean flag = true;
        while(flag)
        {
            System.out.println("\n\t\tMenu\n\t(Select  One  Option)\n\n1.)Create New Account\n2.)Deposit Money\n3.)Withdraw Money\n4.)Display Account Details\n5.)Shows Balance\n6.)Exit\n");
            choice = sc.nextInt();
            int c = 0;
            switch(choice)
            {
                case 1: BankAccount obj = new BankAccount();
                        obj.createAcc(++key);
                        map.put(key, obj);
                        break;
                case 2: c = exists();
                        if(c!=0) map.get(c).deposit();
                        break;
                case 3: c = exists();
                        if(c!=0) map.get(c).withdraw();
                        break;
                case 4: c = exists();
                        if(c!=0) map.get(c).display();
                        break;
                case 5: c = exists();
                        if(c!=0) map.get(c).balance();
                        break;
                case 6: System.out.println("\nThank You for Banking with Us.\n\n\n");
                        flag = false;
                        break;
                default: System.out.println("\nInvalid Choice! Please select a valid option from the menu.\n");
            }
        }
        sc.close();
    }

    public static int exists()
    {
        int key = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account Number: ");
        key = sc.nextInt();
        if(!map.containsKey(key))
        {
            System.out.println("Account Does Not Exist.");
            return 0;
        }
        return key;
    }
}