import javax.jws.soap.SOAPBinding;
import java.io.*;

/**
 * Created by Susanna.Aghlamazyan on 9/2/2016.
 */
public class UserRepositoryImpl implements UserRepository {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String USER_FILE_HEADER = "Id,Username,Password";



    // Files Path
    String userFileName = "userList.csv";

    BufferedWriter bw = null;
    BufferedReader br = null;

    public User addUser(User user){

        try{

            br = new BufferedReader(new FileReader(userFileName));
            bw = new BufferedWriter(new FileWriter(userFileName, true));
            if(br.readLine() == null){
                bw.append(USER_FILE_HEADER.toString());
                bw.append(NEW_LINE_SEPARATOR);
                bw.append(String.valueOf(user.getUserId()));
                bw.append(COMMA_DELIMITER);
                bw.append(user.getUserName());
                bw.append(COMMA_DELIMITER);
                bw.append(user.getPassword());
                bw.append(NEW_LINE_SEPARATOR);
            } else{
                bw.append(String.valueOf(user.getUserId()));
                bw.append(COMMA_DELIMITER);
                bw.append(user.getUserName());
                bw.append(COMMA_DELIMITER);
                bw.append(user.getPassword());
                bw.append(NEW_LINE_SEPARATOR);
            }

        } catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                bw.flush();
                bw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return user;
    }
    public User editUser(User user){
        //TODO
        return user;
    }
    public void deleteUser(Integer id){
        //TODO
            }

/*public User getUser(Integer id){
        //TODO
        return user;
    }*/
    public Integer getUser(User user){
        Integer userId = null;
        String line = "";

        try{
            br = new BufferedReader(new FileReader(userFileName));
            br.readLine(); //To skip Header Line in CSV file
            while((line = br.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);

                if(tokens.length > 0){
                    User checkedUser = new User(tokens[1], tokens[2]);
                    if(checkedUser.equals(user)){
                        return Integer.valueOf(tokens[0]);
                    }
                }
            }
        }catch (Exception e){

        } finally {
            try{
                br.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return userId;
    }


}
