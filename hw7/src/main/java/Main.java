import java.io.IOException;

public class Main {



    public static void main(String[] args) throws Exception {

        Singleton myObj = Singleton.getInstance();
        UserInfo user = new UserInfo();
        String age =Integer.toString(user.age);

        myObj.writeToFile(user.name);
        myObj.writeToFile(age);
        myObj.writeToFile(user.address);
        myObj.writeToFile(user.phoneNumber);







    }
}
