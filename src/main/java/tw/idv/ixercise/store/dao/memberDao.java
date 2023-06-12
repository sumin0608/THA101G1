package tw.idv.ixercise.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.idv.ixercise.store.entity.member;

public interface memberDao {
	member queryMember(String username,String password);
	

}
