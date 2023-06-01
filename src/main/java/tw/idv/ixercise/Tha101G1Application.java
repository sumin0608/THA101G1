package tw.idv.ixercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 掃描Servlet相關的註解
@SpringBootApplication
public class Tha101G1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tha101G1Application.class, args);
	}

}
