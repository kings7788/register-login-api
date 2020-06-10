package tw.com.bryant;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.bryant.config.web.WebResourceVersionMarker;

@RestController
@Api(tags = "Health")
public class HealthController extends WebResourceVersionMarker {
    @GetMapping("/")
    public String healthCare(){
        return "Hello project test jenkins xx";
    }

}
