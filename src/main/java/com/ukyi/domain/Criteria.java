package com.ukyi.domain;

public class Criteria {// 분류의 기준을 표현하는 속성
	private int page;// 현재 페이지
	private int perPageNum;// 한 페이지에 보여질 레코드 수

	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public void setPage(int page) {
		if (page < 1) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}

	public int getPerPageNum() {
		return this.perPageNum;
	}

	public int getPageStart() {// MyBatis에게 전달할 스킵될 행의 수
		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [페이지:" + page + ", 보여질 행의 수:" + perPageNum + "]";
	}

}
