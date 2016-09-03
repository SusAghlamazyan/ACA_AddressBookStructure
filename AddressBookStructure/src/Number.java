import java.util.Random;

/**
 * Created by Susanna.Aghlamazyan on 9/3/2016.
 */
public class Number {
    private String phoneNumber;
    private PhoneType number;
    private Integer phoneNumberId;

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber != null && !phoneNumber.isEmpty()){
            this.phoneNumber = phoneNumber;
        } else{
            throw  new InvalidInputException();
        }
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public Integer getPhoneNumberId(){
        Random random = new Random();
        return this.phoneNumberId = random.nextInt(9999);
    }

    public Number(String phoneNumber){
        this.setPhoneNumber(phoneNumber);

    }

}
