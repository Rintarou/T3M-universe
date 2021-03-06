package universe.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import universe.model.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {

    @Query("select e from Element e where e.id=:id")
    Optional<Element> findById( @Param("id") Long id );

    @Query("select e from Element e where e.name=:name")
    Set<Element> findByName( @Param("name") String name );

    // // @Query("from :Class")
    // // Set<? extends Element> findByType( @Param("Class") String s );

    // @Transactional
    // @Modifying
    // @Query("delete from Element e where e=:element")
    // void delete( @Param("element") Element element );
    
    // @Transactional
    // @Modifying
    // @Query("delete from Element e where e.id =:id")
    // void deleteById( @Param("id") Long id );

    
}
