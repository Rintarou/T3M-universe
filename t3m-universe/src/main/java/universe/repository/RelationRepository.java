package universe.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import universe.model.Element;
import universe.model.Relation;
import universe.model.RelationKey;

public interface RelationRepository extends JpaRepository<Relation, RelationKey>{

    @Transactional
    @Modifying
    @Query("delete from Relation r where r.id.child=:element or r.id.parent=:element")
    void deleteRelationByElement( @Param("element") Element element );

    //@Query("select r from Relation r where r.natures.contains(:nature)")
    //Set<Relation> findByNatures( @Param("nature") String nature );

    
}
