package com.es.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.es.entity.Customer;


@Component
public interface CustomerRepo  extends JpaRepository<Customer, Integer> {
	
	
	public Customer findByaccountNumber(long accNum);

	public Customer findByaccountNumber(String accNum);


}
