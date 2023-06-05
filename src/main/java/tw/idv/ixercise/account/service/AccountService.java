package tw.idv.ixercise.account.service;

import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.CourseAccount;
import tw.idv.ixercise.account.entity.LessAccount;
import tw.idv.ixercise.account.entity.PgAccount;
import tw.idv.ixercise.core.Core;

import java.util.List;

public interface AccountService {

    Account signUp(Account account);

    Account login(Account account);

    List<Account> findAll();

    //  用來撈後台用的資訊======================
    List<LessAccount> findAllLessInfo();

    List<CourseAccount> findAllCourseInfo();

    Account findById(Integer AccountId);

    Account updateById(Account account);

    Boolean remove(Integer accountId);

    Account save(Account account);
//    為了後台修改權限跟狀態
    Core modifyacc(Account account);

    PgAccount findForPg(Integer accountId);

    Core VerifyEmail(String accountEmail);

    Core InputVerify(Account account);

    Core forgetPassword(Account account);

}
