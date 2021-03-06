package com.miniBtp.netbanking.DAO;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miniBtp.netbanking.Entity.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	static final Logger logger = Logger.getLogger(TransactionDAOImpl.class);

	@Override
	@Transactional
	public void addTransaction(String from, String to, String amount, String details, Date date,
								long currentBalanceFrom, long currentBalanceTo) {
		
		Session session = sessionFactory.getCurrentSession();
		
		long transferAmount = Long.parseLong(amount);
		
		
		// inserting transaction details for the logged in user
		Transaction transaction = new Transaction();
		transaction.setAccountNo(from);
		transaction.setAmount(transferAmount);
		transaction.setCrDb("Db");
		transaction.setDetails(details);
		transaction.setDate(date);
		transaction.setClosingBalance(currentBalanceFrom - transferAmount);
		session.save(transaction);
		
		// inserting transaction details for the receiving user
		Transaction transaction2 = new Transaction();
		transaction2.setAccountNo(to);
		transaction2.setAmount(transferAmount);
		transaction2.setCrDb("Cr");
		transaction2.setDetails(details);
		transaction2.setDate(date);
		transaction2.setClosingBalance(transferAmount + currentBalanceTo);
		session.save(transaction2);
		
		

	}

	@Override
	@Transactional
	public List<Transaction> getMiniStatement(String accountNo) {
		
		
		BasicConfigurator.configure();
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Transaction> query = session.createQuery("from Transaction where accountNo = :accountNo order by date desc",Transaction.class);
		query.setParameter("accountNo", accountNo);
		query.setMaxResults(10);
		
		List<Transaction> result = query.getResultList();
		
		for(Transaction r: result) {
			logger.debug(r);
		}
		
		
		return result;
	}
	
	
	

}
