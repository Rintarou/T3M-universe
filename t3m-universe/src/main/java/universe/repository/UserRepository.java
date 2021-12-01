package universe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import universe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLoginContaining( String login );
    
    Optional<User> findByLogin( String login );
    
    @Query("select u from User u left join fetch u.userUniverses")
    List<User> findAllWithUniverses();
    
    @Query("select u from User u left join fetch u.userUniverses where u.id=:id")
    Optional<User> findByIdWithUniverses(@Param("id") Long id);
	
}
