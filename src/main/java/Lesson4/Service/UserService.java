package Lesson4.Service;

import Lesson4.DAO.UserDAO;
import Lesson4.model.User;
import Lesson4.utils.Session;

public class UserService extends UserDAO {

    Session session = new Session();

    public User registerUser(User user){
        return saveUser(user);
    }

    public User login(String userName, String password) throws Exception {
        return session.logIn(userName, password);
    }

    public void logout(){
        session.logOut();
    }
}
