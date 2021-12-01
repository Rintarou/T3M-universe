package universe.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import universe.exception.UserException;
import universe.model.User;
import universe.repository.UserRepository;
import universe.repository.UserUniverseRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserUniverseRepository userUniverseRepository;
	
	public User save( User user ) {
		User ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate( user );
		if( violations.isEmpty() ) {
			ret = userRepository.save( user );
		} else {
			throw new UserException();
		}
		return ret;
	}
	
	public void delete(User user) {
		User userInBase = byId(user.getId());
		userUniverseRepository.deleteByUser(userInBase);
		userRepository.delete(userInBase);
	}
	
	public User byId(Long id) {
		return userRepository.findById(id).orElseThrow(UserException::new);
	}
	
	public List<User> byLogin( String name ) {
		return userRepository.findByLogin( name );
	}

	public List<User> allUser() {
		return userRepository.findAll();
	}
	
	
}
