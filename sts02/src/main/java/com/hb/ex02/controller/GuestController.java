package com.hb.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.ex02.model.GuestDao;

@Controller
public class GuestController {

	private GuestDao dao;
	
	@Autowired
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/")
	public String selectAll(Model model) {
		try{
		model.addAttribute("alist", dao.listAll());
		}catch(Exception e){}
		return "list";
	}
	
	@RequestMapping("/add")
	public String addView() {
		return "addform";
	}
	
	@RequestMapping("/insert")
	public String insertOne() {
//		dao.insertOne();
		return "redirect:/";
	}
}










