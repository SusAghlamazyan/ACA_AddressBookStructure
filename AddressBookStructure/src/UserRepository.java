/**
 * Created by Susanna.Aghlamazyan on 9/2/2016.
 */
public interface UserRepository {

    public User addUser(User user);
    public User editUser(User user);
    public void deleteUser(Integer id);
    //public User getUser(Integer id);
    public Integer getUser(User user);


}
