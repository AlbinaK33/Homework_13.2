package app.database.configuration;

import app.database.entity.*;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Data
public class HibernateUtil implements AutoCloseable {
    private static final HibernateUtil INSTANCE;
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
