package universe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import universe.model.Universe;
import universe.model.User;
import universe.model.UserUniverse;
import universe.model.UserUniverseKey;

public interface UserUniverseRepository extends JpaRepository<UserUniverse, UserUniverseKey> {
	
	@Transactional
	@Modifying
	@Query("delete from UserUniverse uu where uu.id.user=:user")
	void deleteByUser(@Param("user") User user);
	
	@Transactional
	@Modifying
	@Query("delete from UserUniverse uu where uu.id.universe=:universe")
	void deleteByUniverse(@Param("universe") Universe universe);
	
	@Transactional
	@Modifying
	@Query("delete from UserUniverse uu where uu.id.universe=:universe and uu.id.user=:user")
	void deleteByUserAndUniverse(@Param("universe") Universe universe, @Param("user") User user);
	
}
