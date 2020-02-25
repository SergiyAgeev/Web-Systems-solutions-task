package test.task.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.task.dao.ValuesDao;
import test.task.model.Values;

@Repository
public class ValuesDaoImpl implements ValuesDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ValuesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Values add(Values values) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Long valuesId = (Long) session.save(values);
            transaction.commit();
            values.setId(valuesId);
            return values;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't values pack with id = " + values.getId(), e);
        }
    }
}
