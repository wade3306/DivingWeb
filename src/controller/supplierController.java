package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.supplierModel;

public class supplierController implements supplierInterface {

	public static void main(String[] args) {
//		supplierController sc = new supplierController();
		// 測試區
		// 測試新增
//		 supplierModel sm= new supplierModel("store5","9999","便當","A@a","22312");
//		 sc.create(sm);
		// 測試查詢
		// supplierModel sm = sc.read(1);
		// System.out.println(sm.getSupplierNum() + "," + sm.getSupplierId() + "," + sm.getSupplierPassword() + ","
		//		+ sm.getSupplierName() + "," + sm.getSupplierMail() + "," + sm.getSupplierPhone());
		// 測試更新
		// supplierModel sm= new
		// supplierModel(3,"store3","0000000","好餓喔","123@123","12345678");
		// sc.update(sm);
		// 測試刪除
		// sc.delete(5);
	}

	@Override
	public boolean create(supplierModel sm) {
		Connection conn = connection.getDB();
		String sql = "insert into " + connection.schema
				+ ".supplier (supplierId,supplierPassword,supplierName,supplierMail,supplierPhone) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sm.getSupplierId());
			ps.setString(2, sm.getSupplierPassword());
			ps.setString(3, sm.getSupplierName());
			ps.setString(4, sm.getSupplierMail());
			ps.setString(5, sm.getSupplierPhone());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("supplierCreate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("supplierCreate Success");
		return true;
	}

	@Override
	public supplierModel read(Integer supplierNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".supplier where supplierNum=" + supplierNum;
		supplierModel sm = new supplierModel();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			sm.setSupplierNum(rs.getInt("supplierNum"));
			sm.setSupplierId(rs.getString("supplierId"));
			sm.setSupplierPassword(rs.getString("supplierPassword"));
			System.out.println("Password="+rs.getString("supplierPassword"));
			sm.setSupplierName(rs.getString("supplierName"));
			sm.setSupplierMail(rs.getString("supplierMail"));
			sm.setSupplierPhone(rs.getString("supplierPhone"));
		} catch (SQLException e) {
			System.out.println("supplierRead Fail");
			e.printStackTrace();
		}
		System.out.println("supplierRead Success");
		return sm;
	}

	@Override
	public boolean update(supplierModel sm) {
		Connection conn = connection.getDB();
		String sql = "update " + connection.schema
				+ ".supplier set supplierId=?,supplierPassword=?,supplierName=?,supplierMail=?,supplierPhone=? where supplierNum="
				+ sm.getSupplierNum();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sm.getSupplierId());
			ps.setString(2, sm.getSupplierPassword());
			ps.setString(3, sm.getSupplierName());
			ps.setString(4, sm.getSupplierMail());
			ps.setString(5, sm.getSupplierPhone());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("supplierUpdate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("supplierUpdate Success");
		return true;
	}

	@Override
	public boolean delete(Integer supplierNum) {
		Connection conn = connection.getDB();
		String sql = "delete from " + connection.schema + ".supplier where supplierNum=" + supplierNum;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("supplierDelete Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("supplierDelete Success");
		return true;
	}

}
