package com.study.seulki.dao;

import java.util.List;

import com.study.seulki.common.Pagination;
import com.study.seulki.dto.MemoDto;

public interface IMemoDao {
	
	int memoInsert(MemoDto memo);
	List<MemoDto> memoSelectList(String userId,Pagination pagination);
	MemoDto memoSelectOne(int memoNum);
	int memoUpdate(MemoDto memo);
	int memoDelete(int memoNum);
	int memoListCnt(String userId);

}
