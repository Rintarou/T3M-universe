package universe.rest;

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
import universe.model.User;
import universe.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<User> all(){
		return userService.allUser();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public User byId(@PathVariable("id") Long id) {
		return userService.byId(id);
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code=HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user, BindingResult br) {
		userService.save(user);
		return user;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public User update(@Valid @PathVariable("id") Long id, @RequestBody User user, BindingResult br) {
		user.setId(id);
		userService.save(user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		userService.delete(userService.byId(id));
	}
	
	
	
	
	
}
