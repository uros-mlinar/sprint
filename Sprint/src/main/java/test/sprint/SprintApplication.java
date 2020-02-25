package test.sprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SprintApplication 
extends SpringBootServletInitializer {

public static void main(String[] args) {
	 SpringApplication.run(SprintApplication.class, args);
}

}
