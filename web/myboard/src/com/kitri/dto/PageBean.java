package com.kitri.dto;

import java.util.List;

public class PageBean {
	private int cntPerPage = 10;
	private int startRow = 1;
	private int endRow = 1;
	private List<RepBoard> list;
	private int totalPage = 1;
	private int totalCnt;
	private int cntPerPageGroup = 3;
	private int startPage;
	private int endPage;
	private String url;
	private int currentPage;
	public PageBean() {
	}
	public PageBean(int cntPerPage, int totalCnt, int cntPerPageGroup, String url, int currentPage) {
		super();
		this.cntPerPage = cntPerPage;
		this.totalCnt = totalCnt;
		this.cntPerPageGroup = cntPerPageGroup;
		this.url = url;
		this.currentPage = currentPage;
		execute();
	}
	public void execute() {
		totalPage = (totalCnt % cntPerPage) > 0 ? totalCnt/cntPerPage + 1 : totalCnt/cntPerPage;
		endRow = currentPage * cntPerPage;
		startRow = endRow - (cntPerPage - 1);
		System.out.println("(int)Math.ceil(currentPage/(float)cntPerPageGroup) "+(int)Math.ceil(currentPage/(float)cntPerPageGroup));
		int currDivGroup = (int)Math.ceil(currentPage/(float)cntPerPageGroup);
		endPage = currDivGroup < 2 ? cntPerPageGroup : currDivGroup * cntPerPageGroup;
		System.out.println("endPage ---"+endPage);
		startPage = endPage - (cntPerPageGroup - 1);
		if(endPage > totalPage)
			endPage = totalPage;
		if(startPage > endPage)
			startPage = endPage;

	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public List<RepBoard> getList() {
		return list;
	}
	public void setList(List<RepBoard> list) {
		this.list = list;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getCntPerPageGroup() {
		return cntPerPageGroup;
	}
	public void setCntPerPageGroup(int cntPerPageGroup) {
		this.cntPerPageGroup = cntPerPageGroup;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
