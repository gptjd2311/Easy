package com.easy.easy0810.del;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.easy.easy0810.dto.ProductVO;
import com.easy.easy0810.util.DBManager;

public class ProductDAO {

	private ProductDAO() {

	}
	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}
}

	/*
	public List<ProductVO> selectAllproduct(){
		String sql = "select * from product";

		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection conn = null;
		Statement ps = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			ps = conn.createStatement();

			rs= ps.executeQuery(sql);
			while(rs.next()) {
				ProductVO pVo= new ProductVO();

				pVo.setProId(rs.getInt("proid"));
				pVo.setProType(rs.getString("proType"));
				pVo.setProName(rs.getString("proName"));
				pVo.setProPrice(rs.getInt("proPrice"));

				list.add(pVo);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, ps,rs);
		}
		return list;
	}
	
}

*/
