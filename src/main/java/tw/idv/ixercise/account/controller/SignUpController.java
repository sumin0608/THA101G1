package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import javax.validation.Valid;

@RestController
@RequestMapping("Account/SignUp")
public class SignUpController {
    @Autowired
    private AccountService service;

    @PostMapping
    public Account signup(@RequestBody @Valid Account account) {
        System.out.println("get in controller");
        if (account == null) {
            account = new Account();
            account.setMessage("無會員資訊");
            account.setSuccessful(false);
            return account;
        }
//        System.out.println(service.signUp(account));

        return service.signUp(account);
    }

    @PostMapping("AddAdmin")
    public Core addforAdmin(@RequestBody Account account) {
        if (account == null) {
            account = new Account();
            account.setMessage("請填寫內容");
            account.setSuccessful(false);
            return account;
        }


        return service.addAdmin(account);
    }


}
