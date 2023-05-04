package com.es.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

	public Account findByAccountNumber(String accno1);

}
