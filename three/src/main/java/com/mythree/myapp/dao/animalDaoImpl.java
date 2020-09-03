package com.mythree.myapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mythree.myapp.dto.animalDto;

@Repository
public class animalDaoImpl implements animalDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<animalDto> getList(animalDto dto) {
		
		return session.selectList("cafe.getList", dto);
	}

	@Override
	public int getCount(animalDto dto) {

		return session.selectOne("animal.getCount", dto);
	}

	@Override
	public void insert(animalDto dto) {
		session.insert("cafe.insert", dto);
	}

	@Override
	public animalDto getData(int num) {
		return session.selectOne("animal.getData", num);
	}

	@Override
	public void addViewCount(int num) {
		session.update("animal.addViewCount", num);
	}

	@Override
	public void delete(int num) {
		session.delete("animal.delete", num);
	}

	@Override
	public void update(animalDto dto) {
		session.update("animal.update", dto);
	}

	
}
