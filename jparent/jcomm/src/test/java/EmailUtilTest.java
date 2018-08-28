import com.jmp.comm.Utils.EmailUtil;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

import static com.jmp.comm.Utils.EmailUtil.SMTP_QQ;

public class EmailUtilTest {
    @Before
    public void before() throws GeneralSecurityException {
        // 配置，一次即可
        EmailUtil.config(SMTP_QQ(false), "2582654085@qq.com", "dzdcmbfghbomeadg");
    }

    @Test
    public void testSendText() throws MessagingException {
        EmailUtil.subject("这是一封测试TEXT邮件")
                .from("xxxxx")
                .to("目标的邮件地址")
                .text("信件内容")
                .send();
    }
}
