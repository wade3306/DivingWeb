package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.tourModel;
import model.tourspotModel;

public class tourController implements tourInterface{

	public static void main(String[] args) {
		// 測試區
//				tourController tc = new tourController();

				// 測試新增
				/*ArrayList<tourspotModel> a=new ArrayList<tourspotModel>
				(Arrays.asList(new tourspotModel(2),new tourspotModel(58),new tourspotModel(7))) ;
				tourModel tm=new tourModel("玩很小",501,2,"吃吃吃","汽車大飯店","汽車","上架",1,a);
				tc.create(tm);*/
				//測試查詢
//				ArrayList<tourModel> test = tc.tourRead(-1, -1, -1);
//				for (tourModel x : test) {
//					System.out.print(x.getTourNum() + ",");
//					System.out.print(x.getSupplierNum() + ",");
//					System.out.print(x.getTourName() + ",");
//					System.out.print(x.getTourPrice() + ",");
//					System.out.print(x.getTourSize() + ",");
//					System.out.print(x.getTourFood() + ",");
//					System.out.print(x.getTourMotel() + ",");
//					System.out.print(x.getTourTraffic() + ",");
//					System.out.print(x.getTourShow() + ",");
//					for (tourspotModel y : x.getTourspot()) {
//						System.out.print(y.getTourspotNum() + ",");
//						System.out.print(y.getSpotNum());
//					}
//					System.out.println();
//				}
				//測試查詢
//				ArrayList<tourModel> test = tc.tourRead(1);
//				for (tourModel x : test) {
//					System.out.print(x.getTourNum() + ",");
//					System.out.print(x.getSupplierNum() + ",");
//					System.out.print(x.getTourName() + ",");
//					System.out.print(x.getTourPrice() + ",");
//					System.out.print(x.getTourSize() + ",");
//					System.out.print(x.getTourFood() + ",");
//					System.out.print(x.getTourMotel() + ",");
//					System.out.print(x.getTourTraffic() + ",");
//					System.out.print(x.getTourShow() + ",");
//					for (tourspotModel y : x.getTourspot()) {
//						System.out.print(y.getTourspotNum() + ",");
//						System.out.print(y.getSpotNum());
//						System.out.print(",");
//					}
//					System.out.println();
//				}
				//測試查詢
//				ArrayList<tourModel> test = tc.supplierRead(1);
//				for (tourModel x : test) {
//					System.out.print(x.getTourNum() + ",");
//					System.out.print(x.getSupplierNum() + ",");
//					System.out.print(x.getTourName() + ",");
//					System.out.print(x.getTourPrice() + ",");
//					System.out.print(x.getTourSize() + ",");
//					System.out.print(x.getTourFood() + ",");
//					System.out.print(x.getTourMotel() + ",");
//					System.out.print(x.getTourTraffic() + ",");
//					System.out.print(x.getTourShow() + ",");
//					for (tourspotModel y : x.getTourspot()) {
//						System.out.print(y.getTourspotNum() + ",");
//						System.out.print(y.getSpotNum());
//						System.out.print(",");
//					}
//					System.out.println();
//				}
//				
				//測試update
//				ArrayList<tourspotModel> a=new ArrayList<tourspotModel>
//				(Arrays.asList(new tourspotModel(1,3),new tourspotModel(2,20),new tourspotModel(4,55))) ;
//				tourModel tm=new tourModel(5,"玩很大",501,2,"吃吃吃2","汽車大飯店2","汽車2","下架",1,a);
//				
//				tc.update(tm);
				//測試刪除deletetour
				//tc.deletetour(6);
				
				//測試刪除deletetourspot
				//tc.deletetourspot(9);
				}


