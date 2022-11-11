package controler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validation {
    static Scanner input=new Scanner(System.in);

    public static String stringValidate(String name){
        while(!name.matches("[a-zA-Z]+")){
            System.out.println("Input Mismatch, Re Enter: ");
            name=input.nextLine();
        }
        return name.trim();
    }
    public static int numberValidateOnly(String message){
        int number=0;
        while(true) {
            try {
                  number=Integer.parseInt(input.next());
                  if(number>0) break;
                  else throw new Exception();
            }
            catch(Exception e){
                System.out.println(message);
            }
        }
    return number;
    }

    public static int numberValidate(int startValue,int endValue,String message){
        int output=0;
        while(true) {
            try {output =Integer.parseInt (input.next());
                if (output >= startValue && output <= endValue) break;
                else throw new Exception();
            }
            catch(Exception e){System.out.println(message);
            }
        }
        return output;
    }
    public static String mobileNovalidate(String mobileNo){
        while(!mobileNo.matches("[6-9][0-9]{9}")){
            System.out.println("Input Mismatch, Re Enter Valid Mobile Number: ");
            mobileNo=input.next();
        }
        return mobileNo;
    }
    public static String emailValidate(String email){
        while(!email.matches("^[a-zA-Z0-9+-_]+@[a-zA-z]+.[a-z]+$")){
            System.out.println("Input Mismatch, Re Enter Valid Email Address : ");
            email=input.next();
        }
        return email;
    }
    public static String passwordValidate(String password){
        while(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,16}$")){
            System.out.println("Password Mismatch, Set Strong Password: ");
            password=input.next();
        }
        return password;
    }
    static public String dateAndTime(){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now=LocalDateTime.now();
        return dtf.format(now);
    }
    static public String dobValidate(String dob,String message){
        while(!dob.matches("^[0-3][0-9]-[01][0-9]-[0-9]{4}$")){
            System.out.println(message);
            dob=input.next();
        }
        return dob;
    }
    public static String panCardValidate(String pan,String message){
        while(!pan.matches("[a-z]{5}[0-9]{4}[A-Z]{1}")){
            System.out.println(message);
            pan=input.next();
        }
        return pan;
    }
    static public String passwordCheck(String password1,String password2){
       while(!password1.equals(password2)){
           System.out.println("Your Password Not Same! ");
           password2=input.next();
       }
       return password2;
    }
     static public String userNameValidate(String userName){
     while(!userName.matches("[A-Za-z]+[1-9]{3}")){
         System.out.println("Please Enter Valid User Name: ");
         userName=input.next();
     }
     return userName;
    }
}
