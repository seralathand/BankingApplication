package view;

public interface Money {
     void checkBalance();
     void depositMoney(int accNo);
     void withdrawMoney(int accNo);
     void accountTransfer(int accNo);
     void upiTransfer(int accNo);
     void mobileNumberTransfer(int accNo);
}
