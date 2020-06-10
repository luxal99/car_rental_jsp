package app.dao;

import app.entity.Admin;

import java.util.List;

public class AdminDAO extends AbstractDAOImpl<Admin> {
    public AdminDAO(Class<Admin> entityClass) {
        super(entityClass);
    }

    @Override
    public Admin save(Admin entity) {
        return super.save(entity);
    }

    @Override
    public List<Admin> getAll() {
        return super.getAll();
    }

    @Override
    public Admin findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Admin entity) {
        return super.update(entity);
    }
}
