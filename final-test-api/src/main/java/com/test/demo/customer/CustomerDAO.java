package com.test.demo.customer;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	private ArrayList<Customer> customers = new ArrayList<>();

	public ArrayList<Customer> getCustomers() {

		while (customers.size() < 100) {
//			customers.size() + 1 - starting ID at 1 instead of 0
			customers.add(new Customer(customers.size() + 1, "Name" + (customers.size() + 1),
					"Surname" + (customers.size() + 1), LocalDate.of(1990, 01, 01).plusDays(customers.size() * 25),
					"123456789", "test" + (customers.size() + 1) + "@email.com"));
		}

		return customers;

	}

	public void addCustomer(Customer customer) throws Exception {
//		ensuring the email is unique by checking if customer with such email already exists
		for (int i = 0; i < customers.size(); i++) {
			if ((customer.getEmail()).toLowerCase().equals((customers.get(i).getEmail()).toLowerCase())) {
				throw new Exception("Customer with this email already exists");
			}
		}
//		setting ID to be the ID of the last array member + 1 to avoid duplication in case another customer gets deleted
		Integer id = customers.get(customers.size() - 1).getId() + 1;
//		adding new customer to the array
		customers.add(new Customer(id, customer.getName(), customer.getSurname(), customer.getBirthDate(),
				customer.getPhoneNumber(), customer.getEmail()));
	}
}
