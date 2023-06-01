package tw.idv.ixercise.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@RequestMapping("Account/Logout")
public class LogoutController {

@GetMapping
    public void logout(SessionStatus sessionStatus){
    sessionStatus.setComplete();
}

}
