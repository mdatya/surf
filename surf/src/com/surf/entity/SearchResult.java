package com.surf.entity;

import java.util.List;

/**
 * レスポンス全体を格納するクラス
 * @author maedatatsuya
 *
 */
public class SearchResult {
	
	private double processingTime;
	private long maxId;
	private String maxIdStr;
	private long sinceId;
	private String sinceIdStr;
	private String nextUrl;
	private String refreshUrl;
	private int page;
	private String query;
	private int resultsPerPage;
	private List<TwitStatus> results;
	
	public double getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(double processingTime) {
		this.processingTime = processingTime;
	}
	public long getMaxId() {
		return maxId;
	}
	public void setMaxId(long maxId) {
		this.maxId = maxId;
	}
	public String getMaxIdStr() {
		return maxIdStr;
	}
	public void setMaxIdStr(String maxIdStr) {
		this.maxIdStr = maxIdStr;
	}
	public long getSinceId() {
		return sinceId;
	}
	public void setSinceId(long sinceId) {
		this.sinceId = sinceId;
	}
	public String getSinceIdStr() {
		return sinceIdStr;
	}
	public void setSinceIdStr(String sinceIdStr) {
		this.sinceIdStr = sinceIdStr;
	}
	public String getNextUrl() {
		return nextUrl;
	}
	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}
	public String getRefreshUrl() {
		return refreshUrl;
	}
	public void setRefreshUrl(String refreshUrl) {
		this.refreshUrl = refreshUrl;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getResultsPerPage() {
		return resultsPerPage;
	}
	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}
	public List<TwitStatus> getResults() {
		return results;
	}
	public void setResults(List<TwitStatus> results) {
		this.results = results;
	}
}
