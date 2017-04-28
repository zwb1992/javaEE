import com.zwb.spring.service.AccountServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zwb on 17/4/26.
 * 类名上加上两个注解表示让其运行在spring环境中
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mvc.xml")
public class Test {

    @Autowired
    private AccountServiceImpl accountService;

    @org.junit.Test
    public void transfer(){
        accountService.transfer("aaa","bbb",200d);
    }

    @org.junit.Test
    public void transfer1(){
        accountService.transfer1("aaa","bbb",200d);
    }

}
