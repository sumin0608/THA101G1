package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import tw.idv.ixercise.store.entity.product;



public class productDaoImpl {
	public product selectByProduct_no(Integer product_no) {
		String sql = "select * from product where product_no = ?";
			
		product pl=null;	
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Team1","root","password");
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, product_no);
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						 pl = new product();
						 
						pl.setProduct_no(rs.getInt("product_no"));
						pl.setProduct_type_no(rs.getInt("product_type_no"));
						pl.setProduct_name(rs.getString("product_name"));
						pl.setPrice(rs.getInt("price"));
						pl.setProduct_storage(rs.getInt("product_storage"));
						pl.setDescription(rs.getString("description"));
						pl.setTotal_comment(rs.getInt("total_comment"));
						pl.setProduct_star(rs.getDouble("product_star"));
						pl.setProduct_photo(rs.getString("product_photo"));
						
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return pl;
	}
	
	public static void main(String args[]) {
		product p = new productDaoImpl().selectByProduct_no(1);
		System.out.println(p.getProduct_name());
	}
}
