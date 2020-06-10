package app.dao;

import app.entity.Role;

import java.util.List;

public class RoleDAO extends AbstractDAOImpl<Role> {
    public RoleDAO(Class<Role> entityClass) {
        super(entityClass);
    }

    @Override
    public Role save(Role entity) {
        return super.save(entity);
    }

    @Override
    public List<Role> getAll() {
        return super.getAll();
    }

    @Override
    public Role findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Role entity) {
        return super.update(entity);
    }
}
