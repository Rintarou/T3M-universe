package universe.rest;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import universe.model.JsonViews;
import universe.model.Universe;
import universe.model.Character;
import universe.model.Element;
import universe.service.ElementService;
import universe.service.RelationService;
import universe.service.UniverseService;

@RestController
@RequestMapping("/api/{universe_id}/element") 
public class ElementRestController {

	@Autowired
    private UniverseService universeService;
    
	@Autowired
	private ElementService elementService;
	
	
	@GetMapping("")
	@JsonView( JsonViews.Common.class )
	public Set<Element> findAllByUniverse(@PathVariable("universe_id") Long universe_id) {
		return elementService.byUniverse(universeService.byId(universe_id));
	}
	

	@GetMapping("/{id}")
	@JsonView( JsonViews.Common.class )
	public Element byId( @PathVariable("id") Long id ) { //@PathVariable("universe_id") Long universe_id,
		return elementService.byId( id );
	}

	@PostMapping("")
	@JsonView( JsonViews.ElementWithUniverse.class )
	@ResponseStatus( code = HttpStatus.CREATED )
	public Element create( @Valid @RequestBody Element element, BindingResult br) {
		return elementService.save( element );
	}
	
	@PutMapping("/{id}")
	@JsonView( JsonViews.ElementWithUniverse.class )
	public Element update(@Valid @RequestBody Element element, BindingResult br, @PathVariable("id") Long id) {
		element.setId(id);
		return elementService.save(element);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus( code = HttpStatus.NO_CONTENT )
	public void delete(@PathVariable("id") Long id) {
		elementService.delete(elementService.byId(id));
	}
	
}
