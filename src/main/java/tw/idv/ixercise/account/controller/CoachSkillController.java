package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.ApplyCoachDTO;
import tw.idv.ixercise.account.entity.CoachSkill;
import tw.idv.ixercise.account.service.CoachSkillService;
import tw.idv.ixercise.core.Core;

@RestController
@RequestMapping("Account/AddSkill")
public class CoachSkillController {

    @Autowired
    private CoachSkillService service;

//        @GetMapping
//        public Account test(@SessionAttribute Account account){
//            System.out.println(account.getAccountId());
//
//            return account;
//        }

    @PostMapping
    public Core addSkill(@RequestBody CoachSkill cs, @SessionAttribute Account account) {
        System.out.println("get in controller");
        System.out.println(account.getAccountId());
        System.out.println("get in controller");
        Core core = new Core();
        if (cs == null) {

            core.setMessage("請填寫所需資料");
            core.setSuccessful(false);
            return core;
        }
//        System.out.println(service.signUp(account));

        return service.addSkill(cs);
    }

    @PutMapping
    public Core applyBeCoach(@RequestBody ApplyCoachDTO bc) {


        return service.applyBeCoach(bc);
    }



}
