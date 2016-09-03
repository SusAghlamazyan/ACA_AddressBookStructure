import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Susanna.Aghlamazyan on 9/2/2016.
 */

public class Controller {

    String FILE_DIR = System.getProperty("user.dir") + "\\AddressBookStructure\\resources\\config.properties";
    Scanner sc = new Scanner(System.in);
    String insertedValue;

    Properties property = new Properties();
    InputStream input = null;

    ControllerLogin cLogin = new ControllerLogin();
    ControllerNumber cNumber = new ControllerNumber();
    ControllerFriend cFriend = new ControllerFriend();

    UserRepositoryImpl user = new UserRepositoryImpl();
    NumberRepositoryImpl number = new NumberRepositoryImpl();

    static User currentUser;
    static Integer currentUserId;


    String tempUserName;
    String tempPassword;


    public void execute() {
        try {
            input = new FileInputStream(FILE_DIR);
            property.load(input);
            System.out.print(property.getProperty("write.signIn.signUp"));
            insertedValue = sc.nextLine();
            while (1 == 1) {

                switch (insertedValue) {
                    case ("SignUp"):
                        signUp();
                        break;
                    case ("SignIn"):
                        signIn();
                        break;
                    case ("SignOut"):
                        signOut();
                        break;
                    case ("AddNumber"):
                        addNumber();
                        break;
                    case ("ShowNumber"):
                        showNumbers(currentUserId);
                        break;
                    case ("AddFriend"):
                        addFriend();
                        break;
                    case ("DeleteFriend"):
                        deleteFriend();
                        break;
                    default:
                        System.out.println(property.getProperty("wrong.command"));
                        System.out.print(property.getProperty("write.signIn.signUp"));
                        break;
                }
                insertedValue = sc.nextLine();
            }

        } catch (Exception e) {
        }


    }


    public void signUp() {
        System.out.print(property.getProperty("provide.userName"));
        tempUserName = sc.nextLine();
        System.out.print(property.getProperty("provide.password"));
        tempPassword = sc.nextLine();
        User newUser = new User(tempUserName, tempPassword);
        user.addUser(newUser);
        System.out.print(property.getProperty("user.created.successfully"));
    }

    public void signIn() {
        int loginCount = 0;
        while (loginCount < 3) {
            System.out.print(property.getProperty("provide.userName"));
            tempUserName = sc.nextLine();
            System.out.print(property.getProperty("provide.password"));
            tempPassword = sc.nextLine();

            User userSignIn = new User(tempUserName, tempPassword);

            if ((user.getUser(userSignIn)) != null) {
                System.out.print(property.getProperty("user.logged.successfully"));
                currentUser = userSignIn;
                currentUserId = currentUser.getUserId();
                System.out.print(property.getProperty("command.addNumber.showNumber"));
                break;


            } else {
                System.out.println(property.getProperty("wrong.user.password"));
                loginCount ++;
                System.out.print(property.getProperty("write.signIn.signUp"));
                insertedValue = sc.nextLine();
            }
            if(loginCount == 3){
                System.out.print(property.getProperty("lock.account"));
            }

            insertedValue = sc.nextLine();

        }
    }

    public void signOut() {
        System.exit(0);
    }

    public void addNumber(){
        String telephoneNumber = "374";
        System.out.print(property.getProperty("enter.phoneNumber"));
        telephoneNumber += sc.nextLine();

        Number newNumber = new Number(telephoneNumber);
        number.addNumber(newNumber, currentUserId);
        System.out.print(property.getProperty("command.afterInput.show.add"));
        //insertedValue = sc.nextLine();
    }

    public void showNumbers(Integer currentUserId){
        List<String> numbersList = null;
        System.out.println(property.getProperty("telNumbers.list"));
        numbersList = number.getNumbersList(currentUserId);

        if(numbersList != null){
            for(String num: numbersList){
                System.out.println(num);
            }
            System.out.print(property.getProperty("command.addNumber.showNumber"));
            insertedValue = sc.nextLine();
        } else{
            System.out.println(property.getProperty("telNumber.is.empty"));
            System.out.print(property.getProperty("command.addNumber.showNumber"));
            insertedValue = sc.nextLine();
        }
    }
    public void addFriend(){

    }

    public void deleteFriend(){

    }


}
