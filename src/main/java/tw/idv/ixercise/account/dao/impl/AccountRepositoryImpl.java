package tw.idv.ixercise.account.dao.impl;

import org.hibernate.Session;

import javax.persistence.PersistenceContext;

public class AccountRepositoryImpl {
    @PersistenceContext
    private Session session;

//    public Account selectById(Integer accountId) {
//        System.out.println("dao success");
//        return session.get(Account.class, accountId);
//    }
//public Account findByAccountId(Integer accountId){
//    return session.get(Account.class, accountId);
//}
}
