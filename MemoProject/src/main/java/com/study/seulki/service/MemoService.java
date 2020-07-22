package com.study.seulki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seulki.common.Pagination;
import com.study.seulki.dao.MemoDao;
import com.study.seulki.dto.MemoDto;

@Service
public class MemoService implements IMemoService{
	
	@Autowired
	MemoDao dao;

	@Override
	public void memoRegister(MemoDto memo) {
		int result=dao.memoInsert(memo);
		
		if(result==0) {
			System.out.println("memoInsert fail.");
		}else {
			System.out.println("memoInsert success.");
		}
	}

	@Override
	 public void memoModify(MemoDto memo) {
		int result=dao.memoUpdate(memo);
		
		if(result==0) {
			System.out.println("memoUpdate fail.");
		}else {
			System.out.println("memoUpdate success.");
		}
	}

	@Override
	public List<MemoDto> memoList(String userId, Pagination pagination) {
		
		List<MemoDto> memoList=dao.memoSelectList(userId,pagination);
		
		if(memoList==null) {
			System.out.println("memoList search fail.");
		}else{
			System.out.println("memoList search success.");
		}

		return memoList;
	}

	@Override
	public int memoRemove(int memoNum) {
		int result=dao.memoDelete(memoNum);
		
		if(result==0) {
			System.out.println("memoRemove fail.");
		}else {
			System.out.println("memoRemove success.");
		}

		return result;
	}

	@Override
	public MemoDto memoListOne(int memoNum) {
		MemoDto memo=dao.memoSelectOne(memoNum);
		
		if(memo==null) {
			System.out.println("memoOne search fail.");
		}else{
			System.out.println("memoOne search success.");
		}

		return memo;
	}

	@Override
	public int memoListCnt(String userId) {
		int result=dao.memoListCnt(userId);
		
		if(result==0) {
			System.out.println("ListCnt search fail.");
		}else {
			System.out.println("ListCnt search success.");
			System.out.println("ListCnt: "+result);
		}
		
		return result;
	}

}
