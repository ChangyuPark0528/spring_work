package com.spring.myweb.user.mapper;

import com.spring.myweb.user.entity.User;

public interface IUserMapper {
	
	//아이디 중복 확인
	int idCheck(String id); //아이디가 존재한다면 1을 리턴하여 중복여부 확인.
		
	//회원가입
	void join(User user);
	
	//로그인
	//id를 통해 pw를 조회하는 메서드
	String login(String id);
	
	//회원정보 얻어오기
	User getInfo(String id);
	
	//회원정보 수정
	void updateUser(User user);
	
}
