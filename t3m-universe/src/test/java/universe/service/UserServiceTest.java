package universe.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universe.exception.LimitedAssignationException;
import universe.exception.UserException;
import universe.model.User;
import universe.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	// userService methods:  save, delete, byId, allUser.

	private static User u;

	@BeforeEach
	public void setup() {
		u = new User();
		u.setLogin("Bob");
		u.setPassword("Dylann");
	}


	// when a user is saved it should be found in the database.
	@Test 
	public void savePersistent() {
		User check = userService.save( u );

		assertNotNull( userService.byId( check.getId() ) );
	}
	
	//when a user is saved, then edited, it should be the same as the database version (id equivalency)
	@Test 
	public void savePersistentModification() {
		User check = userService.save( u );

		u.setPassword("Marvel");
		assertEquals( u, userService.byId( check.getId() ) );
		
		userService.save( check );
		assertEquals( u, userService.byId( check.getId() ) );
	}

	// you cannot change a user's id ( see user.test? )
	@Test
	public void saveDuplicateFail() {
		userService.save( u );

		User duplicate = new User();
		duplicate.setLogin("Jhon");
		duplicate.setPassword("Doe");
		User check = userService.save( duplicate );

		assertThrows( LimitedAssignationException.class, ()->{ check.setId( u.getId() ); } );

		userService.save( check );
		assertNotEquals( u, check );
	} 

	// when a user is deleted it should no longer be in the database
	@Test
	public void deletePersistent() {
		userService.save( u );

		userService.delete( u );

		assertThrows( UserException.class, ()->{ userService.byId( u.getId() ); } );
	} 

	// when we retrieve a User, its universes attribute must be set.
	@Test
	public void userHasUniverses() {
		userService.save( u );

		assertNotNull( userService.byId( u.getId() ).getUserUniverses() );
	}

}
