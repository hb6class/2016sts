package com.hb.ex02.controller;


import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.ex02.model.GuestDao;
import com.hb.ex02.model.GuestDaoImf;
import com.hb.ex02.model.GuestVo;

@Controller
public class GuestController {
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private GuestDaoImf dao;

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
	public String insertOne(GuestVo bean, Model model) {
		log.debug(bean);
			dao.insertOne(bean);
		return "redirect:/";
	}
	
	@RequestMapping("/detail")
	public String detailOne(@RequestParam("idx") int sabun,Model model) {
		log.debug(sabun);
		System.out.println(sabun);
		try{
		model.addAttribute("bean", dao.selectOne(sabun));
		}catch(Exception e){}
		return "detail";
	}
}










