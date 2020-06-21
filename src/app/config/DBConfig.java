package app.config;

import app.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DBConfig {
    public static SessionFactory getSessionFactory() throws HibernateException {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/car_rental?autoReconnect=true&useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Luxal.99");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(CarModel.class);
        configuration.addAnnotatedClass(CarBrand.class);
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Vehicle.class);
        configuration.addAnnotatedClass(ReservationStatus.class);
        sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
