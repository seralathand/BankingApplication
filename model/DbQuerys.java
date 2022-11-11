package model;

public class DbQuerys {
    private String userDetails="select * from bank where accNo=?;";
    private String newUserDetails ="insert into userDetails(firstName,lastName,dateOfBirth,age,phoneNumber,emailId,panNumber,accNo) values(?,?,?,?,?,?,?,?)";
    private String userAccountNo="select accNo from bank where phoneNumber=?";
    private String addAccDetails="insert into accDetails(accHolderName,accType,accStatus,balance,accNo) values(?,?,?,?,?)";
    private String userLoginCheck="select accNo,password from bank where accNo=?";
    private String getBalance ="select * from accDetails a join bank b on a.accNo=b.accNo where a.accNo=?";
    private String updateMoney="update accDetails set balance=? where accNo=?";
    private String isAccountNumber="select accNo,name from bank;";
    private String isUpiId ="select upiId,name from bank ;";
    private String phoneNumber="select phoneNumber,name from bank";
    private String getAccNo="select accNo from bank where upiId=?";
    private String transaction="insert into transactionDetails(Date,particulars,Depicted,Credited,closingBalance,accNo) value(?,?,?,?,?,?);";
    private String transactionDetails="select * from transactionDetails t join bank b on t.accNo=b.accNo where t.accNo=?";
    private String setAddress="insert into useraddress(doorNo,street,city,district,state,pincode,userId) values(?,?,?,?,?,?,?)";
    private String address="select * from useraddress  where userId=(select userId from userDetails where accNo=?);";
    private String newUser="insert into bank(name,upiId,phoneNumber,password) values(?,?,?,?);";
    private String userId="select userId from userDetails where phoneNumber=?";
    private String accNoUsingPhoneNo="select accNo from bank where phoneNumber=?";

    private String adminLogin="select * from admin;";
    private String allCustomer="select b.accNo,b.name,b.upiId,b.phoneNumber,a.accType,a.accStatus from bank b join accDetails a on" +
            " b.accNo=a.accNo";
    private String allTransactions="select t.Date,t.particulars,t.Depicted,t.Credited,t.closingBalance from" +
            " transactionDetails t join bank b on t.accNo=b.accNo;";

    public String getUserDetails(){
        return  userDetails;
    }
    public String getNewUserDetails(){
        return newUserDetails;
    }
    public String getUserAccountNo(){return userAccountNo;}
    public String getAddAccDetails(){return addAccDetails;}
    public String getUserLoginCheck(){return userLoginCheck;}
    public String getGetBalance(){return getBalance;}
    public String getUpdateMoney(){return updateMoney;}
    public String getIsAccountNumber(){return isAccountNumber;}
    public String getIsUpiId(){return isUpiId;}
    public String getGetAccNo(){return getAccNo;}
    public String getTransaction(){return transaction;}
    public String getTransactionDetails(){return transactionDetails;}
    public String getSetAddress(){return setAddress;}
    public String getAddress(){return address;}
    public String getNewUser(){return newUser;}
    public String getUserId(){return userId;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getAccNoUsingPhoneNo(){return accNoUsingPhoneNo;}

    public String getAdminLogin(){return adminLogin;}
    public String getAllCustomer(){return allCustomer;}
    public String getAllTransactions(){return allTransactions;}
}
