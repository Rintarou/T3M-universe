package universe.rest;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import universe.exception.UniverseException;
import universe.model.AccessRight;
import universe.model.Element;
import universe.model.JsonViews;
import universe.model.Universe;
import universe.model.UserUniverse;
import universe.service.UniverseService;
import universe.service.UserService;
import universe.service.UserUniverseService;
import universe.service.auth.CustomUserDetails;

@RestController
@RequestMapping("/api/universe")
public class UniverseRestController {
	@Autowired
	private UniverseService universeService;
	@Autowired
	private UserUniverseService userUniverseService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Set<Universe> all() {
		return universeService.allUniverse();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.UniverseWithUsers.class)
	public Universe byId(@PathVariable("id") Long id) {
		return universeService.byId(id);
	}

	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Universe create(@Valid @RequestBody Universe universe, BindingResult br,
			@AuthenticationPrincipal CustomUserDetails cUD) {
		universe.addUser(cUD.getUser(), AccessRight.owner);
		return universeService.save(universe);
	}
	
	@PostMapping( value = "/{id}/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	@ResponseStatus( code = HttpStatus.ACCEPTED )
	public void bindImage( @RequestParam("image") MultipartFile mp, @PathVariable("id") Long id ) throws IOException {
		
		Universe u = universeService.byId( id );
		u.setImage( mp.getBytes() );
		universeService.save( u );
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Universe update(@Valid @PathVariable("id") Long id, @RequestBody Universe universe, BindingResult br) {
		universe.setId(id);
		return universeService.save(universe);
	}

	@PutMapping("/addUserUniverse/{id}")
	@JsonView(JsonViews.Common.class)
	public UserUniverse addUserUniverse(@Valid @RequestBody UserUniverse userUniverse, BindingResult br,
			@PathVariable("id") Long id) {
		if (id == userUniverse.getId().getUniverse().getId()) {
			return userUniverseService.save(userUniverse);
		}
		else {
			throw new UniverseException();
		}

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		universeService.delete(universeService.byId(id));
	}
}
