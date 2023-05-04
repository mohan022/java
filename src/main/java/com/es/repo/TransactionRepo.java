package com.es.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.es.entity.Transaction;

@Component
public interface TransactionRepo  extends JpaRepository<Transaction, Integer>{
	

	
	
	
	

	

}
