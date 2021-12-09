package universe.rest;


import java.util.HashSet;
import java.util.List;

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
import universe.model.Character;
import universe.model.Element;
import universe.service.ElementService;

@RestController
@RequestMapping("/api/element")
public class ElementRestController {
    @Autowired
	private ElementService elementService;
	
	@GetMapping("")
	@JsonView( JsonViews.Common.class )
	public Element find() {
		Element ret = new Character();

		ret.setName("Jester");
        ret.setDescription("A blue tiefling cleric, with great humour and personnality");
        ret.setUnique( true );

        return ret;
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Element byId( @PathVariable("id") Long id ) {
		return elementService.byId( id );
	}

	@PostMapping("")
	@JsonView( JsonViews.Common.class )
	@ResponseStatus( code = HttpStatus.CREATED )
	public Element create( @Valid @RequestBody Element element, BindingResult br ) {
		return elementService.save( element );
	}
	
	// @GetMapping("/{id}")
	// @JsonView(JsonViews.UniverseWithUsers.class)
	// public Universe byId(@PathVariable("id") Long id) {
	// 	return universeService.byId(id);
	// }
	
	// @PostMapping("")
	// @JsonView(JsonViews.Common.class)
	// @ResponseStatus(code=HttpStatus.CREATED)
	// public Universe create(@Valid @RequestBody Universe universe, BindingResult br) {
	// 	universeService.save(universe);
	// 	return universe;
	// }
	
	// @PutMapping("/{id}")
	// @JsonView(JsonViews.Common.class)
	// public Universe update(@Valid @PathVariable("id") Long id, @RequestBody Universe universe, BindingResult br) {
	// 	universe.setId(id);
	// 	universeService.save(universe);
	// 	return universe;
	// }
	
	// @DeleteMapping("/{id}")
	// @ResponseStatus(code=HttpStatus.NO_CONTENT)
	// public void delete(@PathVariable("id") Long id) {
	// 	universeService.delete(universeService.byId(id));
	// }
}
