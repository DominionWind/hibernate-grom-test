package Lesson4.utils;

import Lesson4.dao.UserDAO;
import Lesson4.model.User;

public class Session {

    UserDAO userDAO = new UserDAO();

    private static User loginUser;

    public static User getLoginUser() {
        return loginUser;
    }

    public void logOut() {
        loginUser = null;
    }

    public User logIn(String username, String password) throws Exception {

        validateUserNameAndPassword(username, password);
        return loginUser = userDAO.findUserByName(username);
    }

    private void validateUserNameAndPassword(String username, String password) throws Exception {
        if (userDAO.findUserByName(username).getPassword().equals(password)) {
            throw new Exception("Login failed. Access denied");
        } else {
            return;
        }
    }
}


