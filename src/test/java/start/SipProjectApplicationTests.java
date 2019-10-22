package start;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import repos.UserForum;
import repos.UserForumRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("repos")
public class SipProjectApplicationTests {
	
	@Autowired
	private UserForumRepository userForumRepository;
	
	@Test
	public void dAOtest() throws Exception {
		Iterable<UserForum> iterable = userForumRepository.findAll();
		Iterator<UserForum> coll = iterable.iterator();
		while (coll.hasNext()) {
			System.out.println(coll.next().getEmail());			
		}
	}
}
