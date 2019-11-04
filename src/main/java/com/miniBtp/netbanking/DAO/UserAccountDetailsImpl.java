package com.miniBtp.netbanking.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miniBtp.netbanking.Entity.Account;


@Repository
public class UserAccountDetailsImpl implements UserAccountDetails {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	static final Logger logger = Logger.getLogger(UserAccountDetailsImpl.class);
	
	@Override
	@Transactional
	public List<Account> getAccounts(long userId) {
		
		BasicConfigurator.configure();
		
		Session session = sessionFactory.getCurrentSession(); 
		
		
		
		Query<Account> query = session.createQuery("from Account where userId = :id", Account.class);
		
		query.setParameter("id", userId);
		
		List<Account> result = new ArrayList<>();
		
		if(query!=null) {
			result=query.getResultList();
		}
		
		return result;
	}

}
