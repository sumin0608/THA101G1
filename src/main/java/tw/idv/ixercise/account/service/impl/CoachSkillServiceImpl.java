package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.dao.CoachSkillRepository;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.ApplyCoachDTO;
import tw.idv.ixercise.account.entity.CoachSkill;
import tw.idv.ixercise.account.service.CoachSkillService;
import tw.idv.ixercise.core.Core;

@Service
public class CoachSkillServiceImpl implements CoachSkillService {

    @Autowired
    CoachSkillRepository repo;
    @Autowired
    AccountRepository acrepo;

    @Override
    public Core addSkill(CoachSkill cs) {

        cs.setSkillState(0);
        repo.save(cs);
        Core core = new Core();
        core.setSuccessful(true);
        core.setMessage("申請成功");

        return core;
    }

    @Transactional
    @Override
    public Core applyBeCoach(ApplyCoachDTO bc) {
        Account acc = acrepo.findByAccountId(bc.getAccountId());
        acc.setAccountBank(bc.getAccountBank());
        acrepo.save(acc);
        CoachSkill cs = new CoachSkill();
        cs.setAccountId(bc.getAccountId());
        cs.setSportType(bc.getSportType());
        cs.setLicenseName(bc.getLicenseName());
        cs.setLicensePhoto(bc.getLicensePhoto());
        cs.setSkillState(0);
        repo.save(cs);
        return new Core(true,"申請成功");
    }
}
