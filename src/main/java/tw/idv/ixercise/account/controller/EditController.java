package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import java.util.Objects;

@RestController
@RequestMapping("Account/edit")
@SessionAttributes({"account"})
public class EditController {

    @Autowired
    private AccountService service;

    @GetMapping
    public Account getInfo(@SessionAttribute Account account) {
        if (account == null) {
            account = new Account();
            account.setMessage("無會員資料");
            account.setSuccessful(false);
        } else {
            account.setSuccessful(true);
        }
        return account;
    }

    @PostMapping
    public Core checkOldPassword(@RequestBody Account account, @SessionAttribute("account") Account oAccount) {
        final Core core = new Core();
        if (account == null) {
            core.setMessage("無會員資料");
            core.setSuccessful(false);
        } else if (oAccount == null) {
            core.setMessage("請重新登入");
            core.setSuccessful(false);
        } else {
            final String currentPassword = oAccount.getAccountPassword();
            final String newPassword = account.getAccountPassword();
            if (Objects.equals(newPassword, currentPassword)) {
                core.setSuccessful(true);
            } else {
                core.setMessage("舊密碼錯誤");
                core.setSuccessful(false);
            }
        }
        return core;
    }


    @PutMapping
    public Account edit(Model model, @RequestBody Account account, @SessionAttribute("account") Account oAccount) {
//        驗證傳進來的會員資料
        if (account == null) {
            account.setMessage("無會員資料");
            account.setSuccessful(false);
            return account;
        }
//        驗證Session裡的會員資料是否為空
        if (oAccount == null) {
            account.setMessage("請重新登入");
            account.setSuccessful(false);
            return account;
        }
        account.setAccountId(oAccount.getAccountId());
        account = service.edit(account);
        if (account.isSuccessful()) {
            model.addAttribute("account", account);
        }

        return account;
    }

}
