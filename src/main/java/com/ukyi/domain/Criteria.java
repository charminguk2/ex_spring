package com.ukyi.domain;

public class Criteria {// �з��� ������ ǥ���ϴ� �Ӽ�
	private int page;// ���� ������
	private int perPageNum;// �� �������� ������ ���ڵ� ��

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

	public int getPageStart() {// MyBatis���� ������ ��ŵ�� ���� ��
		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [������:" + page + ", ������ ���� ��:" + perPageNum + "]";
	}

}
