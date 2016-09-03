import java.util.List;

/**
 * Created by Susanna.Aghlamazyan on 9/3/2016.
 */
public interface NumberRepository {
    public Number addNumber(Number num, Integer userId);
    public List<String> getNumbersList(Integer userId);

}
