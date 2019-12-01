package com.zy.user.domain;

public class Page {
	private int pageSize;	// ÿҳ���ļ�¼������
	private int totalPage;	// ��ҳ��
	private int totalCount;	// �ܼ�¼��
	private int currPage;	// ��ǰ���ڵ�ҳ��,���1ҳ,��2ҳ
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return  (int) Math.ceil(totalCount * 1.0 / pageSize);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", currPage=" + currPage + "]";
	}
	
	
}

