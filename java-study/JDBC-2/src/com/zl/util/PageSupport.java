package com.zl.util;
//��ҳ�����ࣺ������ҳ��/ҳ����
public class PageSupport {
	//��ǰҳ��
	private int currentPageNo = 1;
	//����������;
	private int totalCount = 0;
	//ҳ����
	private int pageSize = 0 ;
	//��ҳ��
	private int totalPageCount = 1;
	
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo>0) {
			this.currentPageNo = currentPageNo;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	//������ҳ��
	public void setTotalPageCountByRs(){
		if (this.totalCount%this.pageSize==0) {
			this.totalPageCount=this.totalCount/this.pageSize;
		}else if(this.totalCount%this.pageSize!=0)  {
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}else {
			this.totalPageCount=0;
		}
	}
	//������������������ʱ��ͬ����һ���£��������ҳ��
	public void setTotalCount(int totalCount) {
		if (totalCount>=0) {
			this.totalCount = totalCount;
			//������ҳ��
			this.setTotalPageCountByRs();
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize>0) {
			this.pageSize = pageSize;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
}
