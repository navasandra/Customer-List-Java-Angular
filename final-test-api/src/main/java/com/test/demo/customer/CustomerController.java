package com.test.demo.customer;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/rest/customers")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(value = "/get-customers", method = RequestMethod.GET)
	public ArrayList<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@RequestMapping(value = "/post-customer", method = RequestMethod.POST)
	public void addCustomer(@Valid @RequestBody Customer customer) throws Exception {
		customerDAO.addCustomer(customer);
	}
}
