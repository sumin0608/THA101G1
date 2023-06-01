package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import java.util.List;

@RestController
@RequestMapping("Account/Manage")
public class ManageController {

    @Autowired
    private AccountService service;

    @GetMapping
    public List<Account> manage() {
        return service.findAll();
    }

    @DeleteMapping("{accountId}")
    public Core remove(@PathVariable Integer accountId) {
        final Core core = new Core();
        if (accountId == null) {
            core.setMessage("無會員Id");
            core.setSuccessful(false);
        } else {
            core.setSuccessful(service.remove(accountId));
        }
        return core;
    }

    @PutMapping
    public Core save(@RequestBody Account account) {
        final Core core = new Core();
        if (account == null) {
            core.setMessage("無會員資訊");
            core.setSuccessful(false);
        } else {
//           如何判斷是否修改成功??
            service.save(account);
            core.setMessage("修改成功");
            core.setSuccessful(true);
        }
        return core;
    }

}
