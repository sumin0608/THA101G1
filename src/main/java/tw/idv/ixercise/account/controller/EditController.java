package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
        System.out.println(account);
//        session.getA

        return account;
    }


    //    這個暫時不使用
    @PostMapping
    public Core checkOldPassword(@RequestBody Account nAccount, @SessionAttribute("account") Account account) {
        final Core core = new Core();
        System.out.println(nAccount);
        System.out.println(account);
        if (nAccount == null) {
            core.setMessage("無會員資料");
            core.setSuccessful(false);
        } else if (account == null) {
            core.setMessage("請重新登入");
            core.setSuccessful(false);
        } else {
            System.out.println(account);
            final String currentPassword = account.getAccountPassword();
            final String oldPassword = nAccount.getAccountPassword();
            System.out.println(currentPassword);
            System.out.println(oldPassword);
            System.out.println(Objects.equals(oldPassword, currentPassword));
            if (Objects.equals(oldPassword, currentPassword)) {
                core.setSuccessful(true);
            } else {
                core.setMessage("舊密碼錯誤");
                core.setSuccessful(false);
            }
        }

        return core;
    }


    @PutMapping("update")
    public Account edit(Model model, @RequestBody @Valid Account account, @SessionAttribute("account") Account oAccount) {
//        驗證傳進來的會員資料
        if (account == null) {
            Account acc = new Account();
            acc.setMessage("無會員資料");
            acc.setSuccessful(false);
            return acc;
        }
//        驗證Session裡的會員資料是否為空
        if (oAccount == null) {
            account.setMessage("請重新登入");
            account.setSuccessful(false);
            return account;
        }


        account.setAccountId(oAccount.getAccountId());
        account = service.updateById(account);
        System.out.println("送回來的acc" + account);
        if (account.isSuccessful()) {
//            model的用意??

//            oAccount = account;
            System.out.println("存給Oacc" + account);
            model.addAttribute("account", account);
//            session.setAttribute("account",account);
            System.out.println("sesssion的acc" + model.getAttribute("account"));
        }
//        System.out.println(account);
        account.setMessage("修改成功");
        account.setSuccessful(true);
        return account;
    }

}
