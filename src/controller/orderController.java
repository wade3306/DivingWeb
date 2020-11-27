package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import model.orderDetailModel;
import model.orderModel;

public class orderController implements orderInterface{

	public static void main(String[] args) {
		// 測試區
//		orderController oc = new orderController();

		// 測試新增
//		 ArrayList<orderDetailModel> a=new
//		 ArrayList<orderDetailModel>(Arrays.asList(new orderDetailModel(1,new
//		 Date(),1),new orderDetailModel(2,new Date(),5))) ;
//		 orderModel om=new orderModel(new Date(),"magicCard",2000,a,1);
//		 oc.create(om);

		// 測試查詢
//				ArrayList<orderModel> test = oc.supplierRead(1);
//				for (orderModel x : test) {
//					System.out.print(x.getOrderNum() + ",");
//					System.out.print(x.getMemberNum() + ",");
//					System.out.print(x.getOrderPayMethod() + ",");
//					System.out.print(x.getOrderTotalPrice() + ",");
//					System.out.print(x.getOrderDate() + ",");
//					for (orderDetailModel y : x.getOrderDetail()) {
//						System.out.print(y.getTourNum() + ",");
//						System.out.print(y.getOrderDetailDate() + ",");
//						System.out.print(y.getOrderDetailPeople());
//					}
//					System.out.println();
//				}

		// 測試更新
//				ArrayList<orderDetailModel> odm=new ArrayList<orderDetailModel>(Arrays.asList
//						(new orderDetailModel(3,2,new Date(),4),
//						 new orderDetailModel(4,2,new Date(),5))) ;
//				orderModel om=new orderModel(4,new Date(),"magicCard00",200000,odm,1);
//				oc.update(om);

		// 測試刪除
		// oc.deleteOrder(2);
//		oc.deleteOrderDetail(2);
	}

