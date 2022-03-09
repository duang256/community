package cn.wit.common;

import java.util.List;

public class PageInfo<T> {
	private int pageSize;
	private int pageNumber;
	private int total;
	private List<T> list;
	private int StartNumber;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getStartNumber() {
		return StartNumber;
	}
	public void setStartNumber(int startNumber) {
		StartNumber = startNumber;
	}
	
	
	
}
