package com.miniBtp.netbanking.DAO;

import java.util.List;

import com.miniBtp.netbanking.Entity.User;

public interface UserDetails {
	
	List<User> getUserDetails(long userId);

}
