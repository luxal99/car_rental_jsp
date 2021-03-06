package app.servlet;

import app.dao.UserDAO;
import app.entity.User;
import app.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDAO userService = new UserDAO(User.class);
            User user = userService.findByUsername(req.getParameter("username"));
            String password = HashPassword.decrypt(user.getPassword());
            assert password != null;
            if (user.getIdAdmin() != null && password.equals(req.getParameter("password"))) {

                Cookie cookie = new Cookie("idAdmin", HashPassword.encrypt(String.valueOf(user.getIdAdmin().getId())));
                cookie.setPath(req.getContextPath() + "/pages/admin.jsp");
                resp.addCookie(cookie);
                resp.sendRedirect(req.getContextPath() + "/pages/admin.jsp");

            } else if (user.getIdClient() != null && password.equals(req.getParameter("password"))) {

                Cookie cookie = new Cookie("client", HashPassword.encrypt(String.valueOf(user.getIdClient().getId())));
                cookie.setPath("/");
                resp.addCookie(cookie);

                Cookie[] cookies = req.getCookies();

                boolean hasError = false;

                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("fail")) {
                        hasError = true;
                    }
                }

                if (hasError) resp.sendRedirect(req.getContextPath() + "/pages/reservation.jsp");
                else resp.sendRedirect(req.getContextPath() + "/pages/client.jsp");


            } else {
                resp.sendRedirect(req.getContextPath());
            }

        } catch (Exception exception) {
            resp.sendRedirect(req.getContextPath() + "/pages/err.jsp");
        }
    }
}
