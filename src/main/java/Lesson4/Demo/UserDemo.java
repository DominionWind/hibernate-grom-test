package Lesson4.Demo;

import Lesson4.Controller.UserController;
import Lesson4.model.User;
import Lesson4.utils.UserType;

public class UserDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();

        User user = new User();
        user.setCountry("TestTest");
        user.setPassword("Test");
        user.setType(UserType.USER);
        user.setUserName("TestTestTest");

        userController.registerUser(user);
    }
}
