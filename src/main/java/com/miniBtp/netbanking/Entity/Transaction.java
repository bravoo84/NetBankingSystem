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
	
	@Column(name = "crdb")
	private String crDb;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "closing_balance")
	private long closingBalance;
	
	@Column(name = "date")
	private Date date;
	
	public Transaction() {
		
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCrDb() {
		return crDb;
	}

	public void setCrDb(String crDb) {
		this.crDb = crDb;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNo=" + accountNo + ", details=" + details
				+ ", CrDb=" + crDb + ", amount=" + amount + ", closingBalance=" + closingBalance + ", date=" + date
				+ "]";
	}
	
	
	
	
	
	

}
