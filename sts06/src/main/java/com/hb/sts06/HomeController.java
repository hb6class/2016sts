package com.hb.sts06;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/upload")
	public String upload() {
		return "upform";
	}
	@RequestMapping(value="/result")
	public String upResult(
			@RequestParam("id") String id
			,@RequestParam("pw")  String pw
			,@RequestParam("file1") MultipartFile file
			,Model model) {
		
		String orgFilenm=file.getOriginalFilename();
		logger.info(orgFilenm);
		File f= new File("C:\\sts\\file\\"+orgFilenm);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msg="id:"+id+",pw:"+pw;
		model.addAttribute("filename", orgFilenm);
		model.addAttribute("msg", msg);
		return "result";
	}
}








