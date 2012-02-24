import controllers.Application;
import org.junit.Test;

import play.test.UnitTest;

public class ApplicationControllerTest extends UnitTest {

    @Test
    public void testThatLoginWorks(){
        String pwd = "pwd";
        String user = "user";
        Application.login(user, pwd);
    }

}
