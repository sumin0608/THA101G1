package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;

    @Override
    public Account signup(Account account){
//        撰寫商業邏輯，判斷送入的會員資料是否合乎規定
        if(repo.findByAccountPhone(account.getAccountPhone()) != null){
            account.setMessage("此手機被註冊過");
            account.setSuccessful(false);
            return account;
        }
        account.setAccountLevel(1);
        account.setAccountState(1);
        account = repo.save(account);
        account.setMessage("註冊成功");
        account.setSuccessful(true);
        return account;
    }

    @Override
    @Transactional
    public boolean save(Account account){
//        return repo.update(account) > 0;
       return repo.save(account) != null;
    }

    public List<Account> findAll(){
        return repo.findAll();
    }
//        public Account saveById(Account account){
//            return repo.save(account);
//    }
}
