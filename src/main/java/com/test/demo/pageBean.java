package com.test.demo;

import java.util.List;

public class pageBean {
	private int rows;
    /**一页显示有几条数据*/
    private List<apkBean> list;
    /**分页所展示的每条数据*/
    private int currentPage;
    /**当前页数*/
    private int totalCount;
    /**总数*/
    private int totalPage;
    /**总页数*/
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public List<apkBean> getList() {
		return list;
	}
	public void setList(List<apkBean> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    
    
}
