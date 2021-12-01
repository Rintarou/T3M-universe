package universe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import universe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name like :name")
    Optional<User> findByName( @Param("name") String name );
	
}
