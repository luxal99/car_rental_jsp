package app.dao;

import app.entity.CarBrand;

import java.util.List;

public class CarBrandDAO extends AbstractDAOImpl<CarBrand> {
    public CarBrandDAO(Class<CarBrand> entityClass) {
        super(entityClass);
    }

    @Override
    public CarBrand save(CarBrand entity) {
        return super.save(entity);
    }

    @Override
    public List<CarBrand> getAll() {
        return super.getAll();
    }

    @Override
    public CarBrand findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(CarBrand entity) {
        return super.update(entity);
    }
}
