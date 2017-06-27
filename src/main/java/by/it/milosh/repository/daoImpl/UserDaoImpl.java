package by.it.milosh.repository.daoImpl;

import by.it.milosh.entity.single.User;
import by.it.milosh.repository.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    @Override
    public User getUser(Long user_id) {
        return (User) getSession().get(User.class, user_id);
    }

    @Override
    public void deleteUser(User user) {
        getSession().delete(user);
    }


    @Override
    public void deleteUserById(Long user_id) {
        User user = getSession().get(User.class, 1L);
        getSession().delete(user);
    }
}
