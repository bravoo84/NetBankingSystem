package com.miniBtp.netbanking.Controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

	
	static final Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping("/hello")
	public String test() {
		
		BasicConfigurator.configure();
		
		logger.debug("Log4j connection successful!!");
		
		return "test";
	}
}
