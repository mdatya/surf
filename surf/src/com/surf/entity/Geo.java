package com.surf.entity;

/**
 * 位置情報格納クラス
 * @author maedatatsuya
 *
 */
public class Geo {
	private double lat;
	private double lng;
	private String type;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
