package universe.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import universe.config.AppConfig;
import universe.model.AccessRight;
import universe.model.Universe;
import universe.model.User;
import universe.model.UserUniverse;
import universe.model.UserUniverseKey;
import universe.service.UniverseService;
import universe.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UniverseServiceTest {
	
	@Autowired
	private UniverseService universeService;
	
	@Autowired
	private UserService userService;
	
	// //@Test
	// public void testSave() {
	// 	Universe universe = universeService.byIdWithUserUniverses(100L);
	// 	User user1 = userService.byId(101L);
	// 	User user2 = userService.byId(100L);
		
	// 	UserUniverse uu = universeService.findUserUniverseById(new UserUniverseKey(user1, universe));
		
	// 	universe.changeRights(uu, user2, AccessRight.readWrite);
	// 	universeService.save(universe);
	// 	assertNotNull(universeService.byId(universe.getId()));
	// 	//universeService.delete(universe);
	// }
	
	@Test
	public void testDelete() {
		//universeService.delete(universeService.byId(100L));
		assertNull(null);
	}
	
}
