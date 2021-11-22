package universe.service;

import org.springframework.beans.factory.annotation.Autowired;

import universe.model.Element;
import universe.repositories.ElementRepository;

public class ElementService {
    
    @Autowired
    private ElementRepository elementRepository;

    public void delete( Element element ) {
        
		Element e = elementRepository.findById( element.getId() ).orElseThrow(Exception::new);
		//elementRepository.removeClientFromCommandeByClient(e);
		elementRepository.delete(e);
	}
    
}
