package tw.idv.ixercise.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.idv.ixercise.account.entity.Account;
import tw.idv.ixercise.account.entity.CoachSkill;

public interface CoachSkillRepository extends JpaRepository<CoachSkill,Integer> {
    CoachSkill findCoachSkillByAccountId(Integer accountId);


}
