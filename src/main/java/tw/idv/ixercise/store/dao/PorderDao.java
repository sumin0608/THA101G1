package tw.idv.ixercise.store.dao;

import java.util.List;

import tw.idv.ixercise.store.entity.porder;

public interface PorderDao {

	void insert(porder p);
	
	//List<porder> queryMemberNo(String memberno);
	List<porder> queryMemberNo(String memberno);
}
