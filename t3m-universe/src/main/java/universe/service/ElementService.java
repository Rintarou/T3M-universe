package universe.service;

import org.springframework.beans.factory.annotation.Autowired;

import universe.model.Element;
import universe.repository.ElementRepository;

public class ElementService {
    
    @Autowired
    private ElementRepository elementRepository;

    public void delete( Element element ) throws Exception {
        
		Element e = elementRepository.findById( element.getId() ).orElseThrow(Exception::new);
		//elementRepository.removeClientFromCommandeByClient(e);
		elementRepository.delete(e);
	}
    
}
