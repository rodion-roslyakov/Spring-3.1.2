package springBoot.ProjectBoot.dao;



import springBoot.ProjectBoot.model.User;

import java.util.List;

public interface UserDao {

    User show(int id);

    void save(User user);


    List<User> index();


    void delete(int id);

    void update(int id, User user);

}
