package tw.com.bryant.config.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public abstract class WebResourceVersionMarker {
}
