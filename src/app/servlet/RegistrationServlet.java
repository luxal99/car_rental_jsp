package app.servlet;

import app.dao.ClientDAO;
import app.dao.RoleDAO;
import app.dao.UserDAO;
import app.entity.Client;
import app.entity.Role;
import app.entity.User;
import app.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("fullname"));
        Client client = new Client();
        client.setFullName(req.getParameter("fullname"));
        client.setEmail(req.getParameter("email"));


        ClientDAO clientService = new ClientDAO(Client.class);
        Client savedClient = clientService.save(client);

        RoleDAO userTypeService = new RoleDAO(Role.class);
        Role userType = userTypeService.findById(1);

        User user = new User();
        user.setUsername(req.getParameter("username"));

        String hashedPassword = HashPassword.encrypt(req.getParameter("password"));

        user.setPassword(hashedPassword);
        user.setRole(userType);
        user.setIdClient(savedClient);

        UserDAO userService = new UserDAO(User.class);
        userService.save(user);


        resp.sendRedirect(req.getContextPath() + "/pages/login.jsp");

    }
}
