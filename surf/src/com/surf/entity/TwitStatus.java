package com.surf.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * １ツイート分の情報を格納するクラス
 * @author maedatatsuya
 *
 */
public class TwitStatus {
	private Date createdDate;
	private String fromUser;
	private long fromUserId;
	private String fromUserIdStr;
	private String fromUserName;
	private String toUser;
	private long toUserId;
	private String toUserIdStr;
	private String toUserName;
	private long id;
	private String idStr;
	private String isoLangCd;
	private String profImgUrl;
	private String ProfImgUrlHttps;
	private String source;
	private String text;
	private Geo geo;
	private List<Map<String, String>> urlMapList;
	
	public Date getCreatedDate(){
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUserIdStr() {
		return fromUserIdStr;
	}

	public void setFromUserIdStr(String fromUserIdStr) {
		this.fromUserIdStr = fromUserIdStr;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public long getToUserId() {
		return toUserId;
	}

	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}

	public String getToUserIdStr() {
		return toUserIdStr;
	}

	public void setToUserIdStr(String toUserIdStr) {
		this.toUserIdStr = toUserIdStr;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getIsoLangCd() {
		return isoLangCd;
	}

	public void setIsoLangCd(String isoLangCd) {
		this.isoLangCd = isoLangCd;
	}

	public String getProfImgUrl() {
		return profImgUrl;
	}

	public void setProfImgUrl(String profImgUrl) {
		this.profImgUrl = profImgUrl;
	}

	public String getProfImgUrlHttps() {
		return ProfImgUrlHttps;
	}

	public void setProfImgUrlHttps(String profImgUrlHttps) {
		ProfImgUrlHttps = profImgUrlHttps;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public List<Map<String, String>> getUrlMapList() {
		return urlMapList;
	}

	public void setUrlMapList(List<Map<String, String>> urlMap) {
		this.urlMapList = urlMap;
	}
}