package start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import database.repositories.UserForumRepository;
import translation.Impl.YandexTranslate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"database", "translation"})
public class SipProjectApplicationTests {
	
	@Autowired
	private UserForumRepository userForumRepository;

	@Autowired
	private YandexTranslate yandexTranslate;
	
	@Test
	public void dAOtest() throws Exception {

		//userForumRepository.save(new UserForum("1", "1", "1", "1", new Date(), 1));
	}
	@Test
	public void TranslateTest() throws Exception {
	    System.out.println(yandexTranslate.translate("ru", "hi"));
	}
}

