package com.es.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private int userId;

	private String accountNumber;

	private String name;

	private String gender;

	private String email;

	private String contact;

	private String aadharNo;

	// use one to one mapping
	@OneToOne(mappedBy = "customer")

	private Account account;
	@OneToMany(mappedBy = "cust")
	@JsonManagedReference
	private List<Transaction> transactionList;

	
}
