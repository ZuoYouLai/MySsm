import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SimpleTest {


    /**
     * 第一个测试成功
     */
    @Test
    public void te1() {
        boolean kflg = StringUtils.isBlank(null);
        System.err.println(kflg);
    }


}
