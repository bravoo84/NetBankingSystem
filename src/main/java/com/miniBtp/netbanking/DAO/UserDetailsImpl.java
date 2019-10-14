package com.miniBtp.netbanking.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miniBtp.netbanking.Entity.User;


@Repository
public class UserDetailsImpl implements UserDetails {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<User> getUserDetails(long userId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User where userId = :id",User.class);
		query.setParameter("id", userId);
		
		List<User> result = query.getResultList();
		
		
		return result;
	}

}
