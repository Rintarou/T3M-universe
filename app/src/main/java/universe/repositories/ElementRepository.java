package universe.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import universe.model.Element;

public interface ElementRepository extends JpaRepository<Element, Long> {

}
