package ruboweb.pushetta;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/pushetta-context.xml")
public class TestBase extends AbstractTransactionalJUnit4SpringContextTests {

	public TestBase() {

	}
}
