package com.hb.sts04.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.sts04.guest.model.GuestDao;

@Controller
public class GuestController {
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping("/guest")
	public String guestList(Model model) {
		model.addAttribute("alist", guestDao.selectAll());
		return "guest/list";
	}
}
