package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;

@RestController
@RequestMapping("Account/Info")
public class AccountInfoController {

    @Autowired
    AccountService service;

    @GetMapping({"{AccountId}"})
    public Account findAccountById(@PathVariable Integer AccountId) {

        Account account = service.findById(AccountId);

        if (account == null) {
            Account noInfo = new Account();
            noInfo.setMessage("查無會員資料");
            noInfo.setSuccessful(false);
            return noInfo;
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
