package com.data.session_10.repository;

import com.data.session_10.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Customer> findAll() {
        return getSession().createQuery("FROM Customer", Customer.class).list();
    }

    @Override
    public Customer findById(Long id) {
        return getSession().get(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        getSession().save(customer);
    }

    @Override
    public void update(Customer customer) {
        getSession().update(customer);
    }

    @Override
    public void delete(Long id) {
        Customer c = findById(id);
        if (c != null) getSession().delete(c);
    }

    @Override
    public boolean existsByUsername(String username) {
        String hql = "SELECT COUNT(*) FROM Customer WHERE username = :username";
        Long count = (Long) getSession().createQuery(hql)
                .setParameter("username", username)
                .uniqueResult();
        return count > 0;
    }

    @Override
    public boolean existsByEmail(String email) {
        String hql = "SELECT COUNT(*) FROM Customer WHERE email = :email";
        Long count = (Long) getSession().createQuery(hql)
                .setParameter("email", email)
                .uniqueResult();
        return count > 0;
    }

    @Override
    public boolean existsByPhone(String phone) {
        String hql = "SELECT COUNT(*) FROM Customer WHERE phone = :phone";
        Long count = (Long) getSession().createQuery(hql)
                .setParameter("phone", phone)
                .uniqueResult();
        return count > 0;
    }
}
