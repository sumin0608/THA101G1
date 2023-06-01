package tw.idv.ixercise.account.service;

import tw.idv.ixercise.account.entity.Account;

import java.util.List;

public interface AccountService {

    Account signUp(Account account);
    Account login(Account account);
    List<Account> findAll();
    Account findById(Integer AccountId);
    Account updateById(Account account);
    Boolean remove(Integer accountId);
    Account save(Account account);
}
