package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.idv.ixercise.store.entity.porder;

public class ImplPorder implements PorderDao{
	public static void main(String[] args) {
		porder pr = new porder("1","aaa","bbb","ccc",555,"ddd","eee");
		new ImplPorder().insert(pr);
		
	}
	

	@Override
	public void insert(porder p) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String sql = "insert into porder(porderNo,memberNo,name,"
				+ "productName,pamount,pdate,phone,email) "
				+ "values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPorderNo());
			pstmt.setString(2, p.getMemberNo());
			pstmt.setString(3, p.getName());
			pstmt.setString(4, p.getProductName());
			pstmt.setInt(5, p.getPamount());
			
			java.sql.Date d = new java.sql.Date(p.getPdate().getTime());
			pstmt.setDate(6, d);
			pstmt.setString(7, p.getPhone());
			pstmt.setString(8, p.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
