package com.miniBtp.netbanking.Controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miniBtp.netbanking.DAO.UserAccountDetails;
import com.miniBtp.netbanking.Entity.Account;

@Controller
public class TestController {

	@Autowired
	private UserAccountDetails details;
	
	
	static final Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String test() {
		
		BasicConfigurator.configure();
		
		logger.debug("Log4j connection successful!!");
		
		return "test";
	}
	
	@RequestMapping("/list")
	public String getAccountDetails() {
		
		
		BasicConfigurator.configure();
		
		List<Account> list = details.getAccounts(1);
		
		for(Account temp:list) {
			logger.debug(temp.toString());
		}
		
		
		
		return "test";
	}
	
}
