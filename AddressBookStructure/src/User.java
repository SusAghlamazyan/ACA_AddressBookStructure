import sun.font.LayoutPathImpl;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by Susanna.Aghlamazyan on 9/2/2016.
 */
public class User {
    private String userName;
    private String password;
    private int userId;
    List<Number> phoneNumber = new ArrayList<Number>();

    public void setUserName(String userName) throws InvalidInputException{
        if(userName != null && !userName.isEmpty()){
            this.userName = userName;
        } else {
            throw new InvalidInputException();
        }
    }

    public void setPassword(String password) throws InvalidInputException{
        if(password != null && !password.isEmpty()){
            this.password = password;
        } else {
            throw  new InvalidInputException();

        }
    }


    public Integer getUserId(){
        return this.userId = getUserName().length() + getPassword().length();
    }



    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }



    public User(String userName, String password ){
        this.setUserName(userName);
        this.setPassword(password);
    }

    public boolean equals(User user){
        boolean result = false;
        if(user != null && user instanceof User
                && user.getUserName() != null && user.getUserName() != null
                && getUserName() != null && getPassword() != null){
            if(getUserName().equals(user.getUserName()) && getPassword().equals(user.getPassword())){
                result = true;
            } else{
                result = false;
            }

        } else {
            result = false;
        }

        return result;

    }

    public boolean equals(Integer userId){
        boolean result = false;
        if(userId != null && getUserId() == userId){
            result = true;
        }
        return result;
    }

    public int hashCode(){
        int hashCode = 20;
        hashCode = hashCode*3 + getUserName().hashCode() + getPassword().hashCode();
        return hashCode;
    }

    public String toSring(){
        return "User [id=" + userId + ", Username=" + userName + ", password=" + password + "]";

    }




}
