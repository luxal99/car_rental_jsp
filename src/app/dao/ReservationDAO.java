package app.dao;

import app.config.DBConfig;
import app.dto.MostReservedVehicleDTO;
import app.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
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
        session.close();
        return mostReservedVehicleDTOList;
    }

    public List<Reservation> findAllReservationByClientId(Integer integer) {

        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : getAll()) {
            if (reservation.getIdClient().getId() == integer) {
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    public Double countTotalSpentByUser(Integer id) {
        Double total = 0.0;
        for (Reservation reservation : getAll()) {
            if (reservation.getIdClient().getId() == id) {
                total += reservation.getTotal();
            }
        }
        return total;
    }

    public List<Reservation> getAllReservationByVehicleId(Integer id) {
        List<Reservation> reservationList = new ArrayList<>();

        for (Reservation reservation : getAll()) {
            if (reservation.getIdVehicle().getId() == id) {
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }

    public Boolean checkRentalDate(Integer idVehicle, String date) {

        Long duration = null;
        boolean isValid = true;
        for (Reservation reservation : getAllReservationByVehicleId(idVehicle)) {
            try {
                duration = ChronoUnit.DAYS.between(new SimpleDateFormat("yyyy-mm-dd").parse(date).toInstant(), new SimpleDateFormat("yyyy-mm-dd").parse(reservation.getEndDate()).toInstant());
                if (duration >= 0)
                    isValid = false;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return isValid;
    }

    public void closeExpiredReservation() {
        Long duration = null;
        for (Reservation reservation : getAll()) {
            try {
                duration = ChronoUnit.DAYS.between(new SimpleDateFormat("yyyy-mm-dd").parse(LocalDate.now().toString()).toInstant(), new SimpleDateFormat("yyyy-mm-dd").parse(reservation.getEndDate()).toInstant());
                if (duration == 0) {
                    reservation.getStatus().setId(2);
                    update(reservation);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
