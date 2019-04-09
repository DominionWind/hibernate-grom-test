package Lesson4.service;

import Lesson4.dao.UserDAO;
import Lesson4.model.User;
import Lesson4.utils.Session;

public class UserService{

    UserDAO userDAO = new UserDAO();
    Session session = new Session();

    public User registerUser(User user){
        return userDAO.saveUser(user);
    }

    public User login(String userName, String password) throws Exception {
        return session.logIn(userName, password);
    }

    public void logout(){
        session.logOut();
    }
}
