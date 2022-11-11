package controler;

import model.DbConnection;
import model.DbQuerys;
import model.TransactionDetails;
import model.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class UsersMoneyControl {
    DbQuerys dbQuerys=new DbQuerys();
    UserDetails userDetails = new UserDetails();
    TransactionControl transactionControl=new TransactionControl();
    TransactionDetails transactionDetails;

    public UserDetails userBalance(int accNo){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getGetBalance());
            statement.setInt(1,accNo);
           ResultSet result= statement.executeQuery();
           while(result.next()){
               userDetails.setBalance(result.getDouble("balance"));
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return userDetails;
    }
    public int updateMoney(int accNo, double amount){
        int result=0;
        try{
            PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getUpdateMoney());
            statement.setDouble(1,amount);
            statement.setInt(2,accNo);
            result=statement.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("update money adskfjh");
        }
        return result;
    }

    public String isAccount(int accountNumber){
        try {
            Statement statement=DbConnection.getConnection().createStatement();
            ResultSet result=statement.executeQuery(dbQuerys.getIsAccountNumber());
            while(result.next()){
                if(accountNumber==result.getInt("accNo"))
                    return result.getString("name");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "false";
    }
    public String isMobileNumber(String mobileNumber){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getPhoneNumber());
            ResultSet result=statement.executeQuery();

            while(result.next()){
                if(result.getString("phoneNumber").equals(mobileNumber))
                    return result.getString("name");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "false";
    }

    public String isUpiId(String upiId){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getIsUpiId());
            ResultSet result=statement.executeQuery();

            while(result.next()){
                if(result.getString("upiId").equals(upiId))
                    return result.getString("name");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "false";
    }
    public void upiIdTransfer(String upiId,double amount){
        int accountNumber=0;
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getGetAccNo());
            statement.setString(1, "" + upiId);
            ResultSet result = statement.executeQuery();

            if (result.next())
                accountNumber = result.getInt("accNo");
            upiMoneyOrmobileNoUpdate(accountNumber,amount);
        }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
    }
    public void mobileTransfer(String phoneNumber,double amount) {
        int accountNumber=0;
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getAccNoUsingPhoneNo());
            statement.setString(1,phoneNumber);
            ResultSet result=statement.executeQuery();

            if(result.next())
                accountNumber=result.getInt("accNo");
            upiMoneyOrmobileNoUpdate(accountNumber,amount);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
    }
    }

    public void upiMoneyOrmobileNoUpdate(int accountNumber, double amount){

           double updatedAmount= userBalance(accountNumber).getBalance()+amount;
            updateMoney(accountNumber,updatedAmount);
            //updating transaction Details
            transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Credited","",
                    String.valueOf("+"+amount),updatedAmount,accountNumber);
           transactionControl.transaction(transactionDetails);
        }

}
