package app.database.crud;

import app.database.configuration.HibernateUtil;
import app.database.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService implements CrudService <Client> {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    @Override
    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        }
    }
    @Override
    public Client findById(Object id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }
    @Override
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }
    @Override
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(client);
            tx.commit();
        }
    }
}
