package com.study.seulki.dao;

import java.util.List;

import com.study.seulki.dto.MemberDto;

public interface IMemberDao {
	
	int memberInsert(MemberDto mDto);
	MemberDto memberSelect(MemberDto mDto);
	int memberUpdate(MemberDto mDto);
	int memberDelete(MemberDto mDto);
	int idSelect(String userid);

}
