package app.servlet;

import app.dao.ClientDAO;
import app.dao.ReservationDAO;
import app.dao.VehicleDAO;
import app.entity.Client;
import app.entity.Reservation;
import app.entity.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ClientDAO clientDAO = new ClientDAO(Client.class);
        VehicleDAO vehicleDAO = new VehicleDAO(Vehicle.class);
        ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);

        try {
            if (!reservationDAO.checkRentalDate(Integer.valueOf(req.getParameter("idVehicle")), req.getParameter("startDate"))) {
                resp.sendRedirect(req.getContextPath()+"/pages/reservation.jsp");
            } else {
                Reservation reservation = new Reservation();
                reservation.setStartDate(req.getParameter("startDate"));
                reservation.setEndDate(req.getParameter("endDate"));
                reservation.setIdClient(clientDAO.findById(Integer.valueOf(req.getParameter("idClient"))));
                reservation.setIdVehicle(vehicleDAO.findById(Integer.valueOf(req.getParameter("idVehicle"))));
                reservation.setTotal(Double.valueOf(req.getParameter("total")));

                reservationDAO.save(reservation);


                resp.sendRedirect(req.getContextPath() + "/pages/client.jsp");
            }
        } catch (Exception exception) {
            Cookie cookie = new Cookie("fail", "");

            cookie.setPath("/");
            cookie.setMaxAge(20);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");
        }
    }

}

