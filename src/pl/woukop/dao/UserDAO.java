package pl.woukop.dao;

import java.util.List;
import pl.woukop.model.User;
 
public interface UserDAO extends GenericDAO<User, Long> {
 
    List<User> getAll();
    User getUserByUsername(String username);
     
}