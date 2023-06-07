package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.idv.ixercise.store.entity.member;

public class implMember implements memberDao{


	@Override
	public member queryMember(String accountPhone, String accountPassword) {
		//String SQL="select * from member where username=? and password=?";
		String SQL="select * from account where accountPhone=? and accountPassword=?";
		Connection conn=DbConnection.getDb();
		member m=null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			
			//ps.setString(1, username);
			//ps.setString(2, password);
			ps.setString(1, accountPhone);
			ps.setString(2, accountPassword);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				m=new member();
				//m.setId(rs.getInt("id"));
				m.setId(rs.getInt("accountId"));
				//m.setMember_no(rs.getString("member_no"));
				
				//m.setName(rs.getString("name"));
				m.setName(rs.getString("accountName"));
				//m.setUsername(rs.getString("username"));
				m.setUsername(rs.getString("accountPhone"));
				//m.setPassword(rs.getString("password"));
				m.setPassword(rs.getString("accountPassword"));
				//m.setPhone(rs.getString("phone"));
				
				//m.setEmail(rs.getString("email"));
				m.setEmail(rs.getString("accountEmail"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

}
