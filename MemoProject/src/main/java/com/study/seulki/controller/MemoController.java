package com.study.seulki.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.seulki.common.Pagination;
import com.study.seulki.dto.MemberDto;
import com.study.seulki.dto.MemoDto;
import com.study.seulki.service.MemoService;

@Controller
public class MemoController {

	@Autowired
	MemoService service;

	@RequestMapping("memoList")
	public ModelAndView memoList(HttpSession session,
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "1")int range) {
		
		ModelAndView mav = new ModelAndView();
		
		MemberDto mDto = (MemberDto) session.getAttribute("member");
		String id=mDto.getUserId();
		
		int listCnt=service.memoListCnt(id);
		
		Pagination pagination=new Pagination();
		pagination.pageInfo(page, range, listCnt);

		List<MemoDto> memoList = service.memoList(id,pagination);
	
		
		mav.addObject("pagination", pagination);
		mav.addObject("memoList", memoList);
		mav.addObject("mUser", mDto.getUserId());

		mav.setViewName("jsp/memo/memo_list");

		return mav;
	}
	
	@RequestMapping("memoInsertForm")
	public String memoInsertForm() {
		
		return "jsp/memo/memo_insert_form";
	}
	
	@RequestMapping(value="memoInsert", method=RequestMethod.POST)
	public ModelAndView memoInsert(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		MemoDto memo=new MemoDto();
		
		String mUserId=request.getParameter("mUserId");
		

		  memo.setMemoTitle(request.getParameter("title"));
		  memo.setMemoContent(request.getParameter("content"));
		  memo.setmUserId(mUserId);
		  
		  service.memoRegister(memo);

		
		mav.setViewName("redirect:/memoList");
		
		return mav;
	}
	
	
	  @RequestMapping(value="memoInsertTest") public void memoInsertTest() {
	  
	  for(int i=1;i<155;i++) { MemoDto memo=new MemoDto();
	  memo.setMemoTitle("제목 "+i); memo.setMemoContent("내용 "+i);
	  memo.setmUserId("seulki0385");
	  
	 service.memoRegister(memo); }
	  
	  }

	
	@RequestMapping("memoUpdateForm")
	public ModelAndView memoUpdateForm(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		int memoNum=Integer.parseInt(request.getParameter("memoNum"));
		
		MemoDto memo=service.memoListOne(memoNum);
		
		mav.addObject("memo",memo);
		mav.setViewName("jsp/memo/memo_update_form");
		
		return mav;
	}
	
	@RequestMapping(value="memoUpdate", method=RequestMethod.POST)
	public String memoUpdate(HttpServletRequest request) {
		
		int memoNum=Integer.parseInt(request.getParameter("memoNum"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		MemoDto memo=new MemoDto();
		 
		memo.setMemoNum(memoNum);
		memo.setMemoTitle(title);
		memo.setMemoContent(content);
		
		service.memoModify(memo);
		
		return "redirect:/memoList";
		
	}
	
	@RequestMapping(value="memoDelete", method=RequestMethod.POST)
	public String memoDelete(HttpServletRequest request) {
		int memoNum=Integer.parseInt(request.getParameter("memoNum"));
		
		service.memoRemove(memoNum);
		
		return "redirect:/memoList";
	}
	

}
