package com.miniBtp.netbanking.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniBtp.netbanking.DAO.UserAccountDetails;
import com.miniBtp.netbanking.DAO.UserDetails;
import com.miniBtp.netbanking.Entity.Account;
import com.miniBtp.netbanking.Entity.User;
import com.miniBtp.netbanking.Service.TransactionService;

@Controller
public class TestController {

	@Autowired
	private UserAccountDetails accountDetails;
	
	@Autowired
	private UserDetails userDetails;
	
	
	static final Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/test")
	public String test(HttpSession session) {
		
		BasicConfigurator.configure();
		
		if(session.getAttribute("username")!=null) {
			return "redirect:/home";
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
		
		if(!user.isEmpty()) {
			
			String fetched_password = user.get(0).getPassword();
			
			if(fetched_password.equalsIgnoreCase(password)) {
				session.setAttribute("username", username);
				return "redirect:/home";
			
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
		session.setAttribute("username",null);
		return "redirect:/test";
	}
	
	
	
	@RequestMapping("/home")
	public String getAccountDetails(Model model, HttpSession session) {
		
		
		BasicConfigurator.configure();
		
		if(session.getAttribute("username")==null) {
			return "redirect:/test";
		}
		
		String username = (String)session.getAttribute("username");
		
		List<Account> accountList = accountDetails.getAccounts(Long.parseLong(username));
		
		
		for(Account temp:accountList) {
			logger.debug(temp.toString());
		}
		
		model.addAttribute("accountList", accountList);
		
		return "success";
	}
	
	
	@RequestMapping("/transfer")
	public String transfer(HttpSession session) {
		
		BasicConfigurator.configure();
		if(session.getAttribute("username")==null) {
			return "redirect:/test";
		}
		
		return "transfer";
		
	}
	
	
	@RequestMapping(value = "transaction", method = RequestMethod.POST)
	public String transaction(@RequestParam("accountNoCred") String accountNoCred,
								@RequestParam("amount") Long amountDebited,
								@RequestParam("details") String details,
								HttpSession session,
								Model theModel) {
		
		BasicConfigurator.configure();
		if(session.getAttribute("username")==null) {
			return "redirect:/test";
		}
		
		/*
		 *
		 * 
		 * */
		
		
		return"redirect:/home";
		
	}
	
	
	
	
}
