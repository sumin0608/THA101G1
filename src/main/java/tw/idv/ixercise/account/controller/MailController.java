package tw.idv.ixercise.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;


@RestController
@RequestMapping("Account")
public class MailController {

    @Autowired
    private AccountService service;



    @PostMapping("Verify")
    public Core VerifyEmail(@RequestBody Account account){
        System.out.println(account);
    return service.VerifyEmail(account.getAccountEmail());
    }

    @PostMapping("InputVerify")
    public Core CheckVerify(@RequestBody Account account){
        return service.InputVerify(account);
    }

    @PostMapping("Forgetps")
    public Core forGetps(@RequestBody Account account){
        Core core = service.forgetPassword(account);
        System.out.println(core);
        return core;
    }

}