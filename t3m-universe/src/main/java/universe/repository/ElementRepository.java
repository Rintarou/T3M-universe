package universe.repository;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import universe.model.Element;
import universe.model.Universe;

public interface ElementRepository extends JpaRepository<Element, Long> {

    @Query("select e from Element e left join fetch e.parentElements left join fetch e.childElements where e.id=:id")
    @Transactional
    Optional<Element> findByIdWithParentAndChild( @Param("id") Long id );

    Set<Element> findByNameContaining( @Param("name") String name );
    
    Set<Element> findByUniverse( Universe universe );

//    @Query("from :Class")
//    Set<? extends Element> findByType( @Param("Class") String s );

//    @Transactional
//    @Modifying
//    @Query("delete from Element e where e=:element")
//    void delete( @Param("element") Element element );
    
}
