package tw.idv.ixercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@ServletComponentScan // 掃描Servlet相關的註解
@EnableRedisHttpSession
@SpringBootApplication
public class Tha101G1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tha101G1Application.class, args);
	}

}
