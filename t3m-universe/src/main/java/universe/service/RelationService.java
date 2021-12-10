package universe.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import universe.exception.RelationException;
import universe.model.Relation;
import universe.model.RelationKey;
import universe.repository.RelationRepository;

@Service
public class RelationService {
    
    @Autowired
    private RelationRepository relationRepository;

    public void delete( Relation relation ) {
        relationRepository.delete( relation );
    }

    public Relation byId( RelationKey id ) {
		return relationRepository.findById( id ).orElseThrow( RelationException::new );
	}

    public Set<String> likeName( String name) {
        //TODO return relationRepository.findMatchingNames( name );
        return null;
    }

    public Relation save( Relation relation ) {
        Relation ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Relation>> violations = validator.validate( relation );
		if( violations.isEmpty() ) {
			// save les relations
			// save l'univers ?
			ret = relationRepository.save( relation );
		} else {
			throw new RelationException();
		}
		return ret;
    }
}
