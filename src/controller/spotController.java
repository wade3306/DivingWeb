package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.spotModel;

public class spotController implements spotInterface {

	public static void main(String[] args) {

		spotController sc = new spotController();
//測試查詢(ID)
//		spotModel sm = sc.readId(1);
//		System.out.println(sm.getSpotNum() + "," + sm.getSpotName() + "," + sm.getSpotCity() + "," + sm.getSpotArea()
//				+ "," + sm.getSpotType() + "," + sm.getSpotOther());

//測試查詢(全部、部分條件(潛點、城市、地區))
//		ArrayList<spotModel> test = sc.readSpot(null, null, null);
//		ArrayList<spotModel> test = sc.readSpot(null, "'屏東'", null);
//		ArrayList<spotModel> test = sc.readSpot(null, "'新北'", "'瑞芳'");
//		for (spotModel sm : test) {
//			System.out.println(sm.getSpotNum() + "," + sm.getSpotName() + "," + sm.getSpotCity() + ","
//					+ sm.getSpotArea() + "," + sm.getSpotType() + "," + sm.getSpotOther());
//		}
	}

	Connection conn = connection.getDB();

	public spotModel readId(Integer num) {
		String sql = "select * from " + connection.schema + ".spot where spotNum=" + num;
		spotModel sm = new spotModel();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			sm.setSpotNum(rs.getInt("spotNum"));
			sm.setSpotName(rs.getString("spotName"));
			sm.setSpotCity(rs.getString("spotCity"));
			sm.setSpotArea(rs.getString("spotArea"));
			sm.setSpotType(rs.getString("spotType"));
			sm.setSpotOther(rs.getString("spotOther"));
		} catch (SQLException e) {
			System.out.println("memberRead Fail");
			e.printStackTrace();
		}
		return sm;

	}

	@Override
	public ArrayList<spotModel> readSpot(String spotCity, String spotArea) {
		String sql = "select * from " + connection.schema + ".spot where spotnum>0";
		if (spotCity != null)
			sql += "&&spotCity='" + spotCity+"'";
		if (spotArea != null)
			sql += "&&spotArea='" + spotArea+"'";
		ArrayList<spotModel> asm = new ArrayList<spotModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				spotModel sm = new spotModel();
				sm.setSpotNum(rs.getInt("spotNum"));
				sm.setSpotName(rs.getString("spotName"));
				sm.setSpotCity(rs.getString("spotCity"));
				sm.setSpotArea(rs.getString("spotArea"));
				sm.setSpotType(rs.getString("spotType"));
				sm.setSpotOther(rs.getString("spotOther"));
				asm.add(sm);
			}
		} catch (SQLException e) {
			System.out.println("memberRead Fail");
			e.printStackTrace();
		}
		return asm;
	}

	@Override
	public ArrayList<spotModel> readAllSpot() {
		String sql = "select * from " + connection.schema + ".spot ";
		ArrayList<spotModel> allsopt = new ArrayList<spotModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				spotModel sm = new spotModel();
				sm.setSpotNum(rs.getInt("spotNum"));
				sm.setSpotName(rs.getString("spotName"));
				sm.setSpotCity(rs.getString("spotCity"));
				sm.setSpotArea(rs.getString("spotArea"));
				sm.setSpotType(rs.getString("spotType"));
				sm.setSpotOther(rs.getString("spotOther"));
				allsopt.add(sm);
			}
			
		} catch (SQLException e) {
			System.out.println("memberRead Fail");
			e.printStackTrace();
		}
		return allsopt;
	}

}
