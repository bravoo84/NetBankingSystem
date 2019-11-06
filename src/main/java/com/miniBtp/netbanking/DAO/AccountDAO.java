package com.miniBtp.netbanking.DAO;

import java.util.List;

import com.miniBtp.netbanking.Entity.Account;

public interface AccountDAO {
	
	public Long accountBalance(String accountNo);
	
	public boolean isValidAccount(String accountNo);
	
	public void updateAccount(String accountNo, long balance);

}
