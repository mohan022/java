package com.es.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue
	private int transactionId;

	private String senderAccountNumber;

	private String beneficiaryAccountNumber;

	private int amount;

	private int senderBalAmount;

	private int beneficiaryBalAmount;
	@ManyToOne
	@JoinColumn(name = "custId")
	@JsonBackReference
	private Customer cust;
	

	
	
}
