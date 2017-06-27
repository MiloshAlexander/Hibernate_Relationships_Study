package by.it.milosh.repository.dao;

import by.it.milosh.entity.single.User;

public interface UserDao {

    void addUser(User user);

    User getUser(Long user_id);

    void deleteUser(User user);

    void deleteUserById(Long user_id);

}
