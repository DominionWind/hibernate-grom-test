package Lesson4.controller;

import Lesson4.service.UserService;
import Lesson4.model.User;

public class UserController{

    UserService userService = new UserService();

    public User regUser(User user) {
        return userService.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logOut(){
        userService.logout();
    }
}
