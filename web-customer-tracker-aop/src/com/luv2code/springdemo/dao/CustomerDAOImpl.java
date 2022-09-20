package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session=sessionFactory.getCurrentSession();
		List<Customer> customers=session.createQuery("FROM Customer ORDER BY lastName",Customer.class).getResultList();
		return customers;
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer= session.get(Customer.class,theId);
		return theCustomer;
	}

	@Override
	public void delete(int theId) {
		Session session=sessionFactory.getCurrentSession();
		Customer theCustomer=session.get(Customer.class,theId);
		session.delete(theCustomer);
		// TODO Auto-generated method stub
		
	}

}
