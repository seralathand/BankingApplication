package controler;

import model.AddressDetails;
import model.DbConnection;
import model.DbQuerys;
import model.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileControl {
    AddressDetails addressDetails;
    DbQuerys dbQuerys=new DbQuerys();

    public AddressDetails address(int accNo){
        try{
            PreparedStatement statement= DbConnection.getConnection().prepareStatement(dbQuerys.getAddress());
            statement.setInt(1,accNo);
            ResultSet result=statement.executeQuery();
            while(result.next()){
                String door=result.getString("doorNo");
                String street=result.getString("street");
                String city=result.getString("city");
                String district=result.getString("district");
                String state=result.getString ("state");
                int pincode=result.getInt("pincode");
                addressDetails=new AddressDetails(door,street,city,district,state,pincode);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return addressDetails;
    }
    UserDetails userDetails;
    public UserDetails account(int accNo){

        try{
            PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getUserDetails());
            statement.setInt(1,accNo);
            ResultSet result=statement.executeQuery();
            while(result.next()){
                String name=result.getString("name");
                String upiId=result.getString("upiId");
                String phoneNumber=result.getString("phoneNumber");
                userDetails=new UserDetails(name,upiId,phoneNumber);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return userDetails;
    }
}
