package tw.com.bryant.global.mgr;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tw.com.bryant.global.web.util.MD5Util;

public class MemMgr {

    public static String passMd5(String username ,String pass) throws Exception{
        if(StringUtils.isBlank(pass)){
            throw new Exception("pass is invalid , md5 crypt error");
        }
        String md5Passs = MD5Util.crypt("CI**"+username+"**"+MD5Util.crypt(pass));
        return md5Passs;
    }
}
