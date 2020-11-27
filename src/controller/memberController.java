package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.memberModel;

public class memberController implements memberInterface {
	

	public static void main(String[] args) {
		// 測試區
//		memberController mc = new memberController();
		// 測試新增
		// memberModel mm=new memberModel("user04","5271","vaan",new Date(),"vaan@gmail.com","0900000000");
		// mc.create(mm);
		// 測試查詢
		// memberModel mm=mc.read(4);
		// System.out.println(mm.getMemberNum()+","+mm.getMemberId()+","+
		// mm.getMemberPassword()+","+mm.getMemberName()+","+mm.getMemberBirth()+","+mm.getMemberMail()+","+mm.getMemberPhone());
		// 測試更新
		// memberModel mm=new memberModel(3,"user02","1234","vaaaan",new Date(),"5271@gmail.com","0900000000");
		// mc.update(mm);
		// 測試刪除
		// mc.delete(2);
	}

	@Override
	public boolean create(memberModel mm) {
		Connection conn = connection.getDB();
		String sql = "insert into " + connection.schema
				+ ".member (memberId,memberPassword,memberName,memberBirth,memberMail,memberPhone) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mm.getMemberId());
			ps.setString(2, mm.getMemberPassword());
			ps.setString(3, mm.getMemberName());
			ps.setDate(4,new java.sql.Date( mm.getMemberBirth().getTime()));
			ps.setString(5, mm.getMemberMail());
			ps.setString(6, mm.getMemberPhone());			
			ps.execute();
		} catch (SQLException e) {
			System.out.println("memberCreate Fail");
			
			e.printStackTrace();
			return false;
		}
		System.out.println("memberCreate Success");
		return true;
	}

	@Override
	public memberModel read(Integer num) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".member where memberNum=" + num;
		memberModel mm = new memberModel();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			mm.setMemberNum(rs.getInt("memberNum"));
			mm.setMemberId(rs.getString("memberId"));
			mm.setMemberPassword(rs.getString("memberPassword"));
			mm.setMemberName(rs.getString("memberName"));
			mm.setMemberBirth(rs.getDate("memberBirth"));
			mm.setMemberMail(rs.getString("memberMail"));
			mm.setMemberPhone(rs.getString("memberPhone"));
		} catch (SQLException e) {
			System.out.println("memberRead Fail");
			e.printStackTrace();
		}
		return mm;
	}

	@Override
	public boolean update(memberModel mm) {
		Connection conn = connection.getDB();
		String sql = "update " + connection.schema
				+ ".member set memberId=?,memberPassword=?,memberName=?,memberBirth=?,memberMail=?,memberPhone=? where memberNum="
				+ mm.getMemberNum();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mm.getMemberId());
			ps.setString(2, mm.getMemberPassword());
			ps.setString(3, mm.getMemberName());
			ps.setDate(4,new java.sql.Date( mm.getMemberBirth().getTime()));
			ps.setString(5, mm.getMemberMail());
			ps.setString(6, mm.getMemberPhone());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("memberUpdate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("memberUpdate Success");
		return true;
	}

	@Override
	public boolean delete(Integer num) {
		Connection conn = connection.getDB();
        String sql = "delete from "+connection.schema+".member where memberNum="+num;
        try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("memberDelete Fail");
			e.printStackTrace();			
			return false;
		}
        System.out.println("memberDelete Success");
		return true;
	}

}
