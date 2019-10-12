package com.miniBtp.netbanking.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "cr/db")
	private String CrDb;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "closing_balance")
	private long closingBalance;
	
	@Column(name = "date")
	private Date date;
	

}
