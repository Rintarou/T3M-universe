package universe.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import universe.exception.UniverseException;
import universe.model.Universe;
import universe.model.UserUniverse;
import universe.model.UserUniverseKey;
import universe.repository.UniverseRepository;
import universe.repository.UserUniverseRepository;

@Service
public class UniverseService {
	
	@Autowired
	private UniverseRepository universeRepository;
	
	@Autowired
	private UserUniverseRepository userUniverseRepository;
	
	public Universe save( Universe universe ) {
		Universe ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Universe>> violations = validator.validate(universe);
		if (violations.isEmpty()) {
			ret = universeRepository.save(universe);
			userUniverseRepository.saveAll(universe.getUserUniverses());
			
			
//			List<UserUniverse> userUniverses = universe.getUserUniverses(); 
//			if (userUniverses != null) {
//				userUniverses.forEach( uu -> {
//					userUniverseRepository.save(uu);
//				} );
//			}
			
		} else {
			throw new UniverseException();
		}
		return ret;
	}
	
	public void delete(Universe universe) {
		Universe universeInBase = byId(universe.getId());
		userUniverseRepository.deleteByUniverse(universeInBase);
		universeRepository.delete(universeInBase);
	}
	
	public Universe byIdWithUserUniverses(Long id) {
		return universeRepository.findByIdWithUserUniverses(id).orElseThrow(UniverseException::new);
	}
	
	public Universe byId(Long id) {
		return universeRepository.findById(id).orElseThrow(UniverseException::new);
	}
	
	public Set<Universe> allUniverse() {
		return universeRepository.all();
	}
	
	public UserUniverse findUserUniverseById(UserUniverseKey id){
		return userUniverseRepository.findById(id).orElseThrow(UniverseException::new);
	}

}
