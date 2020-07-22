package com.study.seulki.service;

import com.study.seulki.dto.MemberDto;

public interface IMemberService {
	
	void memberRegister(MemberDto mDto);
	MemberDto memberSearch(MemberDto mDto);
	MemberDto memberModify(MemberDto mDto);
	int memberRemove(MemberDto mDto);
	int idSearch(String userid);

}
