package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
//inject session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		//get current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		//create query
		Query<Customer> query=currentSession.createQuery("from Customer order by lastName",
				                                          Customer.class);
		//execute query and get result
		List<Customer> customers=query.getResultList();
		
		//return result
		return customers;
		
	}



	@Override
	public void saveCustomer(Customer cus) {
		// TODO Auto-generated method stub
		//get current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();
				
		//save customer 
		currentSession.saveOrUpdate(cus);
		//
		
	}



	@Override
	public Customer getCustomers(int id) {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session current=sessionFactory.getCurrentSession();
		
		
		//now retrieve from db using primary key
		Customer customer=current.get(Customer.class,id);
		return customer;
		
	}



	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
