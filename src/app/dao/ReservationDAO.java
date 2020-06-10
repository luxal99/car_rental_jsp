package app.dao;

import app.entity.Reservation;

import java.util.List;

public class ReservationDAO extends AbstractDAOImpl<Reservation> {
    public ReservationDAO(Class<Reservation> entityClass) {
        super(entityClass);
    }

    @Override
    public Reservation save(Reservation entity) {
        return super.save(entity);
    }

    @Override
    public List<Reservation> getAll() {
        return super.getAll();
    }

    @Override
    public Reservation findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Reservation entity) {
        return super.update(entity);
    }
}
