package tw.com.bryant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
@Slf4j
@SpringBootApplication
public class App extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.warn("Ready!!");
    }

}
