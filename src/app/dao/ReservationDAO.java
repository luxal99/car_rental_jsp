package app.dao;

import app.config.DBConfig;
import app.dto.CountCarModelDTO;
import app.dto.MostReservedVehicleDTO;
import app.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    public List<MostReservedVehicleDTO> countMostReservedVehicles() {
        Session session = DBConfig.getSessionFactory().openSession();
        Query query = session.createSQLQuery("select cm.id,cb.title as 'brand', cm.title as 'model', count(reservation.id), v.image\n" +
                "from reservation\n" +
                "         join vehicle v on reservation.id_vehicle = v.id\n" +
                "         join car_model cm on v.id_car_model = cm.id\n" +
                "         join car_brand cb on cm.id_car_brand = cb.id\n" +
                "group by id_vehicle order by count(reservation.id) desc ;");

        List<Object[]> objects = query.list();
        List<MostReservedVehicleDTO> mostReservedVehicleDTOList = new ArrayList<>();

        for (Object[] row :
                objects) {
            MostReservedVehicleDTO countCarModelDTO = new MostReservedVehicleDTO();
            countCarModelDTO.setId(Integer.valueOf(row[0].toString()));
            countCarModelDTO.setCarBrandTitle(row[1].toString());
            countCarModelDTO.setCarModelTitle(row[2].toString());
            countCarModelDTO.setAmount(Integer.valueOf(row[3].toString()));
            countCarModelDTO.setImage(row[4].toString());

            mostReservedVehicleDTOList.add(countCarModelDTO);
        }
        return mostReservedVehicleDTOList;
    }
}
