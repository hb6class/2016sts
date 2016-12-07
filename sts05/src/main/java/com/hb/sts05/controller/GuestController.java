package com.hb.sts05.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.sts05.model.GuestDao;
import com.hb.sts05.model.GuestVo;

@Controller
public class GuestController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/guest")
	public String guestList(Model model) {
		GuestDao mapper = sqlSession.getMapper(GuestDao.class);
		List list=mapper.selectAll();
		model.addAttribute("alist", list);
		return "guest";
	}
	
	@RequestMapping("/guest/detail")
	public String guestDetail(Model model,@RequestParam("idx") int sabun) {
		GuestDao mapper = sqlSession.getMapper(GuestDao.class);
		model.addAttribute("bean", mapper.selectOne(sabun));
		return "detail";
	}
	@RequestMapping(value="/guest/update",method=RequestMethod.POST)
	public String guestUpdate(GuestVo bean) {
		GuestDao mapper = sqlSession.getMapper(GuestDao.class);
		mapper.updateOne(bean);
		return "redirect:/guest";
	}
}










