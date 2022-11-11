package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection=null;

    public static Connection getConnection(){
        try {
            if(connection==null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","dhanush");
            else
                return connection;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
