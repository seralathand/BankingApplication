package controler;


import model.DbConnection;
import model.DbQuerys;
import model.UserDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginControl {
     DbQuerys dbQuerys=new DbQuerys();
//     UserDetails userDetails;s

    public boolean loginCheck(int accNo,String password){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getUserLoginCheck());
            statement.setInt(1,accNo);
            ResultSet result=statement.executeQuery();
           while(result.next()){
               if(result.getInt(1)==accNo && result.getString(2).equals(password))
                   return true;
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean loginCheck(String userName,String password){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getAdminLogin());
            ResultSet result=statement.executeQuery();

            while(result.next()){
                return (result.getString("userName").equals(userName))&&(result.getString("password").equals(password));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
