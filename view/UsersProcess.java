package view;

import controler.Validation;

import java.util.Scanner;

public class UsersProcess {
    Scanner input=new Scanner(System.in);
    SignUpPage signUpPage=new SignUpPage();
    LoginPage loginPage=new LoginPage();
    ProfileView transactionView=new ProfileView();

    public void process(){
        System.out.println("1.Sign In\n2.LogIn\n3.Exit");
        switch(Validation.numberValidate(1,3,"Please Enter Valid Input: ")){
            case 1:
                signUpPage.createAccount();
                process();
                break;
            case 2:
                int accNo= loginPage.login();
                    if(accNo>0) {
                        userOperation(accNo);
                    }
                    else {
                        System.out.println("Your AccNo and Password Incorrect, Please Try Again.");
                    }
                process();
                break;
            default:
                System.out.println("Thank You For Visiting Our Bank.");
                return;
        }
    }
    private void userOperation(int accNo){
        UsersMoneyProcess usersMoneyProcess=new UsersMoneyProcess(accNo);

        System.out.println("\n1.My Profile\n2.Check Balance\n3.Deposit Money\n4.Withdraw Money\n5.Money Transaction\n6.Show Transaction\n7.Log Out");
        System.out.println("please Enter Your choice: ");
        switch(Validation.numberValidate(1,7,"Please Enter Valid Input: ")){
            case 1:
                myProfile(accNo);
                userOperation(accNo);
                break;
            case 2:
                usersMoneyProcess.checkBalance();
                userOperation(accNo);
                break;
            case 3:
                usersMoneyProcess.depositMoney(accNo);
                userOperation(accNo);
                break;
            case 4:
                usersMoneyProcess.withdrawMoney(accNo);
                userOperation(accNo);
                break;
            case 5:
                transaction(accNo,usersMoneyProcess);
                userOperation(accNo);
                break;
            case 6:
                usersMoneyProcess.transactions(accNo);
                userOperation(accNo);
                break;
            default:
                return;
        }
    }
    private void transaction(int accNo,UsersMoneyProcess usersMoneyProcess){
        System.out.println("\n1.To Bank A/c\n2.To Mobile Number\n3.To UPI Transfer\n4.Exit");
        System.out.println("please Enter Your choice: ");
        switch(Validation.numberValidate(1,4,"Please Enter Valid Input: ")){
            case 1:
                usersMoneyProcess.accountTransfer(accNo);
                return;
            case 2:
                usersMoneyProcess.mobileNumberTransfer(accNo);
                return;
            case 3:
                usersMoneyProcess.upiTransfer(accNo);
                return;
        }
    }
    ProfileView profile =new ProfileView();
    private void myProfile(int accNo){
        System.out.println("\n1.Address Details\n2.Account Details\n3.Back");
        switch(Validation.numberValidate(1,3,"Please Enter Valid Input: ")){
            case 1:
                profile.addressView(accNo);
                myProfile(accNo);
                break;
            case 2:
                profile.accountView(accNo);
                myProfile(accNo);
                break;
            default:
                break;
        }
    }
}
