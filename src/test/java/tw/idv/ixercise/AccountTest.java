package tw.idv.ixercise;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.dao.CoachSkillRepository;
import tw.idv.ixercise.account.entity.CoachSkill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
//@SpringBootTest
public class AccountTest {
//    @Autowired
//    private AccountRepository acrepo;
//    @Autowired
//    private CoachSkillRepository csrepo;

    //    @Autowired
//    private EventDaoImpl eventDao;
//    class acforpg{
////        private
//}
//    @Test
//    public void findbyacid() {
//        List<CoachSkill> li = csrepo.findAllByAccountId(25);
//        System.out.println(li);

    //    }
    @Test
    public void testjwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");


        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "ixercise")//加密法
                .setClaims(claims)//自定義內容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//小時的毫秒值 1小時token會過期
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testparsejwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("ixercise")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NjQ1MzE4M30.K-CvrnWSXoIkQBYbvSWpN5vyzNgZZNHrvhs25yB9AG0")
                .getBody();
        System.out.println(claims);
    }
}
