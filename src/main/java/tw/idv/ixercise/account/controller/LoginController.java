package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("Account/Login")
public class LoginController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account login(HttpServletRequest req, @RequestBody Account account){

        System.out.println("controller being req");

        if(account.getAccountPhone() == null || account.getAccountPassword() == null){
            account.setMessage("無會員資料");
            account.setSuccessful(false);
            return account;
        }

        account = service.login(account);
        if(account.isSuccessful()){
            if(req.getSession(false) != null){
                req.changeSessionId();
            }
            final HttpSession session = req.getSession();
            session.setAttribute("loggedin",true);
            session.setAttribute("account",account);
        }
    return account;

    }
    @PostMapping("BackStage")
    public Core loginForAdmin(){
        return null;
    }
}
