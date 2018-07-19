package test;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class daokTest {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        System.err.println(dateTime.toDateTime());

        boolean l = StringUtils.isBlank("111");
        System.err.println(l);
    }



//    @Te



//    @Test


//    @Test
//    public void te1() {
//        boolean kflg = StringUtils.isBlank(null);
//        System.err.println(kflg);
//    }
}
