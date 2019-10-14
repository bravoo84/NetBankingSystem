package com.miniBtp.netbanking.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniBtp.netbanking.DAO.UserAccountDetails;
import com.miniBtp.netbanking.DAO.UserDetails;
import com.miniBtp.netbanking.Entity.Account;
import com.miniBtp.netbanking.Entity.User;

@Controller
public class TestController {

	@Autowired
	private UserAccountDetails details;
	
	@Autowired
	private UserDetails userDetails;
	
	
	
	static final Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/test")
	public String test(HttpSession session) {
		
		BasicConfigurator.configure();
		
		if(session.getAttribute("username")!=null) {
			return "success";
		}
		
		logger.debug("Log4j connection successful!!");
		
		return "test";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session,
			ModelMap modelMap) {
		
		
		long userId = Long.parseLong(username);
		
		List<User> user = userDetails.getUserDetails(userId);
		
		if(user!=null) {
			
			String fetched_password = user.get(0).getPassword();
			
			if(fetched_password.equalsIgnoreCase(password)) {
				session.setAttribute("username", username);
				return "success";
			
			} else {
				modelMap.put("error", "Invalid Account");
				return "test";
			}
		
		} else {
			modelMap.put("error", "Invalid Account");
			return "test";
		}	
		
		 
		
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/test";
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
