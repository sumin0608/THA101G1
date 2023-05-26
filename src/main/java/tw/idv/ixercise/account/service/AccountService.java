package tw.idv.ixercise.account.service;

import tw.idv.ixercise.account.entity.Account;

import java.util.List;

public interface AccountService {

    Account signup(Account account);
    boolean save(Account account);
    List<Account> findAll();
}
