package universe.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universe.exception.UniverseException;
import universe.model.AccessRight;
import universe.model.Universe;
import universe.model.Universe;
import universe.service.UniverseService;
import universe.service.UserService;

 @SpringBootTest
public class UniverseServiceTest {
	
	@Autowired
	private UniverseService universeService;
	
	@Autowired
	private UserService userService;

	private static Universe u;
	
	@BeforeEach
	public void setup() {
		u = new Universe();
		u.setName("world 1-1");
	}

	// when a universe is saved it should be found in the database.
	@Test 
	public void savePersistent() {
		Universe check = universeService.save( u );

		assertNotNull( universeService.byId( check.getId() ) );
	}
	
	//when a universe is saved, then edited, it should be the same as the database version (id equivalency)
	@Test 
	public void savePersistentModification() {
		Universe check = universeService.save( u );

		check.setName("Myst");
		assertEquals(u, universeService.byId( check.getId() ) );
		
		universeService.save( check );
		assertEquals(u, universeService.byId( check.getId() ) );
	}

	// you cannot change a universe's id after it's been set ( see universe.test? )
	@Test
	public void saveDuplicateFail() {
		universeService.save( u );

		Universe duplicate = new Universe();
		duplicate.setName("Myst");
		Universe check = universeService.save( duplicate );

		assertThrows( UniverseException.class, ()->{ check.setId( u.getId() ); } );
	} 

	// when a universe is deleted it should no longer be in the database
	// @Test
	// public void deletePersistent() {
	// 	universeService.save( u );

	// 	universeService.delete( u );

	// 	assertThrows( UniverseException.class, ()->{ universeService.byId( u.getId() ); } );
	// } 
	
}
