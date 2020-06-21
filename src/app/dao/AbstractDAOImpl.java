package app.dao;

import app.config.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAOImpl<T> implements AbstractDAO<T> {

    private final Class<T> entityClass;

    public AbstractDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    @Override
    public T save(T entity) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.save(entity);
        sessionTransaction.commit();
        session.close();
        return entity;
    }

    @Override
    public List<T> getAll() {
        List<T> tList = new ArrayList<>();
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            CriteriaQuery<T> tCriteriaQuery = session.getCriteriaBuilder().createQuery(this.entityClass);
            tCriteriaQuery.select(tCriteriaQuery.from(this.entityClass));
            tList = session.createQuery(tCriteriaQuery).getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tList;
    }

    @Override
    public T findById(Integer id) {
        T t = null;
        Transaction transaction = null;
        try {
            Session session = DBConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            t = session.find(this.entityClass, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public String update(T entity) {
        Session session = DBConfig.getSessionFactory().openSession();
        org.hibernate.Transaction sessionTransaction = session.beginTransaction();
        session.update(entity);
        session.flush();
        sessionTransaction.commit();
        session.close();
        return "Updated";
    }
}
