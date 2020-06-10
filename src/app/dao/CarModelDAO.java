package app.dao;

import app.entity.CarModel;

import java.util.List;

public class CarModelDAO extends AbstractDAOImpl<CarModel> {
    public CarModelDAO(Class<CarModel> entityClass) {
        super(entityClass);
    }

    @Override
    public CarModel save(CarModel entity) {
        return super.save(entity);
    }

    @Override
    public List<CarModel> getAll() {
        return super.getAll();
    }

    @Override
    public CarModel findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(CarModel entity) {
        return super.update(entity);
    }
}
