package controler;

import model.DbConnection;
import model.DbQuerys;
import model.TransactionDetails;
import model.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminControl {
    DbQuerys dbQuerys=new DbQuerys();

    public List<UserDetails> showCustomers(){
        List<UserDetails> allCustomers=new ArrayList<>();

        try{
            PreparedStatement statement= DbConnection.getConnection().prepareStatement(dbQuerys.getAllCustomer());
            ResultSet result= statement.executeQuery();

            while (result.next()){
                int accNo=result.getInt("accNo");
                String name=result.getString("name");
                String upiId=result.getString("upiId");
                String phoneNumber=result.getString("phoneNumber");
                String accType=result.getString("accType");
                String accStatus=result.getString("accStatus");
                allCustomers.add(new UserDetails(accNo,name,phoneNumber,upiId,accType,accStatus));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return allCustomers;
    }
public List<TransactionDetails> transactions(){
        List<TransactionDetails> allTransactions=new ArrayList<>();
        try{
            PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getAllTransactions());
            ResultSet result=statement.executeQuery();

            while(result.next()){
                String date=result.getString("Date");
                String particulars=result.getString("particulars");
                String depicted=result.getString("Depicted");
                String credited=result.getString("Credited");
                double closingAmount=result.getDouble("closingBalance");
                allTransactions.add(new TransactionDetails(date,particulars,depicted,credited,closingAmount));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return allTransactions;
 }
}
