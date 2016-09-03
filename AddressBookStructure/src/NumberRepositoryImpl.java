import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Susanna.Aghlamazyan on 9/3/2016.
 */
public class NumberRepositoryImpl implements NumberRepository {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String POHNE_FILE_HEADER = "PhoneId, UserId, Number";

    String numberFileName = "numberList.csv";

    BufferedWriter bw = null;
    BufferedReader br = null;


    public Number addNumber(Number num, Integer userId){
        try{
            bw = new BufferedWriter(new FileWriter(numberFileName, true));
            br = new BufferedReader(new FileReader(numberFileName));

            if(br.readLine() == null){
                bw.append(POHNE_FILE_HEADER);
                bw.append(NEW_LINE_SEPARATOR);
                bw.append(String.valueOf(num.getPhoneNumberId()));
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(userId));
                bw.append(COMMA_DELIMITER);
                bw.append(num.getPhoneNumber());
                bw.append(NEW_LINE_SEPARATOR);
            } else{
                bw.append(String.valueOf(num.getPhoneNumberId()));
                bw.append(COMMA_DELIMITER);
                bw.append(String.valueOf(userId));
                bw.append(COMMA_DELIMITER);
                bw.append(num.getPhoneNumber());
                bw.append(NEW_LINE_SEPARATOR);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                bw.flush();
                bw.close();

            }catch (IOException e){
                e.printStackTrace();
            }

        }

        return num;
    }

    public List<String> getNumbersList(Integer userId){
        String line = "";
        List<String> phoneNumbersList = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(numberFileName));
            br.readLine();// To skip HEADER line
            while((line = br.readLine()) != null){
                String[] tokens = line.split(COMMA_DELIMITER);
                if(tokens.length > 0 && Integer.valueOf(tokens[1]).equals(userId)){
                    phoneNumbersList.add(String.valueOf(tokens[2]));
                }

            }
            return phoneNumbersList;

        } catch(Exception e){
            e.printStackTrace();

        } finally {
            try{
                br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return phoneNumbersList;
    }




}
