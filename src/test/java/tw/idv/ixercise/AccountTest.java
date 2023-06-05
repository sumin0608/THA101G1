package tw.idv.ixercise;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.dao.CoachSkillRepository;
import tw.idv.ixercise.account.entity.CoachSkill;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountRepository acrepo;
    @Autowired
    private CoachSkillRepository csrepo;

    //    @Autowired
//    private EventDaoImpl eventDao;
//    class acforpg{
////        private
//}
    @Test
    public void findbyacid() {
        List<CoachSkill> li = csrepo.findAllByAccountId(25);
        System.out.println(li);

    }
}