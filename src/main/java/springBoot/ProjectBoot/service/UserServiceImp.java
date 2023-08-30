package springBoot.ProjectBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot.ProjectBoot.dao.UserDao;
import springBoot.ProjectBoot.model.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> index() {
        return userDao.index();
    }


    public User show(int id) {
        return userDao.show(id);
    }

    @Transactional
    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
}