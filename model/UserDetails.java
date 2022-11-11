package model;

public class UserDetails {
    private int accNo;
    private int userId;
    private String upiId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private String accType;
    private String phoneNo;
    private String emailId;
    private String panNumber;
    private String password;
    private double balance;
    private String accStatus;

    public UserDetails(){}
    public UserDetails(int accNo,String name,String phoneNo,String upiId,String accType,String accStatus){
        this.accNo=accNo;
        this.accType=accType;
        this.accStatus=accStatus;
        this.firstName=name;
        this.upiId=upiId;
        this.phoneNo=phoneNo;

    }
    public UserDetails(String name,String upiId,String phoneNumber ){
        this.firstName=name;
        this.upiId=upiId;
        this.phoneNo=phoneNumber;
    }
   public UserDetails(String upiId,String firstName,String lastName,String dateOfBirth,int age,String accType,String phoneNo,String emailId,String panNumber,String password,double balance){
        this.upiId=upiId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.age=age;
        this.accType=accType;
        this.phoneNo=phoneNo;
        this.emailId=emailId;
        this.panNumber=panNumber;
        this.password=password;
        this.balance=balance;

    }
    public String getFirstName(){
       return firstName;
    }
    public String getDateOfBirth(){
       return dateOfBirth;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return emailId;
    }

    public void setEmail(String email) {
        this.emailId = email;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setPanNumber(String panNumber){
        this.panNumber=panNumber;
    }
    public String getPanNumber(){
        return panNumber;
    }
    public int getAccNo(){
        return accNo;
    }
    public String getAccType(){return accType;}
    public String getUpiId(){return upiId;}
    public String getAccStatus(){return accStatus;}
}
