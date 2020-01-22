package tw.com.bryant.register.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.bryant.global.mgr.MemMgr;
import tw.com.bryant.global.web.util.CIOutput;
import tw.com.bryant.global.web.util.Validator;
import tw.com.bryant.register.model.CIMember;
import tw.com.bryant.register.model.CIMemberRepository;
import tw.com.bryant.register.requset.SignUpRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class RegisterService {
    @Autowired
    private CIMemberRepository ciMemberRepository;

    public String signUpEmail(SignUpRequest ciRegisterRequest) throws Exception {
                if(StringUtils.isBlank(ciRegisterRequest.getUsername())&&
                    StringUtils.isBlank(ciRegisterRequest.getPassword())&&
                    StringUtils.isBlank(ciRegisterRequest.getEmail())){
                    throw new Exception("invalid param ");
                }
                String result = checkUsername(ciRegisterRequest.getUsername());
                String username = "OK".equals(result) ?
                                  ciRegisterRequest.getUsername() :
                                  result;
                //校驗password 格式
                if(!Validator.isPassword(ciRegisterRequest.getPassword())) {
                    throw new Exception("invalid password");
                }
                String pass = MemMgr.passMd5(ciRegisterRequest.getUsername(),
                        ciRegisterRequest.getPassword());


                String email = ciRegisterRequest.getEmail();
                //校驗email 格式
                if(!Validator.isEmail(email)){
                    throw new Exception("invalid email");
                }

                ciMemberRepository.save(new CIMember(username,pass,email));
                return "OK";



    }
    private String checkUsername(String username) {

                while (true){
                    CIMember ciMember = ciMemberRepository.findByCiUsername(username);
                    if(!Objects.isNull(ciMember)) {
                        Long newId = ciMember.getId() + 1L;
                        String original = StringUtils.substringBefore(ciMember.getCiUsername(),String.valueOf(ciMember.getId()));

                        username = original + String.valueOf(newId);
                    }else{
                        return username;
                    }
                }
    }

}
