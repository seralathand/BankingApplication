package view;

import controler.TransactionControl;
import controler.UsersMoneyControl;
import controler.Validation;
import model.UserDetails;
import model.TransactionDetails;

import java.util.Scanner;
import java.util.Stack;

public class UsersMoneyProcess implements Money {
    Scanner input=new Scanner(System.in);
    UsersMoneyControl usersMoneyControl =new UsersMoneyControl();
    TransactionControl transactionControl=new TransactionControl();
    UserDetails userDetails;
    TransactionDetails transactionDetails;

    public UsersMoneyProcess(int accNo){
        userDetails= usersMoneyControl.userBalance(accNo);
    }

    public void checkBalance(){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
    }
    public void depositMoney(int accNo){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
        System.out.println("Enter Your Deposit Money: ");
        double amount=input.nextDouble();
        if(amount>0){

            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Credited","",
                    String.valueOf("+"+amount),userDetails.getBalance()+amount,accNo);//getting transaction details to store details in table
            transactionControl.transaction(transactionDetails);//passing transaction details to store transaction table

            amount=userDetails.getBalance()+amount;
            if(usersMoneyControl.updateMoney(accNo,amount)==1)
                System.out.println("Amount Added Successfully.");
        }
        else
            System.out.println("Amount Cannot Be Negative.");
    }
    public void withdrawMoney(int accNo){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
        System.out.println("Enter Your The Withdraw Amount:");
        double amount=input.nextDouble();

        if(userDetails.getBalance()-amount>0){

            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Withdrawn",String.valueOf("-"+amount),
                    "",userDetails.getBalance()-amount,accNo);
            transactionControl.transaction(transactionDetails);

            amount=userDetails.getBalance()-amount;
            if(usersMoneyControl.updateMoney(accNo,amount)==1)
                System.out.println("Amount Withdraw Successfully.");
        }
        else{
            System.out.println("Insufficient Balance.");
        }
    }

    public void accountTransfer(int accNo){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
        System.out.println("Enter Transfer Account Number: ");
        int accountNumber=input.nextInt();
        if(accountNumber==accNo) {
            System.out.println("Wrong Account Number");
            return;
        }
        String name=usersMoneyControl.isAccount(accountNumber);
        if(name.equals("false")) {
            System.out.println("Entered Account Number Not Exit.");
            return;
        }
        System.out.println("Account Holder Name: "+name);
        System.out.println("Enter Transfer Amount:");
        double amount=input.nextDouble();
        if(userDetails.getBalance()-amount>0){
            //updating amount to users
            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Account Transfer",String.valueOf("-"+amount),
                    "",userDetails.getBalance()-amount,accNo);
            transactionControl.transaction(transactionDetails);

            usersMoneyControl.updateMoney(accNo,userDetails.getBalance()-amount);
            double receiverBalance=usersMoneyControl.userBalance(accountNumber).getBalance()+amount;

            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Credited","",
                    String.valueOf("+"+amount),receiverBalance,accountNumber);//getting transaction details to store details in table
            transactionControl.transaction(transactionDetails);//passing transaction details to store transaction table

            usersMoneyControl.updateMoney(accountNumber,receiverBalance);
            System.out.println("Amount Transfer successfully Done...");
        }
        else
            System.out.println("Insufficient Balance.");
    }

    public void upiTransfer(int accNo){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
        System.out.println("Enter UPI id: ");
        String upiId=input.next();

        String name=usersMoneyControl.isUpiId(upiId);
        if(name.equals("false")){
            System.out.println("Entered UPI Id Not Exist.");
            return;
        }
        System.out.println("Name : "+name);
        System.out.println("Enter Transfer Amount:");
        double amount=input.nextDouble();
        if(userDetails.getBalance()-amount>0){

            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"UPI Transfer",String.valueOf("-"+amount),
                    "",userDetails.getBalance()-amount,accNo);
            transactionControl.transaction(transactionDetails);

            usersMoneyControl.updateMoney(accNo,userDetails.getBalance()-amount);
            usersMoneyControl.upiIdTransfer(upiId,amount);
            System.out.println("Amount Transfer Successfully Done.");
        }
        else
            System.out.println("Insufficient Balance.");
    }

    public void mobileNumberTransfer(int accNo){
        System.out.println("Your Account Balance: "+userDetails.getBalance());
        System.out.println("Enter Mobile Number: ");
        String phoneNumber=input.next();

        String name=usersMoneyControl.isMobileNumber(phoneNumber);
        if(name.equals("false")){
            System.out.println("Entered Mobile Number Not Exist.");
            return;
        }
        System.out.println("Name : "+name);
        System.out.println("Enter the Transfer Amount: ");
        double amount=input.nextDouble();

        if(userDetails.getBalance()-amount>0){
            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"phoneNo Transfer",String.valueOf("-"+amount),
                    "",userDetails.getBalance()-amount,accNo);
            transactionControl.transaction(transactionDetails);

            usersMoneyControl.updateMoney(accNo,userDetails.getBalance()-amount);
            usersMoneyControl.mobileTransfer(phoneNumber,amount);
            System.out.println("Amount Transfer Successfully Done.");
        }
        else
            System.out.println("Insufficient Balance.");

    }

    Stack<TransactionDetails> transactionList;
    public void transactions(int accNo){
        transactionList=transactionControl.transactionDetails(accNo);
        int transactionControl=0;
        System.out.println("Transaction Details");
        System.out.println("+-------------+------------------+------------+------------+------------------+");
        System.out.printf("| %-12s| %-17s| %-11s| %-11s| %-17s|\n","Date","Particulars","Depicted","Credited","Closing Balance");
        System.out.println("+-------------+------------------+------------+------------+------------------+");
        while(!transactionList.isEmpty() && transactionControl!=5){
            System.out.printf("| %-12s| %-17s| %-11s| %-11s| %-17.2f|\n",transactionList.peek().getDate(),transactionList.peek().getParticulars(),
                    transactionList.peek().getDepicted(),transactionList.peek().getCredited(),transactionList.peek().getClosingBalance());
            transactionList.pop();
            transactionControl++;
        }
        System.out.println("+-------------+------------------+------------+------------+------------------+");

    }
}
