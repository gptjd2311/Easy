package com.easy.test0805.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.easy.test0805.dto.SugDto;
import com.easy.test0805.util.DBConn;

public class SugDao {

	DataSource dataSource;

	public SugDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SugDto contentView(String strID) {
		upHit(strID);
		SugDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String bSugFile = resultSet.getString("bSugFile");

				dto = new SugDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bSugFile);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	

	public ArrayList<SugDto> list() {
		ArrayList<SugDto> dtos = new ArrayList<SugDto>();
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				dtos.add(new SugDto(
					rs.getInt("bId"),
					rs.getString("bName"), 
					rs.getString("bTitle"),
					rs.getString("bContent"), 
					rs.getTimestamp("bDate"),
					rs.getInt("bHit"), 
					rs.getInt("bGroup"),
					rs.getInt("bStep"), 
					rs.getInt("bIndent"),
					rs.getString("bSugFile")
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
		return dtos;
	}

	public void write(String bName, String bTitle, String bContent, String bSugFile) {
          
		  Connection conn = DBConn.getConnection();
	      Statement st = null;
	      
	     
	      try {
	         st = conn.createStatement();
	         
         
	        String sql = null;
				sql = String.format("insert into mvc_board(bId,bName,bTitle,bContent,bGroup,bStep,bIndent,bSugFile) "
									+ "values (mvc_board_seq.nextval,'"+bName+"','"+bTitle+"','"+bContent+"',"
									+"mvc_board_seq.currval,0,0,'"+bSugFile+"')");
				System.out.println(sql);
				st.executeUpdate(sql);
				DBConn.close(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public SugDto select(String strID) {		
		upHit(strID);
		SugDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ? "
					+ "order by bGroup desc, bStep asc ";
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(strID));
			rs = ps.executeQuery();

			while (rs.next()) {
				dto=new SugDto(
				   rs.getInt("bId"),
				   rs.getString("bName"),
				   rs.getString("bTitle"),
				   rs.getString("bContent"),
				   rs.getTimestamp("bDate"),
				   rs.getInt("bHit"),
				   rs.getInt("bGroup"),
				   rs.getInt("bStep"),
				   rs.getInt("bIndent"),
				   rs.getString("bSugFile")
				   );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)		rs.close();
				if (ps != null) 	ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println();
		return dto;
	}

	public void modify(String bId, String bTitle, String bContent, String bSugFile) {
		
		Connection con = DBConn.getConnection();
		Statement st = null;

		try {
			st = con.createStatement();
			
			String sql = null;
			sql = String.format("update mvc_board "
			+"set bContent='%s',bTitle='%s', bSugFile='%s' "
			+"where bId=%s",bContent,bTitle,bSugFile,bId);
			System.out.println(sql);
			st.executeUpdate(sql);
			DBConn.close(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String bId) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(bId));
			int rn = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)		ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public SugDto reply_view(String str) {
		SugDto dto = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(str));
			rs = ps.executeQuery();

			if (rs.next()) {
				dto=new SugDto(
				   rs.getInt("bId"),
				   rs.getString("bName"),
				   rs.getString("bTitle"),
				   rs.getString("bContent"),
				   rs.getTimestamp("bDate"),
				   rs.getInt("bHit"),
				   rs.getInt("bGroup"),
				   rs.getInt("bStep"),
				   rs.getInt("bIndent"),
				   rs.getString("bSugFile")
				   );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)		ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {

		replyShape(bGroup, bStep);

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "insert into mvc_board "
						 + "(bId, bName, bTitle, bContent, bGroup, bStep, bIndent)"
						 + " values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, bName);
			ps.setString(2, bTitle);
			ps.setString(3, bContent);
			ps.setInt(4, Integer.parseInt(bGroup));
			ps.setInt(5, Integer.parseInt(bStep) + 1);
			ps.setInt(6, Integer.parseInt(bIndent) + 1);
			System.out.println(query);
			int rn = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)		ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	private void replyShape(String strGroup, String strStep) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 "
						 + "where bGroup = ? and bStep > ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(strGroup));
			ps.setInt(2, Integer.parseInt(strStep));

			int rn = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)		ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void upHit(String bId) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, bId);

			int rn = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)		ps.close();
				if (conn != null)	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<SugDto> select(String page, String pageDataCount) {
		ArrayList<SugDto> dtos = new ArrayList<SugDto>();
		SugDto dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String query=String.format("select * from "+
		  "(select rownum m, bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bSugFile "+
		  		" from (select bId, bName, bTitle, bContent, bDate, bHit, bgroup , bstep, bindent, bSugFile "+
		  				"from mvc_board "+  
		  				"order by bgroup desc, bstep asc)sub "+ 
		  "where rownum <= %s*%s "+ 
		  "order by bGroup desc, bStep asc) "+
		  "where m>=(%s-1)*%s+1 ",page,pageDataCount,page,pageDataCount);
			System.out.println(query);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				dto=new SugDto(
						  rs.getInt("bId"),
						  rs.getString("bName"),
						  rs.getString("bTitle"),
						  rs.getString("bContent"),
						  rs.getTimestamp("bDate"),
						  rs.getInt("bHit"),
						  rs.getInt("bGroup"),
						  rs.getInt("bStep"),
						  rs.getInt("bIndent"),
						  rs.getString("bSugFile")
						);
				dtos.add(dto);
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
		return dtos;
	}

	public int dataCount() {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = 
				String.format("select count(bId) bCount from mvc_board");
		System.out.println(query);
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnValue = rs.getInt("bCount");
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

	public ArrayList<SugDto> searchSelect(String page, String pageDataCount, String searchCol, String searchVal) {
		ArrayList<SugDto> dtos = new ArrayList<SugDto>();
		SugDto dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql=String.format("select * from " + 
	            "(select rownum m, bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bSugFile " + 
	            "from (select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, bSugFile " + 
	            "from mvc_board " + 
	            "order by bGroup desc, bStep asc)sub " + 
	            "where rownum <= %s*%s and %s like '%%%s%%' " + 
	            "order by bGroup desc, bStep asc) " + 
	            "where m>=(%s-1)*%s+1",page, pageDataCount, searchCol, searchVal, page, pageDataCount);
		System.out.println(sql);
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SugDto bDto = new SugDto(
						 rs.getInt("bId"),
						  rs.getString("bName"),
						  rs.getString("bTitle"),
						  rs.getString("bContent"),
						  rs.getTimestamp("bDate"),
						  rs.getInt("bHit"),
						  rs.getInt("bGroup"),
						  rs.getInt("bStep"),
						  rs.getInt("bIndent"),
						  rs.getString("bSugFile")
						  );
				dtos.add(bDto);
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
		
		return dtos;
	}
	
	
	public int dataCount(String searchCol, String searchVal) {
		int returnValue = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = 
				String.format("select count(bId) bCount from mvc_board "
						+ "where %s like '%%%s%%' ",searchCol, searchVal);
		System.out.println(query);
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnValue = rs.getInt("bCount");
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