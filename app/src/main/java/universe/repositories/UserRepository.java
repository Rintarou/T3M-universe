package universe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
