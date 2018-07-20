
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

public class daokTest {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.err.println(dateTime.toDateTime());

        boolean l = StringUtils.isBlank("111");
        System.err.println(l);
    }









//    @T



    @Test
    public void te1() {
        boolean kflg = StringUtils.isBlank(null);
        System.err.println(kflg);
    }
}
