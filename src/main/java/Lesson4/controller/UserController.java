package Lesson4.controller;

import Lesson4.service.UserService;
import Lesson4.model.User;

public class UserController extends UserService {

    public User regUser(User user) {
        return registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        login(userName, password);
    }

    public void logOut(){
        logout();
    }
}
