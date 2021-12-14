package universe.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import universe.exception.UserUniverseException;
import universe.model.UserUniverse;
import universe.repository.UserUniverseRepository;

@Service
public class UserUniverseService {

	@Autowired
	private UserUniverseRepository userUniverseRepository;

	public UserUniverse save(UserUniverse userUniverse) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserUniverse>> violations = validator.validate(userUniverse);
		if (violations.isEmpty()) {
			return userUniverseRepository.save(userUniverse);
		}
		else {
			throw new UserUniverseException();
		}
	}
}
