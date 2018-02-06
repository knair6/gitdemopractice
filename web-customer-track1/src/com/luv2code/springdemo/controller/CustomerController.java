package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject the customer service
	@Autowired
	private CustomerService customerService;

	
 @GetMapping("/list")
 public String listCustomers(Model mod) {
	 //get the customers from dao
	 List<Customer> customers=customerService.getCustomers();
	 //add the customers to the model
	 mod.addAttribute("customer",customers); 
	 return "list-customer";
 }
 
 @GetMapping("/showFormForAdd")
 public String showFormForAdd(Model mod) {
	 Customer cus=new Customer();
	 //create model attribute
	 mod.addAttribute("add",cus);
	 
	return "customer-form";
	 
 }
 
 @PostMapping("/saveCustomer")
 public String SaveCustomer(@ModelAttribute("add") Customer cus) {
	 
	 customerService.saveCustomer(cus);
	 return "redirect:/customer/list";
 }
 
 @GetMapping("/showFormForUpdate")
 public String showFormForUpdate(@RequestParam("custId") int id,
		                                       Model mod ) {
	 //get the customer form service 
	 Customer customer=customerService.getCustomers(id);
	 //set customers as a modle attri to prepopulate the form
	 mod.addAttribute("add",customer);
	 //send over to our form
	 return "customer-form";
	 
 }
 @GetMapping("/delete")
 public String deleteCustomer(@RequestParam("custId") int id) {
	 //delete the customer
	 customerService.deleteCustomer(id);
	 return "redirect:/customer/list";
 }
 
}
