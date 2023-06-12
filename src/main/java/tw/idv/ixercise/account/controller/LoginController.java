package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.PgAccount;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;
import tw.idv.ixercise.core.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Account")
public class LoginController {

    @Autowired
    private AccountService service;

    @PostMapping("Login")
    public PgAccount login(HttpServletRequest req, @RequestBody Account account) {

        if ("".equals(account.getAccountPhone()) || "".equals(account.getAccountPassword())) {
            account.setMessage("請填寫手機及密碼");
            account.setSuccessful(false);
            return new PgAccount(account);
        }

        account = service.login(account);
        if (account.isSuccessful()) {
            if (req.getSession(false) != null) {
                req.changeSessionId();
            }
            final HttpSession session = req.getSession();
            session.setAttribute("loggedin", true);
            session.setAttribute("account", account);
            //JWT
            Map<String, Object> claims = new HashMap<>();
            claims.put("accountId", account.getAccountId());
            claims.put("accountPhone", account.getAccountPhone());
            claims.put("accountLevel", account.getAccountLevel());

            String jwt = JwtUtils.generateJwt(claims);
            account.setMessage(jwt);
        }
        return new PgAccount(account);

    }

    @PostMapping("LoginForAd")
    public Core loginForAdmin(HttpServletRequest req, @RequestBody Account account) {
        Core core = new Core();


        if ("".equals(account.getAccountEmail()) || "".equals(account.getAccountPassword())) {
            core.setMessage("請填寫信箱及密碼");
            core.setSuccessful(false);
            return core;
        }

        account = service.loginForAd(account);
        if (account.isSuccessful()) {
            if (req.getSession(false) != null) {
                req.changeSessionId();
            }
            final HttpSession session = req.getSession();
            session.setAttribute("loggedin", true);
            session.setAttribute("account", account);
            //JWT
            Map<String, Object> claims = new HashMap<>();
            claims.put("accountId", account.getAccountId());
            claims.put("accountEmail", account.getAccountEmail());
            claims.put("accountLevel", account.getAccountLevel());

            String jwt = JwtUtils.generateJwt(claims);
            core.setSuccessful(true);
            core.setMessage(jwt);
            return core;
        } else {
            core.setSuccessful(account.isSuccessful());
            core.setMessage(account.getMessage());
            return core;
        }
    }
}
