package start;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.fotra.SipProjectApplication;
import com.fotra.database.repositories.PasswordResetRepository;
import com.fotra.service.UserForumService;
import com.fotra.translation.Impl.YandexTranslate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SipProjectApplication.class)
@ComponentScan(basePackages = {"com.fotra"})
public class SipProjectApplicationTests {
	
	private static Logger logger = Logger.getLogger(SipProjectApplicationTests.class);
	
	@Autowired
	private UserForumService userForumService;
	
	@Autowired
	private PasswordResetRepository passwordResetRepository;

	@Autowired
	private YandexTranslate yandexTranslate;
	
	@Test
	public void dAOtest() throws Exception {

//		PasswordReset entity = new PasswordReset(1, "eqweqeq", 7, new Date());
//		
//		passwordResetRepository.save(entity);
//		
//		PasswordReset passwordReset = passwordResetRepository.findByToken("eqweqeq");
//		long diff = new Date().getTime() - passwordReset.getExpiryDate().getTime();
//		logger.info(diff / (60 * 1000) % 60); $2a$04$iJ1EQR8e5fPHJ5KO6.JtxOZY..OfaaGIfhKzGun.kjH64Yr490qoq
		
		userForumService.setPasswordByEmail("testing", "misha_travin@mail.ru");
	}
	
//	@Test
//	public void TranslateTest() throws Exception {
//	    logger.info(yandexTranslate.translate("ru", "hi"));
//	}
}

