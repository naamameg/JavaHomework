
import java.util.Scanner;

public class UserInfo {
    String name;
    int age;
    String address;
    String phoneNumber;

    public UserInfo(){
        enterInformation();
    }
    protected void enterInformation(){
        Scanner text = new Scanner(System.in);
        System.out.println("enter your name");
        this.name = text.nextLine();
        System.out.println("enter your age");
        this.age = Integer.parseInt(text.nextLine());
        System.out.println("enter your address");
        this.address = text.nextLine();
        System.out.println("enter your phone number");
        this.phoneNumber = text.nextLine();



    }


    }




