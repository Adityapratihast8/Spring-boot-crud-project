package in.strike.springbootdemocrude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication()
public class SpringbootdemocrudeApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootdemocrudeApplication.class, args);
        System.out.println("hello world");
    }

}
