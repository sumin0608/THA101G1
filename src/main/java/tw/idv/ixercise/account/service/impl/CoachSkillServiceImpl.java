package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.ixercise.account.dao.CoachSkillRepository;
import tw.idv.ixercise.account.entity.CoachSkill;
import tw.idv.ixercise.account.service.CoachSkillService;
import tw.idv.ixercise.core.Core;

@Service
public class CoachSkillServiceImpl implements CoachSkillService {

    @Autowired
    CoachSkillRepository repo;
    @Override
    public Core addSkill(CoachSkill cs) {

        repo.save(cs);
        Core core = new Core();
        core.setSuccessful(true);
        core.setMessage("申請成功");

        return core;
    }
}
