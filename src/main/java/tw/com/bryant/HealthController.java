package tw.com.bryant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/")
    public String healthCare(){
        return "Hello project test jenkins xx";
    }

}
