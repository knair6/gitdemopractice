package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	
	//need to inject DAO
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer cus) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(cus);
		
	}
	@Override
	@Transactional
	public Customer getCustomers(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers(id);
	}
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		 customerDAO.deleteCustomer(id);
		
	}

}
