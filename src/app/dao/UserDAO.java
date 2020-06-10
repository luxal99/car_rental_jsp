package app.dao;

import app.entity.User;

import java.util.List;

public class UserDAO extends AbstractDAOImpl<User> {
    public UserDAO(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(User entity) {
        return super.update(entity);
    }
}
