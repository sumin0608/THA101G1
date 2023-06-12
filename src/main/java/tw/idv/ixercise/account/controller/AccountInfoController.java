package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.CourseAccount;
import tw.idv.ixercise.account.entity.LessAccount;
import tw.idv.ixercise.account.entity.PgAccount;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountInfoController {

    @Autowired
    AccountService service;

    //    給課程首頁的DTO=========================
    @GetMapping("FindAllForCourse")
    public List<CourseAccount> manage() {
        return service.findAllCourseInfo();
    }

    //    給後台的DTO===============================
    @GetMapping({"Info/{AccountId}"})
    public LessAccount findAccountById(@PathVariable Integer AccountId) {

        Account account = service.findById(AccountId);


        if (account == null) {
            LessAccount noInfo = new LessAccount();
            noInfo.setMessage("查無會員資料");
            noInfo.setSuccessful(false);
            return noInfo;
        } else {
            account.setSuccessful(true);

            return new LessAccount(account);
        }
    }

    //    用來找全部會員資訊=============================
    @GetMapping({"Manage/{AccountId}"})
    public Account findAccountByIdFullInfo(@PathVariable Integer AccountId) {

        Account account = service.findById(AccountId);


        if (account == null) {
            Account acc = new Account();
            acc.setMessage("查無會員資料");
            acc.setSuccessful(false);
            return acc;
        } else {
            account.setSuccessful(true);

            return account;
        }
    }

    @GetMapping("PersonalPage/{accountId}")
    public PgAccount findAcInfoForPg(@PathVariable Integer accountId) {
        return service.findForPg(accountId);
    }

    @GetMapping("checkfornav/{accountId}")
    public Core checkfornav(@PathVariable Integer accountId) {

        Core core = new Core();
        if(accountId == null){
            core.setSuccessful(false);
            core.setMessage("未登入");
            return core;
        }
        Account acc = service.findById(accountId);

        switch (acc.getAccountLevel()) {
            case 1:
                core.setSuccessful(false);
                core.setMessage("一般會員");
                break;
            case 2:
                core.setSuccessful(true);
                core.setMessage("教練");
                break;
            case 3:
                core.setSuccessful(true);
                core.setMessage("管理員");
                break;
        }
        return core;
    }
}
