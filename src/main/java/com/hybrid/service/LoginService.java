package com.hybrid.service;

import com.hybrid.dao.MemberDao;
import com.hybrid.exception.LoginFailException;
import com.hybrid.model.Member;

public class LoginService {

	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	public Member login(String email, String password) {
		
		Member member = memberDao.selectByEmailAndPassword(email, password);
		if (member == null) {
			throw new LoginFailException("존재하지 않는 USER 입니다. 다시 입력해 주시기 바랍니다.");
		}
		
		return member;
	}
}
