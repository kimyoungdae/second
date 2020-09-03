package com.mythree.myapp.dao;

import com.mythree.myapp.animal.dto.animalDto;

public interface animalDao {
	public boolean isExist(String inputId);
	public void insert(animalDto dto);
	public animalDto getData(String id);
	public void delete(String id);
	public void update(animalDto dto);
	public void updatePwd(animalDto dto);
}