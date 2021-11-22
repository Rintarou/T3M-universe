package universe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.Universe;

public interface UniverseRepository extends JpaRepository<Universe, Long> {

}
