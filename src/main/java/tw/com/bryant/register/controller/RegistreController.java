package tw.com.bryant.register.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tw.com.bryant.global.web.util.CIOutput;
import tw.com.bryant.register.requset.SignUpRequest;
import tw.com.bryant.register.service.RegisterService;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@Slf4j
public class RegistreController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/signup/email")
    public CIOutput signUpEmail(
            @RequestBody @Valid SignUpRequest ciRegisterRequest
    ){

        log.warn(":{}",ciRegisterRequest.getUsername());
        log.warn(":{}",ciRegisterRequest.getPassword());
        log.warn(":{}",ciRegisterRequest.getEmail());
        try{
            if(Objects.isNull(ciRegisterRequest))
                throw new Exception("request is inValid !") ;
            registerService.signUpEmail(ciRegisterRequest);
            return new CIOutput(200,"OK");
        }catch (Exception e){
            log.error(e.getMessage());
            return new CIOutput(500,"error");
        }

    }

}