	@Override
	public boolean create(tourModel tm) {
		Connection conn = connection.getDB();
		String sql = "insert into " + connection.schema
				+ ".tour (supplierNum,tourName,tourPrice,tourSize,tourFood,tourMotel,tourTraffic,tourShow) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tm.getSupplierNum());
			ps.setString(2, tm.getTourName());
			ps.setInt(3, tm.getTourPrice());
			ps.setInt(4, tm.getTourSize());
			ps.setString(5, tm.getTourFood());
			ps.setString(6, tm.getTourMotel());
			ps.setString(7, tm.getTourTraffic());
			ps.setString(8, tm.getTourShow());
			ps.execute();
			sql = "select * from " + connection.schema + ".tour";
			ResultSet rs = ps.executeQuery(sql);
			rs.last();
			for (tourspotModel tsm : tm.getTourspot()) {
				sql = "insert into " + connection.schema + ".tourspot (tourNum,spotNum) values(?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, rs.getInt("tourNum"));
				ps.setInt(2, tsm.getSpotNum());
				ps.execute();
			}
		} catch (SQLException e) {
			System.out.println("tourCreate Fail");
			e.printStackTrace();
			return false;
		}
		System.out.println("tourCreate Success");
		return true;
	}

	@Override
	public ArrayList<tourModel> tourRead(Integer tourSize, Integer tourPriceMin, Integer tourPriceMax) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".tour where tourNum>0 ";
		if(tourSize>0)sql+="&&tourSize="+tourSize;
		if(tourPriceMin>0)sql+="&&tourPrice>="+tourPriceMin;
		if(tourPriceMax>0)sql+="&&tourPrice<="+tourPriceMax;
		ArrayList<tourModel> atm = new ArrayList<tourModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				tourModel tm = new tourModel();
				tm.setTourNum(rs.getInt("tourNum"));
				tm.setSupplierNum(rs.getInt("supplierNum"));
				tm.setTourName(rs.getString("tourName"));
				tm.setTourPrice(rs.getInt("tourPrice"));
				tm.setTourSize(rs.getInt("tourSize"));
				tm.setTourFood(rs.getString("tourFood"));
				tm.setTourMotel(rs.getString("tourMotel"));
				tm.setTourTraffic(rs.getString("tourTraffic"));
				tm.setTourShow(rs.getString("tourShow"));
				Connection conn2 = connection.getDB();
				String sql2 = "select * from " + connection.schema + ".tourSpot where tourNum=" + tm.getTourNum();
				Statement s2 = conn2.createStatement();
				ResultSet rs2 = s2.executeQuery(sql2);
				ArrayList<tourspotModel> atsm = new ArrayList<tourspotModel>();
				while (rs2.next()) {
					tourspotModel tsm = new tourspotModel();
					tsm.setTourspotNum(rs2.getInt("tourspotNum"));
					tsm.setSpotNum(rs2.getInt("spotNum"));
					atsm.add(tsm);
				}
				tm.setTourspot(atsm);
				atm.add(tm);
			}

		} catch (SQLException e) {
			System.out.println("tourRead Fail");
			e.printStackTrace();
		}
		System.out.println("tourRead Success");
		return atm;
	}
	
	public tourModel tourNumRead(Integer tourNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".tour where tourNum="+tourNum;
		tourModel tm = new tourModel();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			tm.setTourNum(rs.getInt("tourNum"));
			tm.setSupplierNum(rs.getInt("supplierNum"));
			tm.setTourName(rs.getString("tourName"));
			tm.setTourPrice(rs.getInt("tourPrice"));
			tm.setTourSize(rs.getInt("tourSize"));
			tm.setTourFood(rs.getString("tourFood"));
			tm.setTourMotel(rs.getString("tourMotel"));
			tm.setTourTraffic(rs.getString("tourTraffic"));
			tm.setTourShow(rs.getString("tourShow"));
			Connection conn2 = connection.getDB();
			String sql2 = "select * from " + connection.schema + ".tourSpot where tourNum=" + tm.getTourNum();
			Statement s2 = conn2.createStatement();
			ResultSet rs2 = s2.executeQuery(sql2);
			ArrayList<tourspotModel> atsm = new ArrayList<tourspotModel>();
			while (rs2.next()) {
				tourspotModel tsm = new tourspotModel();
				tsm.setTourspotNum(rs2.getInt("tourspotNum"));
				tsm.setSpotNum(rs2.getInt("spotNum"));
				atsm.add(tsm);
			}
			tm.setTourspot(atsm);			
		} catch (SQLException e) {
			System.out.println("tourRead Fail");
			e.printStackTrace();
		}
		System.out.println("tourRead Success");
		return tm;
	}
	
	public ArrayList<Integer> tourNum() {
		Connection conn = connection.getDB();
		String sql = "select tourNum from " + connection.schema + ".tour";
		ArrayList<Integer> atn = new ArrayList<Integer>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				atn.add(rs.getInt("tourNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atn;
	}
	
	public Integer readLastTourNum() {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".tour";
		Statement s;
		Integer lastNum=0;
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			rs.last();
			lastNum=rs.getInt("tourNum");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lastNum;
	}
	
	public ArrayList<tourModel> tournumRead(Integer num) {
		ArrayList<tourModel> atm = new ArrayList<tourModel>();
		ArrayList<Integer> atn = new ArrayList<Integer>();
		ArrayList<Integer> atn2 = new ArrayList<Integer>();
		atn = tourNum();
		Collections.shuffle(atn);//打亂

		for (int i = 0; i < num; i++) {//擷取num個
			atn2.add(atn.get(i));
		}

		for (Integer i : atn2) {
			Connection conn = connection.getDB();
			String sql = "select * from " + connection.schema + ".tour where tourNum=" + i;

			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					tourModel tm = new tourModel();
					tm.setTourNum(rs.getInt("tourNum"));
					tm.setSupplierNum(rs.getInt("supplierNum"));
					tm.setTourName(rs.getString("tourName"));
					tm.setTourPrice(rs.getInt("tourPrice"));
					tm.setTourSize(rs.getInt("tourSize"));
					tm.setTourFood(rs.getString("tourFood"));
					tm.setTourMotel(rs.getString("tourMotel"));
					tm.setTourTraffic(rs.getString("tourTraffic"));
					tm.setTourShow(rs.getString("tourShow"));
					atm.add(tm);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return atm;
	}

	@Override
	public ArrayList<tourModel> tourRead(Integer spotNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".tourspot where spotNum="+spotNum;
		ArrayList<tourModel> atm = new ArrayList<tourModel>();
		try {
			Statement s=conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Integer> a=new ArrayList<Integer>();
			while (rs.next()) {
				a.add(rs.getInt("tourNum"));
			}
			for(Integer x:a) {
				Connection conn2 = connection.getDB();
				String sql2 = "select * from " + connection.schema + ".tour where tourNum="+x;	
					Statement s2 = conn2.createStatement();
					ResultSet rs2 = s2.executeQuery(sql2);
					while (rs2.next()) {
						tourModel tm = new tourModel();
						tm.setTourNum(rs2.getInt("tourNum"));
						tm.setSupplierNum(rs2.getInt("supplierNum"));
						tm.setTourName(rs2.getString("tourName"));
						tm.setTourPrice(rs2.getInt("tourPrice"));
						tm.setTourSize(rs2.getInt("tourSize"));
						tm.setTourFood(rs2.getString("tourFood"));
						tm.setTourMotel(rs2.getString("tourMotel"));
						tm.setTourTraffic(rs2.getString("tourTraffic"));
						tm.setTourShow(rs2.getString("tourShow"));
						Connection conn3 = connection.getDB();
						String sql3 = "select * from " + connection.schema + ".tourSpot where tourNum=" + tm.getTourNum();
						Statement s3 = conn3.createStatement();
						ResultSet rs3 = s3.executeQuery(sql3);
						ArrayList<tourspotModel> atsm = new ArrayList<tourspotModel>();
						while (rs3.next()) {
							tourspotModel tsm = new tourspotModel();
							tsm.setTourspotNum(rs3.getInt("tourspotNum"));
							tsm.setSpotNum(rs3.getInt("spotNum"));
							atsm.add(tsm);
						}
						tm.setTourspot(atsm);
						atm.add(tm);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atm;
	}

	@Override
	public ArrayList<tourModel> supplierRead(Integer supplierNum) {
		Connection conn = connection.getDB();
		String sql = "select * from " + connection.schema + ".tour where supplierNum="+supplierNum;
		ArrayList<tourModel> atm = new ArrayList<tourModel>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				tourModel tm = new tourModel();
				tm.setTourNum(rs.getInt("tourNum"));
				tm.setSupplierNum(rs.getInt("supplierNum"));
				tm.setTourName(rs.getString("tourName"));
				tm.setTourPrice(rs.getInt("tourPrice"));
				tm.setTourSize(rs.getInt("tourSize"));
				tm.setTourFood(rs.getString("tourFood"));
				tm.setTourMotel(rs.getString("tourMotel"));
				tm.setTourTraffic(rs.getString("tourTraffic"));
				tm.setTourShow(rs.getString("tourShow"));
				Connection conn2 = connection.getDB();
				String sql2 = "select * from " + connection.schema + ".tourSpot where tourNum=" + tm.getTourNum();
				Statement s2 = conn2.createStatement();
				ResultSet rs2 = s2.executeQuery(sql2);
				ArrayList<tourspotModel> atsm = new ArrayList<tourspotModel>();
				while (rs2.next()) {
					tourspotModel tsm = new tourspotModel();
					tsm.setTourspotNum(rs2.getInt("tourspotNum"));
					tsm.setSpotNum(rs2.getInt("spotNum"));
					atsm.add(tsm);
				}
				tm.setTourspot(atsm);
				atm.add(tm);
			}

		} catch (SQLException e) {
			System.out.println("supplierRead Fail");
			e.printStackTrace();
		}
		System.out.println("supplierRead Success");
		return atm;
	}
	
	@Override
	public boolean update(tourModel tm) {
		Connection conn = connection.getDB();
		String sql = "update " + connection.schema
				+ ".tour  set supplierNum=?, tourName=?, tourPrice=?, tourSize=?, tourFood=?, tourMotel=?, tourTraffic=?, tourShow=?  where tourNum="
				+ tm.getTourNum();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tm.getSupplierNum());
			ps.setString(2, tm.getTourName());
			ps.setInt(3, tm.getTourPrice());
			ps.setInt(4, tm.getTourSize());
			ps.setString(5, tm.getTourFood());
			ps.setString(6, tm.getTourMotel());
			ps.setString(7, tm.getTourTraffic());
			ps.setString(8, tm.getTourShow());
			ps.execute();
			
			for (tourspotModel tsm : tm.getTourspot()) {
				Connection conn2 = connection.getDB();
				String sql2 = "update " + connection.schema + ".tourspot set spotNum=? where tourSpotNum="+tsm.getTourspotNum();
				PreparedStatement ps2 = conn2.prepareStatement(sql2);
				
				ps2.setInt(1, tsm.getSpotNum());
				ps2.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("tourUpdate Fail");
			e.printStackTrace();
		}
		System.out.println("tourUpdate Success");
		return true;
	}

	@Override
	public boolean deletetour(Integer tourNum) {
		Connection conn = connection.getDB();
		//先刪除tourSpot
		String sqlpre="delete from " + connection.schema + ".tourspot where tourNum="+tourNum;
		try {
			PreparedStatement pspre = conn.prepareStatement(sqlpre);
			pspre.execute();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//再刪除tour
		String sql = "delete from "+connection.schema+".tour where tourNum="+tourNum;
	        try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				System.out.println("tourDelete Fail");
				e.printStackTrace();			
				return false;
			}
	        System.out.println("tourDelete Success");
			return true;
	}

	@Override
	public boolean deletetourspot(Integer tourspotNum) {
		Connection conn = connection.getDB();
		String sql = "delete from "+connection.schema+".tourspot where tourspotNum="+tourspotNum;
	        try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				System.out.println("tourSpotDelete Fail");
				e.printStackTrace();			
				return false;
			}
	        System.out.println("tourSpotDelete Success");
			return true;
	}
	
	//行程編號查詢行程名稱
		public tourModel tourReadByTourNum (Integer tourNum) {
			tourModel result=new tourModel();
			Connection conn = connection.getDB();
			String sql = "select * from " + connection.schema + ".tour where tourNum="+tourNum;
			try {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()) {
					result.setTourNum(rs.getInt("tourNum"));
					result.setSupplierNum(rs.getInt("supplierNum"));
					result.setTourName(rs.getString("tourName"));
					result.setTourPrice(rs.getInt("tourPrice"));
					result.setTourSize(rs.getInt("tourSize"));
					result.setTourFood(rs.getString("tourFood"));
					result.setTourMotel(rs.getString("tourMotel"));
					result.setTourTraffic(rs.getString("tourTraffic"));
					result.setTourShow(rs.getString("tourShow"));
					
					Connection conn2 = connection.getDB();
					String sql2 = "select * from " + connection.schema + ".tourSpot where tourNum=" + result.getTourNum();
					Statement s2 = conn2.createStatement();
					ResultSet rs2 = s2.executeQuery(sql2);
					ArrayList<tourspotModel> atsm = new ArrayList<tourspotModel>();
					while (rs2.next()) {
						tourspotModel tsm = new tourspotModel();
						tsm.setTourspotNum(rs2.getInt("tourspotNum"));
						tsm.setSpotNum(rs2.getInt("spotNum"));
						atsm.add(tsm);
					}
					result.setTourspot(atsm);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}

}