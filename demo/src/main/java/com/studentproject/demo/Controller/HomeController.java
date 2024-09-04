package com.studentproject.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HomeController 
{
	 @GetMapping("/home")
		public String home()
		{
			return "wolcome to home";
		}
	    
	    @GetMapping("/contect")
	    public String contect()
	    {
	    	return "welcome to contect";
	    }
	    
	    @PreAuthorize("haseRole('ADMIN')")
	    @GetMapping("/balancecheck")
	    public String belance()
	    {
	    	return"your current balance 25000";
	    }

}
