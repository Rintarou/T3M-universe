package universe;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import universe.config.AppConfig;
import universe.model.User;
import universe.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	//@Test
	public void testSave() {
		User user1 = new User();
		user1.setLogin("mathieu");
		user1.setPassword("mdp");
		userService.save(user1);
	}
	
	//@Test
	public void testDelete() {
		userService.delete(userService.byId(101L));
	}
}
