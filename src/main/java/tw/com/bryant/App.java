package tw.com.bryant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@Slf4j
@SpringBootApplication
@ServletComponentScan
public class App extends SpringBootServletInitializer
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.warn("Ready!!");
    }

}
