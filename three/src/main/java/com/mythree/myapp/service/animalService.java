package com.mythree.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mythree.myapp.dto.animalDto;

public interface animalService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(animalDto dto);
	public void updateContent(animalDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public List<animalDto> getList2(HttpServletRequest request);
}
