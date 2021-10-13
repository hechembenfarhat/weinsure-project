package tn.weinsure1.restController;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonProperty;

/*import tn.weinsure1.service.PhoneverificationService;
import tn.weinsure1.service.VerificationResult;*/
import tn.weinsure1.service.sinisterServiceImpl;



@RestController
public class TwilioController {

	/*@Autowired
	PhoneverificationService phonesmsservice;
	    
	private static final Logger L = LogManager.getLogger(sinisterServiceImpl.class);
	
	@PostMapping("/sendotp/{phone}")
	public void sendotp(@PathVariable("phone") String phone)
	{
	    VerificationResult result=phonesmsservice.startVerification(phone);
	    if(result.isValid())
	    {
	    	L.info("DX " ) ;
	    }
	    L.info("DX ") ;
	}
	
	@PostMapping("/verifyotp/{phone}/{otp}")
	public void sendotp(@PathVariable("phone") String phone,@PathVariable("otp") String otp)
	{
	    VerificationResult result=phonesmsservice.checkverification(phone,otp);
	    if(result.isValid())
	    {
	    	L.info("DX " ) ;
	    }
		L.info("DX ") ;
	}
	
	*/
}
