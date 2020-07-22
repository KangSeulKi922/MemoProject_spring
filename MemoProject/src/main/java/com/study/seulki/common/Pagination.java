package com.study.seulki.common;

public class Pagination {
	
	//한 페이지 목록의 개수
	private int listSize=10;
	//한 페이지 범위의 개수
	private int rangeSize=10;
	
	//현재 페이지
	private int page;
	//현재 페이지 범위
	private int range;
	//총 개시물의 개수
	private int listCnt;
	//전체 페이지수
	private int pageCnt;
	//시작번호 
	private int startPage;
	//게시판 시작번호
	private int startList;
	//끝번호
	private int endPage;
	//이전 페이지
	private boolean prev;
	//다음 페이지
	private boolean next;
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangSize) {
		this.rangeSize = rangSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getListCnt() {
		return listCnt;
	}
	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void pageInfo(int page, int range, int listCnt) {
		this.page=page;
		this.range=range;
		this.listCnt=listCnt;
		
		//전체 페이지수
		this.pageCnt=(int) Math.ceil(listCnt/(double)listSize);
		
		//시작 페이지
		this.startPage=(range-1)*rangeSize+1;
		
		//끝 페이지
		this.endPage=range*rangeSize;
		
		//게시판 시작번호
		this.startList=(page-1)*listSize;
		
		//이전 버튼 상태
		if(range==1) {
			this.prev=false;
		}else {
			this.prev=true;
		}
		
		//다음 버튼 상태
		if(endPage>pageCnt) {
			this.endPage=this.pageCnt;
			this.next=false;
		}else {
			this.next=true;
		}
		
	}

}
