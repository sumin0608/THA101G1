package tw.idv.ixercise;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4NjQ2OTQ3MX0.0V_mXQ2vZUzDrNjKtlu76pDcWFiIxBhgAKi1ulHX8oA")
                .getBody();
        System.out.println(claims);
    }
}
