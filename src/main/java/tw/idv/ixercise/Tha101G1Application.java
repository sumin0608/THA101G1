package tw.idv.ixercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.*;


@SpringBootApplication
@EnableJpaAuditing
public class Tha101G1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tha101G1Application.class, args);
	}

}
