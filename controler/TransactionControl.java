package controler;
import com.sun.security.jgss.GSSUtil;
import model.DbConnection;
import model.DbQuerys;
import model.TransactionDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

public class TransactionControl {

        DbQuerys dbQuerys=new DbQuerys();

    public void transaction(TransactionDetails transactionDetails){
        try {
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(dbQuerys.getTransaction());
            statement.setString(1,Validation.dateAndTime());
            statement.setString(2,transactionDetails.getParticulars());
            statement.setString(3,transactionDetails.getDepicted());
            statement.setString(4,transactionDetails.getCredited());
            statement.setDouble(5,transactionDetails.getClosingBalance());
            statement.setInt(6, transactionDetails.getAccNo());
            statement.executeUpdate();

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("transaction.............Details");
        }
    }

    public Stack<TransactionDetails> transactionDetails(int accNo){
        Stack<TransactionDetails> transactionList=new Stack<>();
        try{
            PreparedStatement statement=DbConnection.getConnection().prepareStatement(dbQuerys.getTransactionDetails());
            statement.setInt(1,accNo);
            ResultSet result=statement.executeQuery();
            while(result.next()){
                String date=result.getString("Date");
                String particulars=result.getString("particulars");
                String depicted=result.getString("Depicted");
                String credited=result.getString("Credited");
                double closingAmount=result.getDouble("closingBalance");
                transactionList.add(new TransactionDetails(date,particulars,depicted,credited,closingAmount));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return transactionList;
    }
}
