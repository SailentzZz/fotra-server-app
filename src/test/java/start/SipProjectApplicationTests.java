package start;

import com.fotra.database.entities.Answer;
import com.fotra.database.entities.PostAnswers;
import com.fotra.database.repositories.AnswerPostRepo;
import com.fotra.database.repositories.AnswerRepo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.fotra.SipProjectApplication;
import com.fotra.service.PostForumSevice;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SipProjectApplication.class)
@ComponentScan(basePackages = {"com.fotra"})
public class SipProjectApplicationTests {
	
	private static Logger logger = Logger.getLogger(SipProjectApplicationTests.class);
	
	@Autowired
	private PostForumSevice postForumService;

//	@Autowired
//	private AnswerService answerService;

	@Autowired
	private AnswerRepo answerRepo;

	@Autowired
	private AnswerPostRepo answerPostRepo;
	
	@Test
	public void dAOtest() throws Exception {
		postForumService.UpdateStatement(55, true);
	}
	
//	@Test
//	public void TranslateTest() throws Exception {
//	    logger.info(yandexTranslate.translate("ru", "hi"));
//	}
}

