package com.es.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.es.entity.Account;
import com.es.entity.Customer;
import com.es.exception.InsuffientBalanceException;
import com.es.exception.RecordNotFoundException;
import com.es.repo.AccountRepo;
import com.es.repo.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccountService {

	private static final Exception RecordNotFoundException = null;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;

	@Transactional
	public String createAccount(Account a, String accountNumber) {
		String msg = "Record with userID " + accountNumber + " not found";

		Customer customer = customerRepo.findByaccountNumber(accountNumber);
		if (customer != null) {
			log.info("account created for the customer" + customer.getName());
			a.setCustomer(customer);
			accountRepo.save(a);
			return "register_success.html";
		} else {

			throw new RecordNotFoundException("Customer with account" + accountNumber + " number Not exists");
		}
	}

	@Transactional
	public int creditBalance(String accNum, int amount) {
		int newBalance = 0;
		Account account = accountRepo.findByAccountNumber(accNum);
		if (account != null) {
			int currentBalalnce = account.getBalanceAmount() + amount;
			account.setBalanceAmount(currentBalalnce);
			newBalance = currentBalalnce;
		} else {
			throw new RecordNotFoundException("Account " + accNum + "does not exist");
		}
		return newBalance;
	}

	@Transactional
	public int debitBalance(String accNum, int amount) {
		int newBalance = 0;
		Account account = accountRepo.findByAccountNumber(accNum);
		if (account != null) {

			if (account.getBalanceAmount() > amount) {

				int currentBalalnce = account.getBalanceAmount() - amount;
				account.setBalanceAmount(currentBalalnce);
				newBalance = currentBalalnce;
			} else {
				throw new InsuffientBalanceException(
						"insuffientBalance " + " present balance is = " + account.getBalanceAmount());
			}
		}
		return newBalance;
	}

	@Transactional
	public void removeAccount(String accNum) {
		String msg = "Record with userID " + accNum + " not found";

		List<Account> account = accountRepo.findAll();

		for (Account account1 : account) {
			if (account1.getAccountNumber() == accNum) {

				accountRepo.delete(account1);
			}
		}
	}

	@Transactional
	public Account searchCustomerByAccNum(String accountNumber) {

		Account account = accountRepo.findByAccountNumber(accountNumber);

		if (account == null) {

			throw new RecordNotFoundException("Account " + accountNumber + " does not exist");

		}

		return account;
	}

}
