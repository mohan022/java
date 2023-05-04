package com.excelsoft.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;
import com.excelsoft.exceptions.RecordNotFoundException;
import com.excelsoft.exceptions.UserAlreadyExistException;
import com.excelsoft.repo.CustomerRepo;
import com.mysql.cj.log.Log;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Transactional
	public Customer addCustomer(Customer c) {
		long accNum = c.getAccountNumber();
		Customer customer = customerRepo.findByaccountNumber(accNum);
		if (customer == null) {
			log.info("Customer created");

			return customerRepo.save(c);
		} else {
			throw new UserAlreadyExistException("user with account number " + c.getAccountNumber() + " alraedy exists");
		}

	}

	public Customer searchCustomerByAccountNumber(long accountNumber) {
		String msg = "Customer with accountnumber " + accountNumber + " not found";
		Customer customer = null;
		try {
			customer = customerRepo.findByaccountNumber(accountNumber);
			customer.getName();
			log.info("Customer found with Name :" + customer.getAccountNumber());

		} catch (Exception e) {
			log.info(msg);
			throw new RecordNotFoundException(msg);
		}

		return customer;
	}

	public void deleteCustomer(int user_Id) {
		Customer customer = customerRepo.getById(user_Id);

		if (customer != null) {
			log.info("customer with " + user_Id + " deleted");
			customerRepo.delete(customer);
		}

		log.error("customer not found");
		throw new RecordNotFoundException("customer with" + user_Id + " does not exist");

	}

	public List<Customer> listAllCustomer() {

		List<Customer> customer = customerRepo.findAll();

		return customer;
	}

}
