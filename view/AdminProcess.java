package view;

import controler.AdminControl;
import controler.LoginControl;
import controler.TransactionControl;
import controler.Validation;
import model.TransactionDetails;
import model.UserDetails;

import java.util.List;
import java.util.Scanner;

public class AdminProcess {
    private Scanner input=new Scanner(System.in);
    LoginControl loginControl=new LoginControl();
    AdminControl adminControl=new AdminControl();
    ProfileView profileView=new ProfileView();
    TransactionControl transactionControl=new TransactionControl();

    public void admin(){
        System.out.println("Enter the User Name: ");
        String userName=Validation.userNameValidate(input.next());
        System.out.println("Enter the Password: ");
        String password= Validation.passwordValidate(input.next());
        if(loginControl.loginCheck(userName,password))
            adminControl();
        else
            System.out.println("Wrong UserName & Password.");

    }
    private void adminControl(){
        System.out.println("\n1.show Customers\n2.Search Customer\n3.Show transactions\n4.Log Out");
        int choice =Validation.numberValidate(1,4,"Please Enter Valid Input: ");
        switch(choice){
            case 1:
               showCustomers();
                adminControl();
                break;
            case 2:
                searchCustomers();
                adminControl();
                break;
            case 3:
                transactions();
                adminControl();
                break;
            case 4:
                break;
        }
    }

    private void showCustomers(){
        List<UserDetails> customers=adminControl.showCustomers();
        System.out.println("+-----------+---------------------+-------------+---------------------+---------------+------------+");
        System.out.printf("| %-10s| %-20s| %-12s| %-20s| %-15s| %-10s|\n","AccNo","Name","PhoneNumber","UPI Id","AccType"," AccStatus");
        System.out.println("+-----------+---------------------+-------------+---------------------+---------------+------------+");
        for(UserDetails users:customers)
            System.out.printf("| %-10d| %-20s| %-12s| %-20s| %-15s| %-10s|\n",users.getAccNo(),users.getFirstName(),users.getPhoneNo()
                    ,users.getUpiId(),users.getAccType(),users.getAccStatus());
        System.out.println("+-----------+---------------------+-------------+---------------------+---------------+------------+");
    }
    private void searchCustomers(){
        System.out.println("1.User's Account Details\n2.user's Address Details\n3.Back");
        int choice=input.nextInt();
        if(!(choice>0 && choice<3) ){
            System.out.println("Invalid Input: ");
            return;
        }

        System.out.println("Enter the User's Account Number: ");
        int accNo=input.nextInt();
        switch(choice){
            case 1:
                profileView.accountView(accNo);
                searchCustomers();
                break;
            case 2:
                profileView.addressView(accNo);
                searchCustomers();
                break;
            default:
                break;

        }
    }
    private void transactions(){
        System.out.println("1.All Transactions\n2.search user's Transactions\n3.Back");
        switch(Validation.numberValidate(1,4,"Please Enter Valid Input: ")){
            case 1:
                userTransactions();
                transactions();
                break;
            case 2:
                searchTransaction();
                transactions();
                break;
            default:
                break;

        }
    }
    private  void userTransactions(){
        List<TransactionDetails> allTransactions=adminControl.transactions();
        System.out.println("Transaction Details");
        System.out.println("+-------------+------------------+------------+------------+------------------+");
        System.out.printf("| %-12s| %-17s| %-11s| %-11s| %-17s|\n","Date","Particulars","Depicted","Credited","Closing Balance");
        System.out.println("+-------------+------------------+------------+------------+------------------+");
        for(TransactionDetails trans:allTransactions)
            System.out.printf("| %-12s| %-17s| %-11s| %-11s| %-17.2f|\n",trans.getDate(),trans.getParticulars(),trans.getDepicted(),
        trans.getCredited(),trans.getClosingBalance());
        System.out.println("+-------------+------------------+------------+------------+------------------+");
    }
    public void searchTransaction(){
        System.out.println("Enter The Customer's Account Number: ");
        List<TransactionDetails> allTransactions= transactionControl.transactionDetails(input.nextInt());
        System.out.println("Transaction Details");
        System.out.println("+-------------+------------------+------------+--------------------+------------------+-------------+");
        System.out.printf("| %-12s| %-17s| %-11s| %-17s| %-17s|\n","Date","Particulars","Depicted","Credited","Closing Balance");
        System.out.println("+-------------+------------------+------------+------------+------------------+");
        for(TransactionDetails trans:allTransactions)
            System.out.printf("| %-12s| %-17s| %-11s| %-17s| %-17.2f|\n",trans.getDate(),trans.getParticulars(),trans.getDepicted(),
                    trans.getCredited(),trans.getClosingBalance());
        System.out.println("+-------------+------------------+------------+------------+------------------+");

    }
}
