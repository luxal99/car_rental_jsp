package app.dao;

import app.config.DBConfig;
import app.dto.CountCarModelDTO;
import app.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleDAO extends AbstractDAOImpl<Vehicle> {

    public VehicleDAO(Class<Vehicle> entityClass) {
        super(entityClass);
    }

    @Override
    public Vehicle save(Vehicle entity) {
        return super.save(entity);
    }

    @Override
    public List<Vehicle> getAll() {
        return super.getAll();
    }

    @Override
    public Vehicle findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public String update(Vehicle entity) {
        return super.update(entity);
    }

    public List<CountCarModelDTO> countVehicleByCarModel() {

        Session session = DBConfig.getSessionFactory().openSession();
        String sql = "select count(cm.id), cm.title\n" +
                "from vehicle\n" +
                "         join car_model cm on vehicle.id_car_model = cm.id\n" +
                "group by cm.title";

        Query query = session.createSQLQuery(sql);

        List<Object[]> objects = query.list();

        List<CountCarModelDTO> countCarModelDTOList = new ArrayList<>();
        for (Object[] row :
                objects) {
            CountCarModelDTO countCarModelDTO = new CountCarModelDTO();
            countCarModelDTO.setValue(Integer.valueOf(row[0].toString()));
            countCarModelDTO.setCarModelTitle(row[1].toString());

            countCarModelDTOList.add(countCarModelDTO);
        }
        return countCarModelDTOList;
    }

    public List<Vehicle> findAllVehicleByCarModel(Integer idCarModel) {

        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle vehicle
                : getAll()
        ) {
            if (vehicle.getIdCarModel().getId() == idCarModel) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

    public List<CountCarModelDTO> countAllVehicleByCarBrand() {

        Session session = DBConfig.getSessionFactory().openSession();
        String sql = "select count(cb.id),cb.title\n" +
                "from vehicle\n" +
                "         join car_model cm on vehicle.id_car_model = cm.id\n" +
                "         join car_brand cb on cm.id_car_brand = cb.id\n" +
                "group by cb.title;";

        Query query = session.createSQLQuery(sql);

        List<Object[]> objects = query.list();

        List<CountCarModelDTO> countCarModelDTOList = new ArrayList<>();
        for (Object[] row :
                objects) {
            CountCarModelDTO countCarModelDTO = new CountCarModelDTO();
            countCarModelDTO.setValue(Integer.valueOf(row[0].toString()));
            countCarModelDTO.setCarModelTitle(row[1].toString());

            countCarModelDTOList.add(countCarModelDTO);
        }
        return countCarModelDTOList;
    }

    public List<Vehicle> findByCarBrand(Integer id) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle vehicle :
                getAll()) {
            if (vehicle.getIdCarModel().getIdCarBrand().getId() == id) {
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }

}
