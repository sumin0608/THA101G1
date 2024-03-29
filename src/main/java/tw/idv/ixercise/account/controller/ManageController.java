package tw.idv.ixercise.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.CoachSkill;
import tw.idv.ixercise.account.entity.LessAccount;
import tw.idv.ixercise.account.entity.SkillManageDTO;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import java.util.List;

@RestController
@RequestMapping("Account/Manage")
public class ManageController {

    @Autowired
    private AccountService service;

    @GetMapping
    public List<LessAccount> manage() {
        return service.findAllLessInfo();
    }

    @DeleteMapping("{accountId}")
    public Core remove(@PathVariable Integer accountId) {
        final Core core = new Core();
        if (accountId == null) {
            core.setMessage("無會員Id");
            core.setSuccessful(false);
            return core;
        }
        if (service.remove(accountId)) {
            return new Core(true, "刪除成功");
        } else {
            return new Core(false, "刪除失敗");
        }
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

    @PutMapping("modify")
    public Core modifyLevel(@RequestBody Account account) {
        final Core core = new Core();

        if (account == null) {
            core.setMessage("改動失敗");
            core.setSuccessful(false);
            return core;
        } else {
            return service.modifyacc(account);
        }
    }

    //    for Admin==========================================
    @GetMapping("ForAdmin")
    public List<LessAccount> manageAdmin() {
        return service.findAllLessInfoAdmin();
    }

    @GetMapping("SkillReview")
    public List<SkillManageDTO> manageSkill(){
//        List<SkillManageDTO> skm = service.findAllSkill();
//        if(skm == null){
//
//        }
        return service.findAllSkill();
    }
    @GetMapping("Skill/{skillId}")
    public CoachSkill findSkillForManage(@PathVariable Integer skillId){
        if(skillId == null){
            return new CoachSkill(false,"查詢錯誤");
        }
        return service.findSkById(skillId);
    }

    @PostMapping("Skill/Modify")
    public Core findSkillForManage(@RequestBody CoachSkill coachSkill){
        if(coachSkill == null){
            return new CoachSkill(false,"此筆申請異常");
        }
        return service.modifySkillApply(coachSkill);
    }
    @GetMapping("forChechLogin")
    public Core checkLg(){
        return new Core(true,"登入正常");
    }
}
