package view;
import controler.Validation;
import controler.UsersDataProcess;
import java.util.Scanner;
import model.UserDetails;
import model.AddressDetails;

public class SignUpPage {
    private Scanner input=new Scanner(System.in);
    UserDetails userDetails;
    AddressDetails addressDetails;
    UsersDataProcess usersDataProcess=UsersDataProcess.getInstance();

    public void createAccount(){
        System.out.println("Please Register Your Details:-");
        System.out.println("-----------------------------");
        System.out.println("Enter your First Name: ");
        String firstName= Validation.stringValidate(input.next().trim());

        System.out.println("Enter your Last Name: ");
        String lastName=Validation.stringValidate(input.next().trim());

        System.out.println("Enter Your Date Of Birth: ");
        String dateOfBirth=Validation.dobValidate(input.next(),"Please Enter Valid Date Of Birth: ");

        System.out.println("Enter Your Age: ");
        byte age= (byte) Validation.numberValidate(18,60,"Age Should Be 18-50, Re Enter: ");

        System.out.println("Enter your Phone Number: ");
        String mobileNo= Validation.mobileNovalidate(input.next());
        String upiId=mobileNo+"@myBank";

        System.out.println("Enter your Email Address");
        String email= Validation.emailValidate(input.next());

        System.out.println("Enter Your Pan Card Number: ");
        String panCard=Validation.panCardValidate(input.next(),"Please Enter Valid Pan Card Number: ");

        System.out.println("Choose Your Account Type: ");
        String accType=  accType();

        System.out.println("Set Your Password: ");
        String password= Validation.passwordValidate(input.next());

        System.out.println("Enter Your Confirm Password: ");
        String confirmPassword=Validation.passwordCheck(password,input.next());

        System.out.println("Enter The Initial Account Opening Amount.500 : ");
        int balance=Validation.numberValidate(400,100000,"Minimum Account Opening Amount Above ₹400. ");

        userDetails=new UserDetails(upiId,firstName,lastName,dateOfBirth,age,accType,mobileNo,email,panCard,password,balance);
        int userId=usersDataProcess.storeData(userDetails);
        setAddressDetails(userId);
        System.out.println("Account Successfully Created.");
    }

    public void setAddressDetails(int userId){
        System.out.println("Address Details\n--------------");
        System.out.println("Enter Door Number: ");
        String doorNumber=input.next();
        input.nextLine();
        System.out.println("Enter Street Name: ");
        String streetName=input.nextLine();
        System.out.println("Enter city Name: ");
        String city=input.next();
        System.out.println("Enter District Name: ");
        String district=input.next();
        System.out.println("Enter State Name: ");
        String state=input.next();
        System.out.println("Enter Pincode: ");
        int pincode=input.nextInt();
        addressDetails=new AddressDetails(doorNumber,streetName,city,district,state,pincode,userId);
        usersDataProcess.addressStore(addressDetails);

    }
    private  String accType(){
        String accTypes[]={"Saving Account","Current Account"};
        int number=1;
        for(String x: accTypes){
            System.out.println(number+". "+x);
            number++;
        }
        int choice=input.nextInt();
        return accTypes[choice-1];
    }
}
