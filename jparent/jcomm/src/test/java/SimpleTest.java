import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class SimpleTest {


    /**
     * 第一个测试成功
     */
    @Test
    public void te1() {
        boolean kflg = StringUtils.isBlank(null);
        System.err.println(kflg);
    }
    
    
     /**
        *
        */
      @Test  
      public void test002(){

          for(int k=0;k<100;k++) {
              String str = UUID.randomUUID().toString();
              System.err.println(str);
              char end=str.charAt(str.length()-1);
              byte endNum = (byte) end;
              System.err.println(end +"  =   "+endNum+"  -->  "+endNum%3);

          }


      }



}
