import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class test1 {

    @Test
    public void test1(){
        String id = "10000";
        String username = "cloud";
        String username2 = "cloud10000";
        String result = "";

        result = StringUtils.substringBefore(username,id);
        System.out.println(result);
        result = StringUtils.substringBefore(username2,id);
        System.out.println(result);
    }
}
