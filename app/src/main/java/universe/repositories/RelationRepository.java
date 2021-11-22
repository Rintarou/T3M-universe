package universe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.Relation;
import universe.model.RelationKey;

public interface RelationRepository extends JpaRepository<Relation, RelationKey>{

}
