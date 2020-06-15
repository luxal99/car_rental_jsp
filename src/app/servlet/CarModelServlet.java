package app.servlet;

import app.dao.CarBrandDAO;
import app.dao.CarModelDAO;
import app.entity.CarBrand;
import app.entity.CarModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model")
public class CarModelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CarBrandDAO carBrandDAO = new CarBrandDAO(CarBrand.class);
            CarModelDAO carModelDAO = new CarModelDAO(CarModel.class);

            CarBrand carBrand = carBrandDAO.findById(Integer.valueOf(req.getParameter("carBrand")));
            CarModel carModel = new CarModel(req.getParameter("title"), carBrand);

            carModelDAO.save(carModel);


            resp.sendRedirect(req.getContextPath() + "/pages/admin.jsp");
        } catch (Exception exception) {
            System.out.println("Failed");
        }
    }
}
