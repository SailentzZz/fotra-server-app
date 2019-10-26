package start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import repos.repositories.UserForumRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("repos")
public class SipProjectApplicationTests {
	
	@Autowired
	private UserForumRepository userForumRepository;
	
	@Test
	public void dAOtest() throws Exception {
		//userForumRepository.save(new UserForum("1", "1", "1", "1", new Date(), 1));
	}
}

