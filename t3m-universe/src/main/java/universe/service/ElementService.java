package universe.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import universe.exception.ElementException;
import universe.model.Element;
import universe.repository.ElementRepository;


/**
 * ElementService class;
 * wraps ElementRepository and provides a layer of verification
 * 
 * Methods:
 * save, delete, 
 */

@Service
public class ElementService {
    
    @Autowired
    private ElementRepository elementRepository;

    public void delete( Element element ) throws Exception {
        
		Element e = elementRepository.findById( element.getId() ).orElseThrow(Exception::new);
		elementRepository.delete(e);
	}

    public Element save( Element element ) {
        Element ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Element>> violations = validator.validate( element );
		if( violations.isEmpty() ) {
			ret = elementRepository.save( element );
		} else {
			throw new ElementException();
		}
		return ret;
    }

	public Element byId( Long id ) {
		return elementRepository.findById( id ).orElseThrow( ElementException::new );
	}
    
}
