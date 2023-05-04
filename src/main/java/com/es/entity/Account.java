package com.es.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	private String accountNumber;

	private String accountType;

	private String name;

	private int balanceAmount;

	@OneToOne

	@JoinColumn(name = "cid")
	@JsonBackReference
	Customer customer;


	
}
