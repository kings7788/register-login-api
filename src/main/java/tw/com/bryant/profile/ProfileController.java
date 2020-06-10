package tw.com.bryant.profile;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tw.com.bryant.config.web.WebResourceVersionMarker;

@RestController
@Api(tags = "profile")
@Slf4j
public class ProfileController extends WebResourceVersionMarker {

    @RequestMapping(value = "profiles", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity uploadFile(
            @RequestParam("file") MultipartFile file) {
        try {
             String fileName = file.getOriginalFilename();
             log.warn("do save :{}", fileName);


            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
