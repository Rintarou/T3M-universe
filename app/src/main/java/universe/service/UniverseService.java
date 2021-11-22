package universe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import universe.repositories.UniverseRepository;

@Service
public class UniverseService {
	
	@Autowired
	private UniverseRepository universeRepository;

}
