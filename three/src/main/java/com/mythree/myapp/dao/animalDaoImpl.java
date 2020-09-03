package com.mythree.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;

@Repository
public class animalDaoImpl implements animalDao{
	@Autowired
	private SqlSession session;

	@Override
	public boolean isExist(String inputId) {
		//입력한 아이디가 존재하는지 id 를 select 해 본다.
		String id=session.selectOne("animal.isExist", inputId);
		
		if(id==null) {//존재하지 않는 아이디
			return false;
		}else {//존재하는 아이디
			return true;
		}
	}

	@Override
	public void insert(animalDto dto) {
		session.insert("users.insert", dto);
	}
	
	//인자로 전달되는 id 에 해당되는 사용자 정보를 리턴하는 메소드 
	@Override
	public animalDto getData(String id) {
		animalDto dto=session.selectOne("animal.getData", id);
		return dto;
	}

	@Override
	public void delete(String id) {
		session.delete("animal.delete", id);
	}

	@Override
	public void update(animalDto dto) {
		session.update("animal.update", dto);
	}

	@Override
	public void updatePwd(animalDto dto) {
		session.update("animal.updatePwd", dto);
	}
	
}