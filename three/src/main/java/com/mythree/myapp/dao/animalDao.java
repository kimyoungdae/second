package com.mythree.myapp.dao;

import java.util.List;

import com.mythree.myapp.dto.animalDto;

public interface animalDao {
	//글목록
	public List<animalDto> getList(animalDto dto);
	//글의 갯수
	public int getCount(animalDto dto);
	//글 추가
	public void insert(animalDto dto);
	//글정보 얻어오기
	public animalDto getData(int num);
	//키워드를 활용한 글정보 얻어오기
	public animalDto getData(animalDto dto);
	//조회수 증가 시키기
	public void addViewCount(int num);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(animalDto dto);
}

