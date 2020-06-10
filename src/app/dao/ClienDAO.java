package app.dao;

import app.entity.Client;

import java.util.List;

public class ClienDAO extends AbstractDAOImpl<Client> {

    public ClienDAO(Class<Client> entityClass) {
        super(entityClass);
    }

    @Override
    public Client save(Client entity) {
        return super.save(entity);
    }

    @Override
    public List<Client> getAll() {
        return super.getAll();
    }

    @Override
    public Client findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Client entity) {
        return super.update(entity);
    }
}
