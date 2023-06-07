package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.idv.ixercise.store.entity.porder;

public class ImplPorder implements PorderDao{
	public static void main(String[] args) {
		List<porder> l=new ImplPorder().queryMemberNo("bbb");
		
		for(porder p:l)
		{
			System.out.println(p.getId()+"\t"+p.getMemberNo()+"\t"+p.getName());
		}
		
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


	@Override
	public List<porder> queryMemberNo(String memberno) {
		Connection conn=DbConnection.getDb();
		//String SQL="select * from porder where memberNo=?";
		String SQL="select * from porder where name=?";
		List<porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, memberno);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				porder p=new porder();
				p.setId(rs.getInt("id"));
				p.setPorderNo(rs.getString("porderNo"));
				p.setMemberNo(rs.getString("memberNo"));
				p.setName(rs.getString("name"));
				p.setProductName(rs.getString("productName"));
				p.setPamount(rs.getInt("pamount"));
					
				p.setPdate(rs.getDate("pdate"));
				p.setEmail(rs.getString("email"));
				
				l.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return l;
	}

}
