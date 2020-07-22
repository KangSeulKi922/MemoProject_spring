package com.study.seulki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seulki.dao.MemberDao;
import com.study.seulki.dto.MemberDto;

@Service
public class MemberService implements IMemberService{

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(MemberDto mDto) {
		int result=dao.memberInsert(mDto);
		
		if(result==0) {
			System.out.println("member join fail.");
		}else{
			System.out.println("member join success.");
		}
		
	}

	@Override
	public MemberDto memberSearch(MemberDto mDto) {
		
		MemberDto member=dao.memberSelect(mDto);
		
		if(member==null) {
			System.out.println("member search fail.");
		}else{
			System.out.println("member search success.");
		}
		
		return member;
	}

	@Override
	public MemberDto memberModify(MemberDto mDto) {
		
		return null;
	}

	@Override
	public int memberRemove(MemberDto mDto) {
		
		return 0;
	}

	@Override
	public int idSearch(String userid) {
		int result=dao.idSelect(userid);
		if(result==0) {
			System.out.println("아이디가 존재하지 않습니다.");
		}else{
			System.out.println("아이디가 존재합니다.");
		}
		
		return result;
	}

}
