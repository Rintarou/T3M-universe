package universe.repositories;

import javax.lang.model.element.Element;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {

}
