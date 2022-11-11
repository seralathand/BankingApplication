package view;

import controler.ProfileControl;
import model.AddressDetails;
import model.UserDetails;

public class ProfileView {
    ProfileControl profileControl=new ProfileControl();
    AddressDetails addressDetails;
    public void addressView(int accNo){
         addressDetails= profileControl.address(accNo);
        System.out.println("\nAddress Details.....");
        System.out.println("Door No     : "+addressDetails.getDoorNo());
        System.out.println("Street Name : "+addressDetails.getStreet());
        System.out.println("City        : "+addressDetails.getCity());
        System.out.println("District    : "+addressDetails.getDistrict());
        System.out.println("State       : "+addressDetails.getState());
        System.out.println("Pincode     : "+addressDetails.getPincode());
    }
    UserDetails userDetails;
    public void accountView (int accNo){
        userDetails=profileControl.account(accNo);
        System.out.println("\nAccount Details.....");
        System.out.println("Name           : "+userDetails.getName());
        System.out.println("Account Number : "+accNo);
        System.out.println("UPI Id         : "+userDetails.getUpiId());
        System.out.println("Mobile Number  : "+userDetails.getPhoneNo());
    }
}
