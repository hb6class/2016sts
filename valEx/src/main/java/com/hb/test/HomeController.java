package com.hb.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("index is {}.", locale);
				return "home";
	}
	
	@RequestMapping(value = "/result/", method = RequestMethod.GET)
	public String result(@Valid JavaBean bean,BindingResult result,Model model){
		if(result.hasErrors()){
			logger.info("에러있음");
			Map errMsgs = new HashMap<String, String>();
			List<FieldError> errs = result.getFieldErrors();
			for(FieldError err : errs){
				logger.info(err.getField()+":"+err.getDefaultMessage());
				errMsgs.put(err.getField(), err.getDefaultMessage());
			}
			model.addAttribute("errs", errMsgs);
			return "home";
		}
		logger.info(bean.toString());
		return "result";
	}
	
}













