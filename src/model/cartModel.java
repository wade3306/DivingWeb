package model;

import java.util.Date;

public class cartModel{
	private String tourName;
	private Integer tourNum;
	private String tourDate;
	private Integer tourPrice;
	private Integer tourPeople;
	private Integer tourTotalPrice;//增加行程的總價=價格*人數
	
	public cartModel() {
		super();
	}
	
	public Integer getTourTotalPrice() {
		return tourTotalPrice;
	}
	
	public void setTourTotalPrice(Integer tourTotalPrice) {
		this.tourTotalPrice = tourTotalPrice;
	}
	
	
	public cartModel(String tourName, Integer tourNum, String tourDate, Integer tourPrice, Integer tourPeople) {
		super();
		this.tourName = tourName;
		this.tourNum = tourNum;
		this.tourDate = tourDate;
		this.tourPrice = tourPrice;
		this.tourPeople = tourPeople;
		tourTotalPrice=this.tourPrice*this.tourPeople;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public Integer getTourNum() {
		return tourNum;
	}
	public void setTourNum(Integer tourNum) {
		this.tourNum = tourNum;
	}
	public String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	public Integer getTourPrice() {
		return tourPrice;
	}
	public void setTourPrice(Integer tourPrice) {
		this.tourPrice = tourPrice;
	}
	public Integer getTourPeople() {
		return tourPeople;
	}
	public void setTourPeople(Integer tourPeople) {
		this.tourPeople = tourPeople;
	}
	
}
