package view;
import controler.Validation;

public class HomePage {
public static void main(String[] args){
    start();
 }

    static AdminProcess admin=new AdminProcess();
    static UsersProcess usersProcess=new UsersProcess();
    static public void start(){
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        System.out.println("3.Exit");
        System.out.println("Enter the choice..");
        int choice=Validation.numberValidate(1,3,"Input Mismatch, Re Enter ");
        switch(choice){
            case 1:
                admin.admin();
                start();
                break;
            case 2:
                usersProcess.process();
                start();
                break;
            default:
                break;
        }
    }
}
