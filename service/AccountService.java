package com.excelsoft.service;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;
import com.excelsoft.exceptions.InsuffientBalanceException;
import com.excelsoft.exceptions.RecordNotFoundException;
import com.excelsoft.exceptions.UserAlreadyExistException;
import com.excelsoft.repo.AccountRepo;
import com.excelsoft.repo.CustomerRepo;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;

@Component
@Slf4j
public class AccountService {

	private static final Exception RecordNotFoundException = null;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;

	@Transactional
	public Account createAccount(Account a, long accountNumber) {
		String msg = "Record with userID " + accountNumber + " not found";

		Customer customer = customerRepo.findByaccountNumber(accountNumber);
		if (customer != null) {
			log.info("account created for the customer" + customer.getName());
			a.setCustomer(customer);
			accountRepo.save(a);
			return a;
		} else {

			throw new RecordNotFoundException("Customer with account" + accountNumber + " number Not exists");
		}
	}

	@Transactional
	public int creditBalance(long accNum, int amount) {
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
	public int debitBalance(long accNum, int amount) {
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
	public void removeAccount(long accNum) {
		String msg = "Record with userID " + accNum + " not found";

		List<Account> account = accountRepo.findAll();

		for (Account account1 : account) {
			if (account1.getAccountNumber() == accNum) {

				accountRepo.delete(account1);
			}
		}
	}

	@Transactional
	public Account searchCustomerByAccNum(long accountNumber) {

		Account account = accountRepo.findByAccountNumber(accountNumber);

		if (account == null) {

			throw new RecordNotFoundException("Account " + accountNumber + " does not exist");

		}

		return account;
	}

}
