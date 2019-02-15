package Lesson4.DAO;

import Lesson4.model.User;

public class UserDAO extends GeneralDAO {

    public UserDAO() {
        setClass(User.class);
    }

    public User saveUser(User user) {
        return (User) save(user);
    }

    public void deleteUser(long id) {
        delete(id);
    }

    public User updateUser(User user) {
        return (User) update(user);
    }

    public User findUserById(long id) throws Exception {
        return (User) findById(id);
    }

    public User findUserByName(String name) throws Exception {
        return (User) findByName(name);
    }

}
