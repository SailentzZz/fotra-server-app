package start;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.fotra.SipProjectApplication;
import com.fotra.database.repositories.PostForumRepository.PostFrameReqDtoRepo;
import com.fotra.service.PostForumSevice;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SipProjectApplication.class)
@ComponentScan(basePackages = {"com.fotra"})
public class SipProjectApplicationTests {
	
	private static Logger logger = Logger.getLogger(SipProjectApplicationTests.class);
	
	@Autowired
	private PostForumSevice postForumService;
	
	@Test
	public void dAOtest() throws Exception {

//		PasswordReset entity = new PasswordReset(1, "eqweqeq", 7, new Date());
//		
//		passwordResetRepository.save(entity);
//		
//		PasswordReset passwordReset = passwordResetRepository.findByToken("eqweqeq");
//		long diff = new Date().getTime() - passwordReset.getExpiryDate().getTime();
//		logger.info(diff / (60 * 1000) % 60); $2a$04$iJ1EQR8e5fPHJ5KO6.JtxOZY..OfaaGIfhKzGun.kjH64Yr490qoq
		
		//userForumService.setPasswordByEmail("testing", "misha_travin@mail.ru");
		Iterable<PostFrameReqDtoRepo> iterable = postForumService.getPosts();
		logger.info(iterable.iterator().next());
	}
	
//	@Test
//	public void TranslateTest() throws Exception {
//	    logger.info(yandexTranslate.translate("ru", "hi"));
//	}
}

