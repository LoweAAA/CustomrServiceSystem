package com.givemefive.customerservicesystem.repostory.impl;

import com.givemefive.customerservicesystem.model.Product;
import com.givemefive.customerservicesystem.repostory.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    private String hql;

    @Autowired
    private SessionFactory sessionFactory;
    private Session session(){
        return sessionFactory.getCurrentSession();
    }

    public void save(Product product) {
        session().save(product);
    }

    public void delete(String id) {
        hql = "DELETE FROM Product l WHERE l.id = ?";
        session().createQuery(hql).setParameter(0, id).executeUpdate();
    }

    public void update(Product product) {
        session().update(product);
    }

    public List<Product> getAll() {
        hql="FROM CustomerService ";
        return session().createQuery(hql).list();
    }

    public Product queryByID(String id) {
        hql = "FROM CustomerService l WHERE l.id = ?";
        return (Product) session().createQuery(hql).setParameter(0, id).uniqueResult();
    }
}