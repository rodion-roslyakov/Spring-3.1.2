package springBoot.ProjectBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springBoot.ProjectBoot.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("DELETE FROM User WHERE id=?1").setParameter(1, id).executeUpdate();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User user) {
        User updateUser = show(id);
        entityManager.merge(updateUser).setFirstName(user.getFirstName());
        entityManager.merge(updateUser).setSecondName(user.getSecondName());
        entityManager.merge(updateUser).setAge(user.getAge());
    }
}
