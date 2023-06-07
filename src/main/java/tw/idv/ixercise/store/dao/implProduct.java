package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.idv.ixercise.store.entity.product;

public class implProduct implements productDao{

	
	@Override
	public product query(String productName) {
		
		Connection conn = DbConnection.getDb();
		String sql="select * from product where productName=?";
		product p = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				p = new product();
				p.setId(rs.getInt("id"));
				p.setProductNo(rs.getString("productNo"));
				p.setProductName(rs.getString("productName"));
				p.setPrice(rs.getInt("price"));
				p.setPicture(rs.getString("picture"));
				p.setAmount(rs.getInt("amount"));
				p.setComment(rs.getString("comment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
}
