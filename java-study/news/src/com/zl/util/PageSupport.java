package com.zl.util;
//分页工具类：计算总页数-->总数量/页容量     非整数+1
public class PageSupport {
	//当前页（第几页）
	private int currentPageNo = 1;
	//新闻的总数量
	private int totalCount = 0;
	//页面容量
	private int pageSize = 0;
	//总页数
	private int totalPageCount = 1;
	
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo>0){//当前页码>0才显示
		this.currentPageNo = currentPageNo;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	//计算总页数的方法(根据结果计算总页数)
	public void setTotalPageCountByRs(){
		if(this.totalCount%this.pageSize==0){
			this.totalPageCount=this.totalCount/this.pageSize;
		}else if(this.totalCount%this.pageSize!=0){
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}else{
			this.totalPageCount = 0;//用户没访问页面的时候
		}
	}
	//总数量（整数/非整数）
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			//设置总页数
			this.setTotalPageCountByRs();
				
			}
		}
		

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
}
