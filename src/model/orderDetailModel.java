package model;
import java.util.ArrayList;
import java.util.Date;

public class orderDetailModel {
	private Integer orderDetailNum;
	private Integer tourNum; 
	private Date orderDetailDate;
	private Integer orderDetailPeople;
	
	public orderDetailModel() {
		super();
	}
	public orderDetailModel(Integer orderDetailNum, Integer tourNum, Date orderDetailDate, Integer orderDetailPeople) {
		super();
		this.orderDetailNum = orderDetailNum;
		this.tourNum = tourNum;
		this.orderDetailDate = orderDetailDate;
		this.orderDetailPeople = orderDetailPeople;
	}
	public orderDetailModel(Integer tourNum, Date orderDetailDate, Integer orderDetailPeople) {
		super();
		this.tourNum = tourNum;
		this.orderDetailDate = orderDetailDate;
		this.orderDetailPeople = orderDetailPeople;
	}
	public Integer getOrderDetailNum() {
		return orderDetailNum;
	}
	public void setOrderDetailNum(Integer orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}
	public Integer getTourNum() {
		return tourNum;
	}
	public void setTourNum(Integer tourNum) {
		this.tourNum = tourNum;
	}
	public Date getOrderDetailDate() {
		return orderDetailDate;
	}
	public void setOrderDetailDate(Date orderDetailDate) {
		this.orderDetailDate = orderDetailDate;
	}
	public Integer getOrderDetailPeople() {
		return orderDetailPeople;
	}
	public void setOrderDetailPeople(Integer orderDetailPeople) {
		this.orderDetailPeople = orderDetailPeople;
	}
	
}