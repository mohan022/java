package com.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.es.entity.Customer;
import com.es.services.AccountService;
import com.es.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	AccountService accountService;

	@GetMapping("/customer")
	public String showCustomerRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());

		return "Customer";
	}

	@PostMapping("/Createcustomer")
	public String processCustomerRegister(Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/customerlist")
	public String listUsers(Model model) {
		List<Customer> listCustomers = customerService.listAllCustomer();
		model.addAttribute("listCustomers", listCustomers);

		return "CustomerList";
	}

	@GetMapping("/edit/{userId}")
	public String showUpdateForm(@PathVariable("userId") int id, Model model) {
		Customer customer = customerService.searchCustomerByAccountNumber(id);

		model.addAttribute("customer", customer);
		return "updateCustomer";
	}
	/*
	 * @GetMapping("/search/{userId}") public String
	 * searchCustomer(@PathVariable("userId") int id, Model model) { Customer
	 * customer = customerService.searchCustomerByAccountNumber(id);
	 * 
	 * model.addAttribute("customer", customer); return "Manager"; }
	 */

	@PostMapping("/update/{userId}")
	public String updateCustomer(@PathVariable("userId") int id, Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			customer.setUserId(id);
			return "updateCustomer";
		}
		return customerService.updateCustomer(customer);

	}

	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") int id, Model model) {
		return customerService             .deleteCustomer(id);
	}

}
