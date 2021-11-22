package universe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import universe.model.Universe;

public interface UniverseRepository extends JpaRepository<Universe, Long> {
	
	@Query("select u from Universe u left join fetch u.userUniverses where u.id=:id")
	Optional<Universe> findByIdWithUserUniverses(@Param("id") Long id);
}
