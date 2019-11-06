package com.miniBtp.netbanking.Service;

public interface TransactionService {
	
	public int performTransaction(String from, String to, String amount, String details);
	
}
