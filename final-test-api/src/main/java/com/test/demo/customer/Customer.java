package com.test.demo.customer;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Customer {

	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(min=2, max=20)
	private String name;
	
	@NotBlank(message = "Surname is mandatory")
	@Size(min=2, max=30)
	private String surname;
	
	private LocalDate birthDate;
	
	@NotBlank(message = "Phone number is mandatory")
	@Size(min=9, max=12)
	private String phoneNumber;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email address is invalid")
	private String email;

	public Customer() {
	};

	
//constructor with customer ID for showing customers
	public Customer(Integer id, String name, String surname, LocalDate birthDate, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
