package universe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universe.model.User;
import universe.service.UserService;

@SpringBootTest
class T3mUniverseApplicationTests {

	
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UserService userService;
	
	@Test
	public void createUser() {
		User user = new User();
		user.setLogin("test");
		user.setPassword("test");
		userService.save(user); 
	}
}
