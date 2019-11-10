package com.miniBtp.netbanking.Service;

import java.util.List;

import com.miniBtp.netbanking.Entity.Transaction;

public interface TransactionService {
	
	public int performTransaction(String from, String to, String amount, String details);
	
	public List<Transaction> generateMiniStatement(String accountNo);
	
}
