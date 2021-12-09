package universe.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import universe.model.AccessRight;
import universe.model.JsonViews;
import universe.model.Universe;
import universe.service.UniverseService;
import universe.service.auth.CustomUserDetails;

@RestController
@RequestMapping("/api/universe")
public class UniverseRestController {
	@Autowired
	private UniverseService universeService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Universe> all(){
		return universeService.allUniverse();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.UniverseWithUsers.class)
	public Universe byId(@PathVariable("id") Long id) {
		return universeService.byId(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code=HttpStatus.CREATED)
	public Universe create(@Valid @RequestBody Universe universe, BindingResult br, @AuthenticationPrincipal CustomUserDetails cUD) {
		universe.addUser(cUD.getUser(), AccessRight.owner);
		universeService.save(universe);
		return universe;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Universe update(@Valid @PathVariable("id") Long id, @RequestBody Universe universe, BindingResult br) {
		universe.setId(id);
		universeService.save(universe);
		return universe;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		universeService.delete(universeService.byId(id));
	}
}
