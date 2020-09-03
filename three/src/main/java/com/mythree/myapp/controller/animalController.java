package com.mythree.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mythree.myapp.dto.animalDto;
import com.mythree.myapp.service.animalService;


@Controller
public class animalController {
	@Autowired
	private animalService animalService;
	//카페 글 목록 보기 요청 처리 
	@RequestMapping("/animal/list")
	public ModelAndView getList(HttpServletRequest request, 
			ModelAndView mView) {
		animalService.getList(request);
		mView.setViewName("animal/list");
		return mView;
	}
	
	@RequestMapping("/animal/detail")
	public ModelAndView detail(HttpServletRequest request,
			ModelAndView mView) {
		animalService.getDetail(request);
		mView.setViewName("animal/detail");
		return mView;
	}
	
	@RequestMapping("/animal/private/insertform")
	public ModelAndView insertForm(ModelAndView mView) {
		
		mView.setViewName("animal/insertform");
		return mView;
	}
	
	@RequestMapping(value = "/animal/private/insert", method=RequestMethod.POST)
	public ModelAndView insert(animalDto dto, ModelAndView mView, HttpSession session) {
		//dto 에 글 작성자 담기 
		String id=(String)session.getAttribute("id");
		dto.setWriter(id);
		animalService.saveContent(dto);
		mView.setViewName("animal/insert");
		return mView;
	}
	
	@RequestMapping("/animal/private/updateform")
	public ModelAndView updateform(HttpServletRequest request,
			ModelAndView mView) {
		animalService.getDetail(request);
		mView.setViewName("animal/updateform");
		return mView;
	}
	@RequestMapping(value="/animal/private/update", method=RequestMethod.POST)
	public ModelAndView update(animalDto dto, ModelAndView mView) {
		animalService.updateContent(dto);
		mView.setViewName("animal/update");
		return mView;
	}
	@RequestMapping("/animal/private/delete")
	public ModelAndView delete(int num, HttpServletRequest request,
			ModelAndView mView) {
		animalService.deleteContent(num, request);
		mView.setViewName("redirect:/animal/list.do");
		return mView;
	}
}
