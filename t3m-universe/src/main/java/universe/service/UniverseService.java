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
	
	public void save(Universe universe) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Universe>> violations = validator.validate(universe);
		if (violations.isEmpty()) {
			
			if (universe.getUserUniverses() != null) {
				universe.getUserUniverses().forEach(uu -> {
					userUniverseRepository.save(uu);
				});
			}
			universeRepository.save(universe);
		}else {
			throw new UniverseException();
		}
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
	
	public List<Universe> allUniverse() {
		return universeRepository.findAll();
	}
	
	public UserUniverse findUserUniverseById(UserUniverseKey id){
		return userUniverseRepository.findById(id).orElseThrow(UniverseException::new);
	}

}
