package com.easy.test0805.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.easy.test0805.dto.MemberVO;
import com.easy.test0805.util.DBManager;

public class BDao {

	public BDao() {}
	
	public static BDao instance = new BDao();
	public static BDao getInstance() {
		 return instance;
	}
	
		
	public ArrayList<MemberVO> list() {
		ArrayList<MemberVO> mVo = new ArrayList<MemberVO>();
		String query = "select * from member order by memNum desc";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				mVo.add(new MemberVO(
						rs.getString("memNum"),
						rs.getString("memType"), 
						rs.getString("memId"),
						rs.getString("memPwd"), 
						rs.getString("memName"),
						rs.getInt("user_birth_year"), 
						rs.getInt("user_birth_month"),
						rs.getInt("user_birth_day"), 
						rs.getString("memGen"),
						rs.getString("memEmail"),
						rs.getString("memPhone"),
						rs.getString("memAdd_1"),
						rs.getString("memAdd_2"),
						rs.getString("memAdd_3")
					));
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
		return mVo;
	}


	public ArrayList<MemberVO> select(String page, String pageDataCount) {
		ArrayList<MemberVO> mVos = new ArrayList<MemberVO>();
		MemberVO mVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			System.out.println("bDao select");
			String query=String.format("select * from (select rownum m,memNum,memType,memId,memPwd,memName,user_birth_year,user_birth_month,user_birth_day,memGen,memEmail,memPhone,memAdd_1,memAdd_2,memAdd_3 "+
		  		" from (select memNum,memType,memId,memPwd,memName,user_birth_year,user_birth_month,user_birth_day,memGen,memEmail,memPhone,memAdd_1,memAdd_2,memAdd_3 "+
		  				" from member "+  
		  				" order by memNum desc) sub "+ 
		  " where rownum <= %s*%s ) where m>=(%s-1)*%s+1",page,pageDataCount,page,pageDataCount);
			System.out.println(query);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				mVo=new MemberVO(
						rs.getString("memNum"),
						rs.getString("memType"), 
						rs.getString("memId"),
						rs.getString("memPwd"), 
						rs.getString("memName"),
						rs.getInt("user_birth_year"), 
						rs.getInt("user_birth_month"),
						rs.getInt("user_birth_day"), 
						rs.getString("memGen"),
						rs.getString("memEmail"),
						rs.getString("memPhone"),
						rs.getString("memAdd_1"),
						rs.getString("memAdd_2"),
						rs.getString("memAdd_3"));
						mVos.add(mVo);
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
		return mVos;
	}
	
	public ArrayList<MemberVO> memSearchSelect(String page, String pageDataCount, String searchCol, String searchVal) {
		ArrayList<MemberVO> mVos = new ArrayList<MemberVO>();
		
		MemberVO mVo = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		
		System.out.println("memberSearchDao select");
		String sql=String.format("select * from (select rownum m, sub.* from (select * from member order by memNum desc) sub where rownum <= %s*%s and %s like '%%%s%%') where m>=(%s-1)*%s+1",page,pageDataCount,searchCol,searchVal,page,pageDataCount);
	
		System.out.println(sql);
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mVo=new MemberVO(
						rs.getString("memNum"),
						rs.getString("memType"), 
						rs.getString("memId"),
						rs.getString("memPwd"), 
						rs.getString("memName"),
						rs.getInt("user_birth_year"), 
						rs.getInt("user_birth_month"),
						rs.getInt("user_birth_day"), 
						rs.getString("memGen"),
						rs.getString("memEmail"),
						rs.getString("memPhone"),
						rs.getString("memAdd_1"),
						rs.getString("memAdd_2"),
						rs.getString("memAdd_3"));
						mVos.add(mVo);
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
		return mVos;
	}
	
	public int dataCount(String searchCol,String searchVal) {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = 
				String.format("select count(memName) memCount from member where %s like '%%%s%%'",searchCol,searchVal);
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


	public int dataCount() {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = 
				String.format("select count(memNum) memCount from member");
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
