package com.easy.easy0810.del;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.easy.easy0810.dto.ReserveVO;
import com.easy.easy0810.util.DBManager;

public class ResDao {
}

/*
		public static ResDao instance = new ResDao();
		public static ResDao getInstance() {
			 return instance;
		}

	public ArrayList<ReserveVO> resList() {
		ArrayList<ReserveVO> rVo = new ArrayList<ReserveVO>();
		String query = "select resGroup,memId,proId,proType,proName,resNum,resCharge,respay,resDate,resData from reserve where respay!=2 groorder by resid desc";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				rVo.add(new ReserveVO(
						rs.getInt("resId"),
						rs.getString("memId"), 
						rs.getInt("proId"),
						rs.getString("proType"), 
						rs.getString("proName"), 
						rs.getInt("resNum"),
						rs.getInt("resCharge"),
						rs.getInt("resPay"),
						rs.getTimestamp("resDate"),
						rs.getString("resData"),
						rs.getInt("resGroup"))
					);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	  rs.close();
				if (st != null)	  st.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rVo;
	}


	public ArrayList<ReserveVO> resSelect(String page, String pageDataCount) {
		ArrayList<ReserveVO> rVos = new ArrayList<ReserveVO>();
		ReserveVO rVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			System.out.println("reserveDao select");
			String query=String.format("select * from (select rownum m,resId,memId,proId,proType,proName,resNum,resCharge,resPay,resDate"+" from (select resId,memId,proId,proType,proName,resNum,resCharge,resPay,resDate from reserve order by resId desc) sub where rownum <= %s*%s ) where m>=(%s-1)*%s+1",page,pageDataCount,page,pageDataCount);
//			rs.getInt("resId"),
//			rs.getString("memId "), 
//			rs.getInt("proId "),
//			rs.getString("proType "), 
//			rs.getString("proName "), 
//			rs.getInt("resNum "),
//			rs.getInt("resCharge "),
//			rs.getInt("resPay "),
//			rs.getTimestamp("resDate"));
//			String query=String.format("select * from (select rownum m,memNum,memType,memId,memPwd,memName,user_birth_year,user_birth_month,user_birth_day,memGen,memEmail,memPhone,memAdd_1,memAdd_2,memAdd_3 "+
//			  		" from (select memNum,memType,memId,memPwd,memName,user_birth_year,user_birth_month,user_birth_day,memGen,memEmail,memPhone,memAdd_1,memAdd_2,memAdd_3 "+
//			  				" from member "+  
//			  				" order by memNum desc) sub "+ 
//			  " where rownum <= %s*%s ) where m>=(%s-1)*%s+1",page,pageDataCount,page,pageDataCount);
//			

			System.out.println(query);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				rVo=new ReserveVO(
						rs.getInt("resId"),
						rs.getString("memId"), 
						rs.getInt("proId"),
						rs.getString("proType"), 
						rs.getString("proName"), 
						rs.getInt("resNum"),
						rs.getInt("resCharge"),
						rs.getInt("resPay"),
						rs.getTimestamp("resDate"),
						rs.getString("resData"));
						rVos.add(rVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rVos;
	}




	public ArrayList<ReserveVO> resSearchSelect(String page, String pageDataCount, String searchCol, String searchVal) {
		ArrayList<ReserveVO> rVos = new ArrayList<ReserveVO>();

		ReserveVO rVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		System.out.println("reserveSearchDao select");
		String sql=String.format("select * from (select rownum m, sub.* from (select * from reserve where respay < 2 order by resid desc) sub where rownum <= %s*%s and %s like '%% %s %%') where m>=(%s-1)*%s+1",page,pageDataCount,searchCol,searchVal,page,pageDataCount);

		System.out.println(sql);

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				rVo=new ReserveVO(
						rs.getInt("resId"),
						rs.getString("memId"), 
						rs.getInt("proId"),
						rs.getString("proType"), 
						rs.getString("proName"), 
						rs.getInt("resNum"),
						rs.getInt("resCharge"),
						rs.getInt("resPay"),
						rs.getTimestamp("resDate"),
						rs.getString("resData"));
						rVos.add(rVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rVos;
	}

	public ArrayList<ReserveVO> resSearchSelectDel(String page, String pageDataCount, String searchCol, String searchVal) {
		ArrayList<ReserveVO> rVos = new ArrayList<ReserveVO>();

		ReserveVO rVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		System.out.println("reserveSearchDao select");
		String sql=String.format("select * from (select rownum m, sub.* from (select * from reserve where respay=3 order by resid desc) sub where rownum <= %s*%s and %s like '%%%s%%') where m>=(%s-1)*%s+1",page,pageDataCount,searchCol,searchVal,page,pageDataCount);

		System.out.println(sql);

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				rVo=new ReserveVO(
						rs.getInt("resId"),
						rs.getString("memId"), 
						rs.getInt("proId"),
						rs.getString("proType"), 
						rs.getString("proName"), 
						rs.getInt("resNum"),
						rs.getInt("resCharge"),
						rs.getInt("resPay"),
						rs.getTimestamp("resDate"),
						rs.getString("resData"));
						rVos.add(rVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rVos;
	}

	public ArrayList<ReserveVO> resSearchSelectOld(String page, String pageDataCount, String searchCol, String searchVal) {
		ArrayList<ReserveVO> rVos = new ArrayList<ReserveVO>();

		ReserveVO rVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		System.out.println("reserveSearchDao select");
		String sql=String.format("select * from (select rownum m, sub.* from (select * from reserve where respay=2 order by resid desc) sub where rownum <= %s*%s and %s like '%%%s%%') where m>=(%s-1)*%s+1",page,pageDataCount,searchCol,searchVal,page,pageDataCount);

		System.out.println(sql);

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				rVo=new ReserveVO(
						rs.getInt("resId"),
						rs.getString("memId"), 
						rs.getInt("proId"),
						rs.getString("proType"), 
						rs.getString("proName"), 
						rs.getInt("resNum"),
						rs.getInt("resCharge"),
						rs.getInt("resPay"),
						rs.getTimestamp("resDate"),
						rs.getString("resData"));
						rVos.add(rVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rVos;
	}

	public int DataCount() {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = String.format("select count(memId) memCount from reserve");
		System.out.println(query);
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnValue = rs.getInt("memCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return returnValue;
	}

	public int DataCount(String searchCol,String searchVal) {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = String.format("select count(memId) memCount from reserve where %s like '%%%s%%' ",searchCol,searchVal);
		System.out.println(query);
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnValue = rs.getInt("memCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return returnValue;
	}
}

 */