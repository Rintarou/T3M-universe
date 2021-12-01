package universe.service;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universe.exception.UserException;
import universe.model.User;
import universe.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	// save, delete, byId, allUser.

	// when a user is saved it should be found in the database.
	@Test 
	public void savePersistence() {
		User u = new User();
		u.setLogin("Bob");
		u.setPassword("Dylann");
		User check = userService.save( u );
		
		assertNotNull( userService.byId( check.getId() ) );
	}
	
	//when a user is saved, then edited, it should be the same as the database version (id equivalency)
	@Test 
	public void savePersistentModification() {
		User u = new User();
		u.setLogin("Bob");
		u.setPassword("Dylann");
		User check = userService.save( u );
		u.setPassword("Marvel");
		
		assertEquals(u, userService.byId( check.getId() ) );
	}

	// when a user is deleted it should no longer be in the database
	// @Test( expected = UserException.class )
	// public void deletePersistent() {
	// 	User u = userService.byName("Bob");
	// 	userService.delete( u );
	// 	User check = userService.byId( u.getId() );
	// 	fail();
	// } 

	// when we retrieve a User, its universes attribute must be set.
	@Test
	public void userHasUniverses() {
		assertNotNull( userService.byId( 101L ).getUserUniverses() );
	}


	// you can't manually push a user with an id already assigned
	@Test
	public void saveDuplicateFail() {
		User u = new User();
		u.setLogin("Bob");
		u.setPassword("Dylann");
		u.setId( 101L );
		assertThrows( UserException.class, ()-> { userService.save( u ); } );
		
	} 
	
 	
	
	// @Test
	// public void testSave() {
	// 	User user1 = new User();
	// 	user1.setLogin("mathieu");
	// 	user1.setPassword("mdp");
	// 	userService.save(user1);
		
	// }
	
	// @Test
	// public void testDelete() {
	// 	userService.delete( userService.byId( 101L ) );
	// }

	// @Test
	// public void testById() {
	// 	userService.delete(userService.byId(101L));
	// }


}
