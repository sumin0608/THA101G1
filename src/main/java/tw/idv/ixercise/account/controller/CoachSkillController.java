package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.ixercise.account.entity.CoachSkill;
import tw.idv.ixercise.account.service.CoachSkillService;
import tw.idv.ixercise.core.Core;

@RestController
@RequestMapping("Account/AddSkill")
public class CoachSkillController {

        @Autowired
        private CoachSkillService service;

        @PostMapping
        public Core addSkill(@RequestBody CoachSkill cs) {
            System.out.println("get in controller");

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
}
