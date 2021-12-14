package universe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import universe.service.UniverseService;
import universe.service.auth.CustomUserDetails;

public class CustomWebSecurity {
	
	@Autowired
	private UniverseService universeService;
	
	public boolean checkWrite(Authentication authentication, Long id) {
		String universeName = universeService.byId(id).getName();
		return authentication.getAuthorities().contains(new SimpleGrantedAuthority(universeName+"_owner"))
				|| authentication.getAuthorities().contains(new SimpleGrantedAuthority(universeName+"_readWrite"));
	}
	
	public boolean checkOwner(Authentication authentication, Long id) {
		String universeName = universeService.byId(id).getName();
		return authentication.getAuthorities().contains(new SimpleGrantedAuthority(universeName+"_owner"));
	}
}
