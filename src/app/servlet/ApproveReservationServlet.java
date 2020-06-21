package app.servlet;

import app.dao.ReservationDAO;
import app.entity.Reservation;
import app.entity.ReservationStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/approve")
public class ApproveReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationDAO reservationDAO = new ReservationDAO(Reservation.class);
        Reservation reservation = reservationDAO.findById(Integer.valueOf(req.getParameter("idReservation")));
        reservation.setStatus(new ReservationStatus(3));

        reservationDAO.update(reservation);
    }
}
