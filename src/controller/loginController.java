package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new login().loginActor("member", "PPPP", "1111"));
		//System.out.println(new loginController().loginActor("supplier", "divingTest", "1234"));
		//
		//Integer readMemberNumById(String Id)
		//System.out.println(new loginController().readMemberNumById("REWQ"));
		////從廠商帳號Id去判斷廠商編號Num
		//System.out.println( new loginController().readSupplierNumById("klook"));
	}
	
	public String loginActor(String actor,String Id,String Password, boolean registerfail) {
		String message="";
		Connection conn = connection.getDB();
		

		String sqlId="";
		String sqlPassword="";
		String sql = "select * from " + connection.schema + "."+actor+" where "+actor+"Id='" + Id+"'";
		
		System.out.println(sql);
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
				//判斷帳號
//				boolean check=rs.next();
				if(rs.next()) {
					
					sqlId=rs.getString(actor+"Id");
					sqlPassword=rs.getString(actor+"Password");
					//判斷密碼
					
					if(!registerfail) {message="帳號名稱已經被人使用";
					}
					
					else if(sqlPassword.equals(Password)) {
						message="LoginSuccessfully";
						
					}else {
						message = "密碼錯誤";
					}
				}else {
					message="查無此帳號存在";
				}
				
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "SQLException";
			e.printStackTrace();
			}
		return message;
		
	}
	//從會員帳號Id去判斷會員編號Num
	public Integer readMemberNumById(String Id) {
		Integer result=0;
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".member where memberId='" + Id+"\'";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				result=rs.getInt("memberNum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	//從廠商帳號Id去判斷廠商編號Num
	public Integer readSupplierNumById(String Id) {
		Integer result=0;
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".supplier where supplierId='" + Id+"\'";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				result=rs.getInt("supplierNum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
	
}
