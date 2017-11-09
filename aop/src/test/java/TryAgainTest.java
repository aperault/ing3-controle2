import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)

public class TryAgainTest {

        @Autowired
        Service svc;


        @Test(expected=NullPointerException.class)
        public void test()
        {
            svc.method();
        }


}