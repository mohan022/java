package com.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.entity.Customer;
import com.es.entity.Transaction;
import com.es.services.TransctionaIService;


	@Controller
	public class TransactionController {
		
		@Autowired
		TransctionaIService transation;
		
		@GetMapping("/transaction")
		public String showCustomerRegistrationForm(Model model) {
			model.addAttribute("transaction", new Transaction());

			return "transaction.html";
		}
		@PostMapping("/fundTransfer")
		public String processCustomerRegister(Transaction transaction) {
			return transation.addTransaction(null, null, 0);
		}
	}


