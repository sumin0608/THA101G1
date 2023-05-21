package tw.idv.ixercise.account.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.ixercise.account.entity.Account;



@Repository
public class AccountDaoImpl {
	@PersistenceContext
	private Session session;
	
	public Account selectById1(Integer accountId) {
		System.out.println("dao success");
		return session.get(Account.class, accountId);
	}
}
