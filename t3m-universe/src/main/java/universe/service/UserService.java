package universe.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save( User user ) {
		User ret = null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate( user );
		if( violations.isEmpty() ) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnable(true);
			ret = userRepository.save( user );
		} else {
			throw new UserException();
		}
			return ret;
	}
	
	public void delete( User user ) {
		User userInBase = byId(user.getId());
		userUniverseRepository.deleteByUser(userInBase);
		userRepository.delete(userInBase);
	}
	
	public User byId(Long id) {
		return userRepository.findById(id).orElseThrow(UserException::new);
	}
	
	public List<User> byLogin( String name ) {
		return userRepository.findByLoginContaining( name );
	}

	public List<User> allUser() {
		return userRepository.findAll();
	}
	
	public User byIdWithUniverses(Long id) {
		return userRepository.findByIdWithUniverses(id).orElseThrow(UserException::new);
	}
	
	public List<User> allUserWithUniverses() {
		return userRepository.findAllWithUniverses();
	}

	
}
