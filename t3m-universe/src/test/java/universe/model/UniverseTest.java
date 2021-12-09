package universe.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import universe.exception.LimitedAssignationException;

@SpringBootTest
public class UniverseTest {
    
    private static Universe u;

    @BeforeEach
    public void setup() {
        u = new Universe();
        u.setName("world 1-1");
    }

    @Test
    public void idSingleAssignement() {
        u.setId( 100L );
        
        assertThrows( LimitedAssignationException.class, ()->{ u.setId( 101L); } );
    }
}
