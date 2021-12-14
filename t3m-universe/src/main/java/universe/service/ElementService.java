package universe.service;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import universe.exception.ElementException;
import universe.model.Element;
import universe.model.Universe;
import universe.repository.ElementRepository;
import universe.repository.RelationRepository;

@Service
public class ElementService {
    
    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private RelationRepository relationRepository;

    public void delete( Element element ) {
    	Element elementEnBase = byId(element.getId());
    	relationRepository.deleteRelationByElement(elementEnBase);
    	elementRepository.delete(elementEnBase);
	}

	public Set<Element> likeName( String name) {
        return elementRepository.findByNameContaining( name );
    }

    public Element save( Element element ) {
        Element ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Element>> violations = validator.validate( element );
		if( violations.isEmpty() ) {
			// save les relations
			ret = elementRepository.save( element );
		} else {
			throw new ElementException();
		}
		return ret;
    }

	public Element byId( Long id ) {
		return elementRepository.findByIdWithParentAndChild( id ).orElseThrow( ElementException::new );
	}
	
	public Set<Element> byUniverse(Universe universe) {
		return elementRepository.findByUniverse(universe);
	}
    
}
