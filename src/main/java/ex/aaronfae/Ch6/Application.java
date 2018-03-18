package ex.aaronfae.Ch6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    @Value("${project.author}")
    private String author;

    @Autowired
    private AuthorProperties authorProperties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    String index() {
        return "Hello Spring Boot - " + author;
    }

    @RequestMapping("/author")
    String author() {
        return "author name is " + authorProperties.getName() + " author age is " + authorProperties.getAge();
    }
}
