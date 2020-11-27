package model;

import java.util.ArrayList;
import java.util.Date;

public class orderModel {
	private Integer orderNum;
	private Date orderDate;
	private String orderPayMethod;
	private Integer orderTotalPrice;
	private ArrayList<orderDetailModel> orderDetail; 
	private Integer memberNum;
	
	public orderModel() {
		super();
	}

	public orderModel(Date orderDate, String orderPayMethod, Integer orderTotalPrice,
			ArrayList<orderDetailModel> orderDetail, Integer memberNum) {
		super();
		this.orderDate = orderDate;
		this.orderPayMethod = orderPayMethod;
		this.orderTotalPrice = orderTotalPrice;
		this.orderDetail = orderDetail;
		this.memberNum = memberNum;
	}

	public orderModel(Integer orderNum, Date orderDate, String orderPayMethod, Integer orderTotalPrice,
			ArrayList<orderDetailModel> orderDetail, Integer memberNum) {
		super();
		this.orderNum = orderNum;
		this.orderDate = orderDate;
		this.orderPayMethod = orderPayMethod;
		this.orderTotalPrice = orderTotalPrice;
		this.orderDetail = orderDetail;
		this.memberNum = memberNum;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPayMethod() {
		return orderPayMethod;
	}

	public void setOrderPayMethod(String orderPayMethod) {
		this.orderPayMethod = orderPayMethod;
	}

	public Integer getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Integer orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public ArrayList<orderDetailModel> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ArrayList<orderDetailModel> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}
}
