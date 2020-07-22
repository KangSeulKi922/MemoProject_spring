package com.study.seulki.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.seulki.dto.MemberDto;
import com.study.seulki.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping("memberLoginForm")
	public String memberLoginForm() {

		return "jsp/member/member_login_form";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MemberDto mDto = new MemberDto();

		mDto.setUserId(request.getParameter("userid"));
		mDto.setUserPw(request.getParameter("userpw"));

		mDto = service.memberSearch(mDto);

		if (mDto == null) {

			mav.addObject("msg", "회원이 존재하지 않습니다.");
			mav.setViewName("redirect:/memberLoginForm");
			return mav;
		}

		session.setAttribute("member", mDto);
		mav.setViewName("redirect:/memoList");
		return mav;

	}

	@RequestMapping("memberJoinForm")
	public String memberJoinForm() {
		return "jsp/member/member_join_form";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView join(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		MemberDto mDto = new MemberDto();

		mDto.setUserId(request.getParameter("userid"));
		mDto.setUserName(request.getParameter("username"));
		mDto.setUserPw(request.getParameter("userpw"));

		service.memberRegister(mDto);
		
		mav.addObject("msg", "회원가입이 완료되었습니다.");
		mav.setViewName("redirect:/memberLoginForm");

		return mav;

	}

	
	
	  @RequestMapping(value="idCheck", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json")  
	  	public @ResponseBody  Map<Object, Object> idCheck(@RequestBody String userid){
		  int count = 0;
		  Map<Object, Object> map = new HashMap<Object, Object>(); 
		  count=service.idSearch(userid); 
		  map.put("cnt", count); 
		  return map; 
	  }
	 
	 

	
	/*
	 * @RequestMapping("idCheck")
	 * 
	 * @ResponseBody public int idCheck(@RequestParam("userid") String userid) { int
	 * count = 1; return count; }
	 */
	  
	/*
	 * @RequestMapping(value = "idCheck", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public int idCheck(@RequestParam("userId") String userid) {
	 * 
	 * return service.idSearch(userid); }
	 */
	 

	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		session.invalidate();
		
		mav.addObject("msg", "로그아웃 되었습니다.");
		mav.setViewName("redirect:/memberLoginForm");

		return mav;
	}

}
