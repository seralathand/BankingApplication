package controler;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDataProcess {
     DbQuerys dbQuerys=new DbQuerys();
     private static UsersDataProcess usersDataProcess=null;

     public static UsersDataProcess getInstance(){
          if(usersDataProcess ==null)
               usersDataProcess =new UsersDataProcess();
          return usersDataProcess;
     }
     TransactionDetails transactionDetails;
     TransactionControl transactionControl=new TransactionControl();
     public int storeData(UserDetails userDetails){
          int accNo=0;
          int userId=0;
          try{

               PreparedStatement newUser=DbConnection.getConnection().prepareStatement(dbQuerys.getNewUser());
               newUser.setString(1,userDetails.getFirstName()+" "+userDetails.getLastName());
               newUser.setString(2,userDetails.getUpiId());
               newUser.setString(3,userDetails.getPhoneNo());
               newUser.setString(4,userDetails.getPassword());
               newUser.executeUpdate();

               PreparedStatement statement2=DbConnection.getConnection().prepareStatement(dbQuerys.getUserAccountNo());
               statement2.setString(1,userDetails.getPhoneNo());
               ResultSet result=statement2.executeQuery();

               if(result.next())
                    accNo=result.getInt(1);

               PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getNewUserDetails());
               statement.setString(1,userDetails.getFirstName());
               statement.setString(2,userDetails.getLastName());
               statement.setString(3,userDetails.getDateOfBirth());
               statement.setInt(4,userDetails.getAge());
               statement.setString(5,userDetails.getPhoneNo());
               statement.setString(6, userDetails.getEmail());
               statement.setString(7,userDetails.getPanNumber());
               statement.setInt(8,accNo);
               statement.executeUpdate();

               PreparedStatement statement1=DbConnection.getConnection().prepareStatement(dbQuerys.getAddAccDetails());
               statement1.setString(1,userDetails.getFirstName()+" "+userDetails.getLastName());
               statement1.setString(2,userDetails.getAccType());
               statement1.setString(3,"Active");
               statement1.setDouble(4,userDetails.getBalance());
               statement1.setInt(5,accNo);
               statement1.executeUpdate();
               transactionDetails=new TransactionDetails(Validation.dateAndTime(),"Open Amount","",
                       String.valueOf("+"+userDetails.getBalance()),userDetails.getBalance(),accNo);
               transactionControl.transaction(transactionDetails);

               PreparedStatement state=DbConnection.getConnection().prepareStatement(dbQuerys.getUserId());
               state.setString(1,userDetails.getPhoneNo());
               ResultSet resultSet=state.executeQuery();
               if(resultSet.next()){
                    userId=resultSet.getInt(1);
               }
          }
          catch(Exception e){
               System.out.println(e.getMessage());
          }
          return userId;
     }
     public void addressStore(AddressDetails addressDetails){
          try{

               PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getSetAddress());
               statement.setString(1,addressDetails.getDoorNo());
               statement.setString(2,addressDetails.getStreet());
               statement.setString(3,addressDetails.getCity());
               statement.setString(4,addressDetails.getDistrict());
               statement.setString(5,addressDetails.getState());
               statement.setInt(6,addressDetails.getPincode());
               statement.setInt(7,addressDetails.getUserId());
               statement.executeUpdate();
          }
          catch(SQLException e){
               System.out.println(e.getMessage());
          }

     }
}
