package model;

public class TransactionDetails {
    private String date;
    private String particulars;
    private String depicted;
    private String credited;
    private double closingBalance;
    private int accNo;

    public TransactionDetails(){}
    public TransactionDetails(String date,String particulars,String depicted,String credited,double closingBalance){
        this.date=date;
        this.particulars=particulars;
        this.depicted=depicted;
        this.credited=credited;
        this.closingBalance=closingBalance;

    }
    public TransactionDetails(String date,String particulars,String depicted,String credited,double closingBalance,int accNo){
        this.date=date;
        this.particulars=particulars;
        this.depicted=depicted;
        this.credited=credited;
        this.closingBalance=closingBalance;
        this.accNo=accNo;
    }

    public String getDate() {
        return date;
    }

    public String getParticulars() {
        return particulars;
    }

    public String getDepicted() {
        return depicted;
    }

    public String getCredited() {
        return credited;
    }

    public double getClosingBalance() {
        return closingBalance;
    }

    public int getAccNo() {
        return accNo;
    }
}
