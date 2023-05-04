package com.es.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.es.entity.Customer;
import com.es.exception.RecordNotFoundException;
import com.es.exception.UserAlreadyExistException;
import com.es.repo.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Transactional
	public String addCustomer(Customer c) {
		String accNum = c.getAccountNumber();
		Customer customer = customerRepo.findByaccountNumber(accNum);
		if (customer == null) {
			log.info("Customer created");

			customerRepo.save(c);
			return "successPage.html";
		} else {
			return "error.html";
		}

	}

	@Transactional
	public String updateCustomer(Customer c) {

		customerRepo.save(c);
		return "register_success.html";

	}

	public Customer searchCustomerByAccountNumber(int id) {
		String msg = "Customer with accountnumber " + id + " not found";
		Customer customer = null;
		try {
			customer = customerRepo.getOne(id);
			customer.getName();
			log.info("Customer found with Name :" + customer.getAccountNumber());

		} catch (Exception e) {
			log.info(msg);
			throw new RecordNotFoundException(msg);
		}

		return customer;
	}

	public String deleteCustomer(int user_Id) {
		Customer customer = customerRepo.getOne(user_Id);

		if (user_Id == customer.getUserId()) {
			log.info("customer with " + user_Id + " deleted");
			customerRepo.delete(customer);
			return "successPage.html";
		}

		log.error("customer not found");
		throw new RecordNotFoundException("customer with" + user_Id + " does not exist");

	}

	public List<Customer> listAllCustomer() {

		List<Customer> customer = customerRepo.findAll();

		return customer;
	}

}
