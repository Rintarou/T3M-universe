package universe.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import universe.model.JsonViews;
import universe.model.User;
import universe.service.auth.CustomUserDetails;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*")
public class AuthRestController {
	
	@GetMapping("")
	@JsonView(JsonViews.UserWithUniverses.class)
	public User login(@AuthenticationPrincipal CustomUserDetails cUD){
		return cUD.getUser();
	}

}