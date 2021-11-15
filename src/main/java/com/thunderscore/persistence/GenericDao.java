package com.thunderscore.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericDao<T> {

    private Class<T> type;

    /**
     * Constructor for the class
     * @param type of Class
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Method finds all rows in database and returns a list of result
     * @return list of objects
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Method finds a row in database with passed id and returns the entity as a result
     * @param id of Integer type
     * @return entity class
     */
    public T getById(Integer id) {
        Session session = getSession();
        T entity = (T) session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Method deletes a row in database that complaint to passed entity
     * @param id of class
     */
    public void delete(Integer id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T entity = (T) session.get(type, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Method inserts a row with passed entity to the database and returns the id of inserted entity
     * @param entity of class
     * @return id of inserted entity
     */
    public Integer insert(T entity) {
        Integer id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer) session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Method updates the row of database with the same id of passed entity or inserts new row if id not match
     * @param entity of class
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Method finds all rows of the database that match to the any of objects data in passed Map
     * @param propertyMap Map of objects
     * @return list of entities
     */
    public List<T> findByPropertyEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry entry : propertyMap.entrySet()) {
            predicates.add(builder.equal(root.get((String) entry.getKey()), entry.getValue()));
        }
        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        return session.createQuery(query).getResultList();
    }

    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
