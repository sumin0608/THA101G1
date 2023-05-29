package tw.idv.ixercise.account.dao.impl;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.ixercise.account.entity.Account;

import javax.persistence.PersistenceContext;

public class AccountRepositoryImpl {
    @PersistenceContext
    private Session session;

//    public int update(Account account){
//
//    }



//    public Account selectById(Integer accountId) {
//        System.out.println("dao success");
//        return session.get(Account.class, accountId);
//    }
//public Account findByAccountId(Integer accountId){
//    return session.get(Account.class, accountId);
//}
}
