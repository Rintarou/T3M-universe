package universe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLogin( String login );
	
}
