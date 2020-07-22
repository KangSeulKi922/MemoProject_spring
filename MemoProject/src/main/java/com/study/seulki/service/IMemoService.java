package com.study.seulki.service;

import java.util.List;

import com.study.seulki.common.Pagination;
import com.study.seulki.dto.MemoDto;

public interface IMemoService {
	
	void memoRegister(MemoDto memo);
	void memoModify(MemoDto memo);
	List<MemoDto> memoList(String userId, Pagination pagination);
	MemoDto memoListOne(int memoNum);
	int memoRemove(int memoNum);
	int memoListCnt(String userId);

}
