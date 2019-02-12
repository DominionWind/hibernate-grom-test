package Lesson4.DAO;


import Lesson4.model.User;

public class UserDAO extends GeneralDAO {

    private void registerUser(User user){
        save(user);
    }

}
