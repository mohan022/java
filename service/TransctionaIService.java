package com.excelsoft.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excelsoft.enties.Account;
import com.excelsoft.enties.Customer;
import com.excelsoft.enties.Transaction;
import com.excelsoft.exceptions.InsuffientBalanceException;
import com.excelsoft.repo.AccountRepo;
import com.excelsoft.repo.CustomerRepo;
import com.excelsoft.repo.TransactionRepo;

@Component
public class TransctionaIService {

	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	CustomerRepo customerRepo;

	@Transactional
	public Transaction addTransaction(long accno1, long accno2, int amount) {
		Account senderAcc = accountRepo.findByAccountNumber(accno1);
		Account benificiryAcc = accountRepo.findByAccountNumber(accno2);

		Customer sender = customerRepo.findByaccountNumber(accno1);
		Customer receiver = customerRepo.findByaccountNumber(accno2);

		Transaction transaction = new Transaction();

		if (senderAcc != null) {
			if (senderAcc.getBalanceAmount() >= amount) {
				int newBal = senderAcc.getBalanceAmount() - amount;
				transaction.setSenderBalAmount(newBal);
				senderAcc.setBalanceAmount(newBal);
				transaction.setSenderAccountNumber(accno1);
				transaction.setAmount(amount);
				transaction.setCust(sender);
				transactionRepo.save(transaction);
			}
			else
			{
				throw new InsuffientBalanceException("insusufficient_Balance in sender account "+accno1);
			}
		}
		if (benificiryAcc != null) {
			int newBal1 = benificiryAcc.getBalanceAmount() + amount;
			transaction.setBeneficiaryAccountNumber(accno2);
			transaction.setBeneficiaryBalAmount(newBal1);
			benificiryAcc.setBalanceAmount(newBal1);
			transaction.setCust(receiver);
			transactionRepo.save(transaction);

		}
		transactionRepo.save(transaction);
		return transaction;
		
		
		

	}

}