	@Override
	public boolean create(orderModel om) {
		Connection conn = connection.getDB();
		String sql = "insert into " + connection.schema
				+ ".order (memberNum,orderDate,orderPayMethod,orderTotalPrice) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, om.getMemberNum());
			ps.setDate(2, new java.sql.Date(om.getOrderDate().getTime()));
			ps.setString(3, om.getOrderPayMethod());
			ps.setInt(4, om.getOrderTotalPrice());
			ps.execute();
			sql = "select * from " + connection.schema + ".order";
			ResultSet rs = ps.executeQuery(sql);
			rs.last();
			for (orderDetailModel od : om.getOrderDetail()) {
				sql = "insert into " + connection.schema
						+ ".orderdetail (orderNum,orderDetailDate,tourNum,orderDetailPeople) values(?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, rs.getInt("orderNum"));
				ps.setDate(2, new java.sql.Date(od.getOrderDetailDate().getTime()));
				ps.setInt(3, od.getTourNum());
				ps.setInt(4, od.getOrderDetailPeople());
				ps.execute();
			}
		} catch (SQLException e) {
			System.out.println("orderCreate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("orderCreate Success");
		return true;
	}

	@Override
	public ArrayList<orderModel> memberRead(Integer memberNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".order where memberNum=" + memberNum;
		ArrayList<orderModel> aom = new ArrayList<orderModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				orderModel om = new orderModel();
				om.setOrderNum(rs.getInt("orderNum"));
				om.setOrderDate(rs.getDate("orderDate"));
				om.setOrderPayMethod(rs.getString("orderPayMethod"));
				om.setOrderTotalPrice(rs.getInt("orderTotalPrice"));
				om.setMemberNum(rs.getInt("memberNum"));
				Connection conn2 = connection.getDB();
				String sql2 = "select * from " + connection.schema + ".orderDetail where orderNum=" + om.getOrderNum();
				Statement s2 = conn2.createStatement();
				ResultSet rs2 = s2.executeQuery(sql2);
				ArrayList<orderDetailModel> aodm = new ArrayList<orderDetailModel>();
				while (rs2.next()) {
					orderDetailModel odm = new orderDetailModel();
					odm.setTourNum(rs2.getInt("tourNum"));
					odm.setOrderDetailDate(rs2.getDate("orderDetailDate"));
					odm.setOrderDetailPeople(rs2.getInt("orderDetailPeople"));
					aodm.add(odm);
				}
				om.setOrderDetail(aodm);
				aom.add(om);
			}

		} catch (SQLException e) {
			System.out.println("orderMemberRead Fail");
			e.printStackTrace();
		}
		System.out.println("orderMemberRead Success");
		return aom;
	}

	@Override
	public ArrayList<orderModel> supplierRead(Integer tourNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".orderDetail where tourNum=" + tourNum;
		ArrayList<Integer> ai = new ArrayList<Integer>();
		ArrayList<orderModel> aom = new ArrayList<orderModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next())
				ai.add(rs.getInt("orderNum"));
			for (Integer orderNum : ai) {
				sql = "select * from " + connection.schema + ".order where orderNum=" + orderNum;
				s = conn.createStatement();
				rs = s.executeQuery(sql);
				while (rs.next()) {
					orderModel om = new orderModel();
					om.setOrderNum(rs.getInt("orderNum"));
					om.setOrderDate(rs.getDate("orderDate"));
					om.setOrderPayMethod(rs.getString("orderPayMethod"));
					om.setOrderTotalPrice(rs.getInt("orderTotalPrice"));
					om.setMemberNum(rs.getInt("memberNum"));
					Connection conn2 = connection.getDB();
					String sql2 = "select * from " + connection.schema + ".orderDetail where orderNum="
							+ om.getOrderNum();
					Statement s2 = conn2.createStatement();
					ResultSet rs2 = s2.executeQuery(sql2);
					ArrayList<orderDetailModel> aodm = new ArrayList<orderDetailModel>();
					while (rs2.next()) {
						orderDetailModel odm = new orderDetailModel();
						odm.setOrderDetailNum(rs2.getInt("orderDetailNum"));
						odm.setTourNum(rs2.getInt("tourNum"));
						odm.setOrderDetailDate(rs2.getDate("orderDetailDate"));
						odm.setOrderDetailPeople(rs2.getInt("orderDetailPeople"));
						aodm.add(odm);
					}
					om.setOrderDetail(aodm);
					aom.add(om);
				}
			}
		} catch (SQLException e) {
			System.out.println("orderSupplierRead Fail");
			e.printStackTrace();
		}
		System.out.println("orderMemberRead Success");
		return aom;
	}

	@Override
	public boolean update(orderModel om) {
		Connection conn = connection.getDB();
		String sql = "update " + connection.schema
				+ ".order set memberNum=?,orderDate=?,orderPayMethod=?,orderTotalPrice=? where orderNum="
				+ om.getOrderNum();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, om.getMemberNum());
			ps.setDate(2, new java.sql.Date(om.getOrderDate().getTime()));
			ps.setString(3, om.getOrderPayMethod());
			ps.setInt(4, om.getOrderTotalPrice());
			ps.execute();
			for (orderDetailModel od : om.getOrderDetail()) {
				String sql2 = "update " + connection.schema
						+ ".orderdetail set orderNum=?,orderDetailDate=?,tourNum=?,orderDetailPeople=? where orderDetailNum="
						+ od.getOrderDetailNum();
//				System.out.println(" od.getOrderDetailNum()="+ od.getOrderDetailNum());
				Connection conn2 = connection.getDB();
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, om.getOrderNum());
				ps2.setDate(2, new java.sql.Date(od.getOrderDetailDate().getTime()));
				ps2.setInt(3, od.getTourNum());
				ps2.setInt(4, od.getOrderDetailPeople());
				ps2.execute();
			}
		} catch (SQLException e) {
			System.out.println("orderUpdate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("orderUpdate Success");
		return true;
	}

	@Override // 資料庫直接同時刪除比較方便
	public boolean deleteOrder(Integer orderNum) {
		Connection conn = connection.getDB();
		String sql = "delete from " + connection.schema + ".order where orderNum=" + orderNum;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("orderDelete Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("orderDelete Success");
		return true;
	}

	@Override
	public boolean deleteOrderDetail(Integer orderDetailNum) {
		Connection conn = connection.getDB();
		String sql = "delete from " + connection.schema + ".orderdetail where orderDetailNum=" + orderDetailNum;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("orderDetailDelete Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("orderDetailDelete Success");
		return true;
	}

}