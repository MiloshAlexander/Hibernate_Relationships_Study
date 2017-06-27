package by.it.milosh.service.serviceImpl;

import by.it.milosh.entity.single.User;
import by.it.milosh.repository.dao.UserDao;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUser(Long user_id) {
        return userDao.getUser(user_id);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void deleteUserById(Long user_id) {
        userDao.deleteUserById(user_id);
    }
}
