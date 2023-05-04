package com.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.es.entity.Account;
import com.es.entity.Customer;
import com.es.services.AccountService;
import com.es.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AccountController {

	@Autowired
	AccountService accountService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/account")
	public String showCustomerRegistrationForm1(Model model) {
		model.addAttribute("account", new Account());
		
		return "Account";
	}
	
	@PostMapping("/Createaccount")
	public String createAccount( Account account, String accountNumber) {
		return accountService.createAccount(account, accountNumber);
	}

	/*
	 * @GetMapping(value = "/credit/{accountNumber}/{amount}") public int
	 * creditAmount(@PathVariable("accountNumber") long
	 * accountNumber, @PathVariable("amount") int amount) { return
	 * accountService.creditBalance(accountNumber, amount); }
	 * 
	 * @GetMapping(value = "/debit/{accountNumber}/{amount}") public int
	 * debitAmount(@PathVariable("accountNumber") long
	 * accountNumber, @PathVariable("amount") int amount) { return
	 * accountService.debitBalance(accountNumber, amount); }
	 * 
	 * @GetMapping(value = "/{accountNumber}") public Account
	 * debitAmount(@PathVariable("accountNumber") long accountNum) { return
	 * accountService.searchCustomerByAccNum(accountNum); }
	 * 
	 * @DeleteMapping(value = "/delete/{accountNumber}") public void
	 * deleteAccount(@PathVariable("accountNumber") String accountNumber) {
	 * accountService.removeAccount(accountNumber); }
	 */

}
