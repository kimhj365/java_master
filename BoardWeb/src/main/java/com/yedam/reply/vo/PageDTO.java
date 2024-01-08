package com.yedam.reply.vo;

import lombok.Data;

@Data
public class PageDTO {
	// 페이징 처리 클래스
	
	private int currPage;
	private int totalCnt;
	private boolean prev;
	private boolean next;
	private int startPage;
	private int lastPage;
	
	// 생성자: 건수, 현재 페이지
	public PageDTO(int page, int totalCnt) {
		this.currPage = page;
		this.totalCnt = totalCnt;
		
		// 이전 페이지 여부, 첫 페이지, 마지막 페이지, 이후 페이지 여부
		// 1) 마지막 페이지 
		// ex) 전체 건수 70건 => 페이지 수 14개
		int realLast = (int) Math.ceil(totalCnt / 5.0);
		// 5개씩 보여주기 위한 마지막 페이지
		this.lastPage = (int) Math.ceil(page / 5.0) * 5;
		
		// 2) 처음 페이지 = 마지막 페이지 - 4
		this.startPage = this.lastPage - 4;
		this.lastPage = this.lastPage > realLast ? realLast : this.lastPage;
		
		// 3) 이전 페이지 여부
		this.prev = this.startPage > 1;
		
		// 4) 이후 페이지 여부
		this.next = this.lastPage < realLast;
		
	}

	@Override
	public String toString() {
		return "PageDTO [currPage=" + currPage + ", totalCnt=" + totalCnt + ", prev=" + prev + ", next=" + next
				+ ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}
	
}
