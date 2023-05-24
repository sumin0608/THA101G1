package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> findAll(){
        return repository.findAll();
    }

//        public Account saveById(Account account){
//            return repo.save(account);
//    }
}
