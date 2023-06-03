package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.CourseAccount;
import tw.idv.ixercise.account.entity.LessAccount;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;


    // 新增===============================================================
    @Override
    @Transactional
    public Account signUp(Account account) {
//        撰寫商業邏輯，判斷送入的會員資料是否合乎規定
        if (repo.findByAccountPhone(account.getAccountPhone()) != null) {
            account.setMessage("此手機被註冊過");
            account.setSuccessful(false);
            return account;
        }

        account.setAccountLevel(1);
        account.setAccountState(1);
        account.setAccountVerify(genAuthCode());
        account.setAccountReport(0);
        account.setAccountCreatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountUpdatetime(new Timestamp(System.currentTimeMillis()));
        System.out.println(account);
        System.out.println("==================");
        account = repo.save(account);
        System.out.println(account);
        account.setMessage("註冊成功");
        account.setSuccessful(true);
        return account;
    }

    //產生驗證碼
    public String genAuthCode() {
        String x = new String();
        while (true) {
            int ran = (int) (Math.random() * 3);
            switch (ran) {
                case 0:
                    int i1 = (int) (Math.random() * 10 + 48);
                    x += (char) i1;
                    break;
                case 1:
                    int i2 = (int) (Math.random() * 26 + 65);
                    x += (char) i2;
                    break;
                case 2:
                    int i3 = (int) (Math.random() * 26 + 97);
                    x += (char) i3;
                    break;
            }
            if (x.length() == 8) {
                break;
            }
        }
        return x;
    }

    // 查詢登入=============================================================
    @Override
    public Account login(Account account) {
        final String accountPhone = account.getAccountPhone();
        final String accountPassword = account.getAccountPassword();

        if (accountPhone == null) {
            account.setMessage("帳號未輸入");
            account.setSuccessful(false);
            return account;
        }
        if (accountPassword == null) {
            account.setMessage("密碼未輸入");
            account.setSuccessful(false);
            return account;
        }
        account = repo.findForLogin(accountPhone, accountPassword);
        if (account == null) {
            account = new Account();
            account.setMessage("帳號或密碼錯誤");
            account.setSuccessful(false);
            return account;
        }

        account.setMessage("登入成功");
        account.setSuccessful(true);
        return account;
    }

    //透過ID更新會員資料==================================================
    @Transactional
    @Override
    public Account updateById(Account account) {
//        找資料庫裡的舊會員資料
        Account oAccount = repo.findByAccountId(account.getAccountId());
        String newPassword = account.getAccountPassword();
        if (newPassword == null || newPassword.isEmpty()) {
            account.setAccountPassword(oAccount.getAccountPassword());
        }

        account.setAccountId(oAccount.getAccountId());
        account.setAccountPhone(oAccount.getAccountPhone());
        account.setAccountLevel(oAccount.getAccountLevel());
        account.setAccountState(oAccount.getAccountState());
        account.setAccountId(oAccount.getAccountId());
        account.setAccountBirthday(oAccount.getAccountBirthday());
        account.setAccountCreatetime(oAccount.getAccountCreatetime());
        account.setAccountUpdatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountGender(oAccount.getAccountGender());
        account.setAccountReport(oAccount.getAccountReport());
        account.setAccountVerify(oAccount.getAccountVerify());

//      怎麼判斷修改成功與否?
        account = repo.save(account);
        account.setMessage("修改成功");
        account.setSuccessful(true);
        return account;

    }

    public Boolean remove(Integer AccountId) {
        repo.deleteById(AccountId);
        return !(repo.existsById(AccountId));
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }

    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public List<LessAccount> findAllLessInfo() {
        List<Account> acclist = repo.findAll();
        List<LessAccount> lAacc = new ArrayList<>();
        for (Account acc : acclist) {
            LessAccount la = new LessAccount(acc);
            lAacc.add(la);
        }

        return lAacc;
    }

    @Override
    public List<CourseAccount> findAllCourseInfo() {
        List<Account> acclist = repo.findAll();
        List<CourseAccount> lAacc = new ArrayList<>();
        for (Account acc : acclist) {
            CourseAccount la = new CourseAccount(acc);
            lAacc.add(la);
        }

        return lAacc;
    }


//    後台用

    @Override
    public Account findById(Integer AccountId) {
        return repo.findByAccountId(AccountId);
    }

    @Override
    public Core modifyacc(Account account){
        Account acc = repo.findByAccountId(account.getAccountId());
        acc.setAccountLevel(account.getAccountLevel());
        acc.setAccountState(account.getAccountState());
        repo.save(acc);
        Core core = new Core();
        core.setMessage("修改成功");
        core.setSuccessful(true);
        return core;
    }

}
