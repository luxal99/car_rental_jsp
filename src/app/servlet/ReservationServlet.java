package app.servlet;

import app.dao.ClienDAO;
import app.dao.ReservationDAO;
import app.dao.VehicleDAO;
import app.entity.Client;
import app.entity.Reservation;
import app.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ClienDAO clienDAO = new ClienDAO(Client.class);
            VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);
            ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);

            Reservation reservation = new Reservation();
            reservation.setStartDate(req.getParameter("startDate"));
            reservation.setEndDate(req.getParameter("endDate"));
            reservation.setIdClient(clienDAO.findById(Integer.valueOf(req.getParameter("idClient"))));
            reservation.setIdVehicle(vehicleDAO.findById(Integer.valueOf("idVehicle")));

            reservationDAO.save(reservation);
            resp.sendRedirect(req.getContextPath() + "/pages/clients.jsp");
        } catch (Exception exception) {
            resp.sendRedirect(req.getContextPath()+"/pages/err.jsp");
        }
    }
}
