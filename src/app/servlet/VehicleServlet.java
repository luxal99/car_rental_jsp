package app.servlet;

import app.dao.CarModelDAO;
import app.dao.VehicleDAO;
import app.entity.CarModel;
import app.entity.Vehicle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicle")
public class VehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);
            CarModel carModel = carModelDAO.findById(Integer.valueOf(req.getParameter("idCarModel")));

            Vehicle vehicle = new Vehicle();
            vehicle.setIdCarModel(carModel);
            vehicle.setPower(Double.valueOf(req.getParameter("vehiclePower")));
            vehicle.setMileage(Integer.valueOf(req.getParameter("vehicleMileage")));
            vehicle.setPricePerDay(Double.valueOf(req.getParameter("vehiclePrice")));
            vehicle.setRegNum(req.getParameter("vehicleReg"));
            vehicle.setImage(req.getParameter("image"));

            VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);

            vehicleDAO.save(vehicle);


            resp.sendRedirect(req.getContextPath() + "/pages/admin.jsp");
        } catch (Exception exception) {
            resp.sendRedirect(req.getContextPath() + "/pages/err.jsp");
        }

    }
}
