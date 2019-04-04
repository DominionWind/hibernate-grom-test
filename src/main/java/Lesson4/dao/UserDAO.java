package Lesson4.dao;

import Lesson4.model.User;

public class UserDAO extends GeneralDAO<User> {

    public UserDAO() {
        setClass(User.class);
    }

    public User saveUser(User user) {
        return save(user);
    }

    public void deleteUser(long id) {
        delete(id);
    }

    public User updateUser(User user) {
        return update(user);
    }

    public User findUserById(long id) throws Exception {
        return findById(id);
    }

    public User findUserByName(String name) throws Exception {
        return findByName(name);
    }

}
