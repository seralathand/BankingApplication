package view;

import java.util.Scanner;
import controler.Validation;
import controler.LoginControl;

public class LoginPage {
    Scanner input=new Scanner(System.in);
    LoginControl loginControl =new LoginControl();

        public int login(){
            System.out.println("LogIn\n------");
            System.out.println("Enter Your Account Number: ");
            int accNo=Validation.numberValidateOnly("Please Enter Valid Account Number:");
            System.out.println("Enter Your Password: ");
            String password=Validation.passwordValidate(input.next());
           if( loginControl.loginCheck(accNo,password))
               return accNo;
           return -1;

        }
    }

