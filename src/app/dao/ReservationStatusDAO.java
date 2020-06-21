package app.dao;

import app.entity.ReservationStatus;

import java.util.List;

public class ReservationStatusDAO extends AbstractDAOImpl<ReservationStatus> {
    public ReservationStatusDAO(Class<ReservationStatus> entityClass) {
        super(entityClass);
    }

    @Override
    public List<ReservationStatus> getAll() {
        return super.getAll();
    }

    @Override
    public ReservationStatus findById(Integer id) {
        return super.findById(id);
    }
}
