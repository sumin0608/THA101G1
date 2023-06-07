package tw.idv.ixercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@ServletComponentScan // 掃描Servlet相關的註解
@EnableRedisHttpSession
@SpringBootApplication
@EnableJpaAuditing // 啟用審計(Auditing)
public class Tha101G1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tha101G1Application.class, args);
	}

}
