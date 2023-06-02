package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.LessAccount;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

@RestController
@RequestMapping("Account")
public class AccountInfoController {

    @Autowired
    AccountService service;

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
    @GetMapping({"Manage/{AccountId}"})
    public Account findAccountByIdFullInfo(@PathVariable Integer AccountId) {

        Account account = service.findById(AccountId);


        if (account == null) {

            account.setMessage("查無會員資料");
            account.setSuccessful(false);
            return account;
        } else {
            account.setSuccessful(true);

            return account;
        }
    }

//    @PostMapping
//    public Account updateAccountById(@RequestBody Account account){
//
//    }
}
