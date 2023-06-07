package tw.idv.ixercise.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.idv.ixercise.account.entity.CoachSkill;

import java.util.List;

public interface CoachSkillRepository extends JpaRepository<CoachSkill,Integer> {
    CoachSkill findCoachSkillByAccountId(Integer accountId);

    @Query(
            value = "select * from CoachSkill where ACCOUNTID = :accountId",
            nativeQuery = true
    )
    List<CoachSkill> findAllByAccountId(Integer accountId);

    @Query(
            value = "SELECT * from COACHSKILL where skillState = 0",
            nativeQuery = true
    )
    List<CoachSkill> findAllSkillForAd();
}
