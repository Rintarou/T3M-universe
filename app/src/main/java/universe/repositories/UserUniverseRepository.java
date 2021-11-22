package universe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.UserUniverse;
import universe.model.UserUniverseKey;

public interface UserUniverseRepository extends JpaRepository<UserUniverse, UserUniverseKey> {

}
