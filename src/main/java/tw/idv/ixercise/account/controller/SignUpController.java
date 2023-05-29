package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;

@RestController
@RequestMapping("Account/SignUp")
public class SignUpController {
    @Autowired
    private AccountService service;

    @PostMapping
    public Account signup(@RequestBody Account account) {
        System.out.println("get in controller");
        if (account == null) {
            account = new Account();
            account.setMessage("無會員資訊");
            account.setSuccessful(false);
            return account;
        }
        System.out.println(service.signUp(account));
        return service.signUp(account);
    }
}
