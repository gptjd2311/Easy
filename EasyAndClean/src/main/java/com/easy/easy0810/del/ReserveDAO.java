package com.easy.easy0810.del;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easy.easy0810.dto.ReserveVO;
import com.easy.easy0810.util.DBManager;

public class ReserveDAO {

}
	
	
	/*
	public void reserveRes(int resId,int resGroup) {
		String sql = "";
		System.out.println("dao에서 resID "+resId);
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, resGroup);		
			ps.setInt(2, resId);			
			ps.executeQuery();
			System.out.println(sql);
			System.out.println("쿼리 test");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}	
	}	
	
//	String sql = "update reserve set resPay=1,resDate=sysdate,resGroup=? where resId=?";
	public List<ReserveVO> adminAllReserve() {
		String sql = "select * from reserve where respay!=3 order by resid desc";
		System.out.println("select all 1번");
		List<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"+sql);
			while (rs.next()) {
				ReserveVO rVo = new ReserveVO();
				rVo.setResId(rs.getInt("resId"));
				rVo.setMemId(rs.getString("memId"));
				rVo.setProId(rs.getInt("proId"));
				rVo.setProType(rs.getString("proType"));
				rVo.setProName(rs.getString("proName"));
				rVo.setResNum(rs.getInt("resNum"));
				rVo.setResPay(rs.getInt("resPay"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResCharge(rs.getInt("resCharge"));
				rVo.setResData(rs.getString("resData"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public List<ReserveVO> selectAllbucket(String memId) {
		String sql = "select * from reserve where memid=? and resPay=0 order by resId";
		System.out.println("dao 1번");
		System.out.println(memId);
		List<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				ReserveVO rVo = new ReserveVO();
				
				rVo.setResId(rs.getInt("resId"));
				rVo.setMemId(rs.getString("memId"));
				rVo.setProId(rs.getInt("proId"));
				rVo.setProType(rs.getString("proType"));
				rVo.setProName(rs.getString("proName"));
				rVo.setResNum(rs.getInt("resNum"));
				rVo.setResPay(rs.getInt("resPay"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResCharge(rs.getInt("resCharge"));
				rVo.setResData(rs.getString("resData"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public List<ReserveVO> selectAllReserve(String memId) {
		String sql = "select * from reserve where memid=? and resPay=1 order by resDate,resID asc";
		System.out.println("dao 1번");
		System.out.println(memId);
		List<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			rs = ps.executeQuery();
			
			System.out.println(sql);
			while (rs.next()) {
				ReserveVO rVo = new ReserveVO();
				rVo.setResId(rs.getInt("resId"));
				rVo.setMemId(rs.getString("memId"));
				rVo.setProId(rs.getInt("proId"));
				rVo.setProType(rs.getString("proType"));
				rVo.setProName(rs.getString("proName"));
				rVo.setResNum(rs.getInt("resNum"));
				rVo.setResPay(rs.getInt("resPay"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResCharge(rs.getInt("resCharge"));
				rVo.setResData(rs.getString("resData"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public List<ReserveVO> selectGroupReserve(String memId) {
		String sql = "select DISTINCT resgroup,resdate,resdata from reserve where (memid=? and respay = 1) order by resGroup desc";
		System.out.println("dao 1번");
		System.out.println(memId);
		List<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memId);
			rs = ps.executeQuery();
			
			System.out.println(sql);
			while (rs.next()) {
				ReserveVO rVo = new ReserveVO();
				rVo.setResGroup(rs.getInt("resGroup"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResData(rs.getString("resData"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public List<ReserveVO> selectDetailReserve(String resGroup) {
		String sql = " ";
		System.out.println("dao 1번");
		System.out.println(resGroup);
		List<ReserveVO> list = new ArrayList<ReserveVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, resGroup);
			rs = ps.executeQuery();
			
			System.out.println(sql);
			while (rs.next()) {
				ReserveVO rVo = new ReserveVO();
				rVo.setResId(rs.getInt("resId"));
				rVo.setMemId(rs.getString("memId"));
				rVo.setProId(rs.getInt("proId"));
				rVo.setProType(rs.getString("proType"));
				rVo.setProName(rs.getString("proName"));
				rVo.setResNum(rs.getInt("resNum"));
				rVo.setResPay(rs.getInt("resPay"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResCharge(rs.getInt("resCharge"));
				rVo.setResData(rs.getString("resData"));
				rVo.setResGroup(rs.getInt("resGroup"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	

	public void ReserveInsert(String memId, int proId, int resNum) {
		System.out.println("insert 시작");
		String sql = "select proType,proName,proPrice from product where proId=?";
		
		String sql2 = "insert into reserve (resid,memid,proid,protype,proname,resnum,rescharge,respay,resdata,resdate)"
				+" values(reserve_seq.nextval,?,?,?,?,?,?,0,?,null)";

		String proType = null;
		String proName = null;
		int proPrice = 0;
		int resCharge = 0;
		
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, proId);
			rs = ps.executeQuery();
			
			System.out.println(proId+"로 select 시작");
			if(rs.next()) {
				proType = rs.getString("proType");
				proName = rs.getString("proName");
				proPrice = rs.getInt("proPrice");
				System.out.println(proPrice+","+resNum);
				resCharge = proPrice*resNum;			
				ps.close();
							
			}
			System.out.println("입력 쿼리 시작");	
			
			ps = conn.prepareStatement(sql2);			
			ps.setString(1, memId);
			ps.setInt(2, proId);
			ps.setString(3, proType);
			ps.setString(4, proName);
			ps.setInt(5, resNum);
			ps.setInt(6, resCharge);
			ps.setString(7, "상품준비중");
			ps.executeUpdate();

			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
	}
	
	public ReserveVO selectOneResByResId(String resId) {
	
		String sql = "select * from reserve where resId = ?";
	
		
		ReserveVO rVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rVo = new ReserveVO();
				rVo.setResId(rs.getInt("resId"));
				rVo.setMemId(rs.getString("memId"));
				rVo.setProId(rs.getInt("proId"));
				rVo.setProType(rs.getString("proType"));
				rVo.setProName(rs.getString("proName"));
				rVo.setResNum(rs.getInt("resNum"));
				rVo.setResPay(rs.getInt("resPay"));
				rVo.setResDate(rs.getTimestamp("resDate"));
				rVo.setResCharge(rs.getInt("resCharge"));
				rVo.setResData(rs.getString("resData"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return rVo;
	}
	
	public void adminResUpdate(int resId,int proId, int resNum, String resData) {
		String sql1 = "select proType,proName,proPrice from product where proId=?";
		String sql2 = "update Reserve set proId=?, proType=?, proName=?, resNum=?, resCharge=?,resData=?  where resId=?";
		System.out.println("update 시작");

		String proType = null;
		String proName = null;
		int proPrice = 0;
		int resCharge = 0;
		
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql1);

			ps.setInt(1, proId);
			rs = ps.executeQuery();
			
			System.out.println(proId+"로 select 시작");
			if(rs.next()) {
				proType = rs.getString("proType");
				proName = rs.getString("proName");
				proPrice = rs.getInt("proPrice");
				System.out.println(proPrice+","+resNum);
				resCharge = proPrice*resNum;			
				ps.close();
							
			}
			System.out.println("입력 쿼리 시작");	
			
			ps = conn.prepareStatement(sql2);			
			System.out.println(sql2);
			ps.setInt(1, proId);
			ps.setString(2, proType);
			ps.setString(3, proName);
			ps.setInt(4, resNum);
			ps.setInt(5, resCharge);
			ps.setString(6, resData);
			ps.setInt(7, resId);


			ps.executeUpdate();

			

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
	}
	
	public void adminResDelete(int resId) {
		String sql = "delete from reserve where resid=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
	}

	public void ReserveBucketDelete(int resId) {
		String sql = "delete from reserve where resid=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
	
	public void ReserveReserveDelete(int resGroup) {
		String sql = "delete from reserve where resGroup=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resGroup);
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}

	public void ReserveBucketDeleteChoose(int resId) {
		String sql = "delete from reserve where resId=?";
		System.out.println("DAO test");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
	
	public void ReserveAdminUpdate1(int resId) {
		String sql = "update reserve set resdata='상품준비중' where resId=?";
		System.out.println("DAO test");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
	
	public void ReserveAdminUpdate2(int resId) {
		String sql = "update reserve set resdata='배송중' where resId=?";
		System.out.println("DAO test");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
	
	public void ReserveAdminUpdate3(int resId) {
		String sql = "update reserve set resdata='배송완료', respay=2 where resId=?";
		System.out.println("DAO test");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
	
	public void ReserveAdminUpdate4(int resId) {
		String sql = "update reserve set respay=3 where resId=?";
		System.out.println("DAO test");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, resId);
			ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps);
		}
		
	}
}

*/

