package tw.idv.ixercise.account.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.idv.ixercise.account.entity.CoachSkill;

import javax.persistence.PersistenceContext;

@Repository
public class CoachSkillRepositoryImpl {
    @PersistenceContext
    private Session session;

    public CoachSkill selectById(Integer skillId) {
        System.out.println("dao success");
        return session.get(CoachSkill.class, skillId);
    }
}
