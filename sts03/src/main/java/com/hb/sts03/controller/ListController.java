package com.hb.sts03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.sts03.model.dao.GuestDao;
import com.hb.sts03.model.dto.GuestVo;

@Controller
public class ListController {
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping("/guest")
	public String guestList(Model model){
		List<GuestVo> list=guestDao.selectAll();
		model.addAttribute("alist", list);
		return "list";
	}
}
