package com.miniBtp.netbanking.DAO;

import java.util.List;

import com.miniBtp.netbanking.Entity.Account;

public interface UserAccountDetails {

	List<Account> getAccounts(int userId); 
	
}
