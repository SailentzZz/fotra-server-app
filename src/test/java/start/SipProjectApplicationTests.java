package start;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.fotra.service.UserForumService;
import com.fotra.translation.Impl.YandexTranslate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com"})
public class SipProjectApplicationTests {
	
	private static Logger logger = Logger.getLogger(SipProjectApplicationTests.class);
	
	@Autowired
	private UserForumService userForumService;

	@Autowired
	private YandexTranslate yandexTranslate;
	
	@Test
	public void dAOtest() throws Exception {

		logger.info(userForumService.getLoginUser("sailentzzz"));
	}
	
//	@Test
//	public void TranslateTest() throws Exception {
//	    logger.info(yandexTranslate.translate("ru", "hi"));
//	}
}

