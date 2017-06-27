package by.it.milosh.service.service;

import by.it.milosh.entity.single.User;

public interface UserService {

    void addUser(User user);

    User getUser(Long user_id);

    void deleteUser(User user);

    void deleteUserById(Long user_id);

}
