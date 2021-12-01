package universe.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import universe.model.User;

public class CustomUserDetails implements UserDetails{

	private User user;
	
	public CustomUserDetails(User user) {
		this.user=user;
	}
	
	
	public User getUser() {
		return user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		user.getUserUniverses().forEach(userUniverse -> {
			//authorities.add(new SimpleGrantedAuthority(userUniverse.getAccessRight().toString()));
			authorities.add(new SimpleGrantedAuthority
					(userUniverse.getId().getUniverse().getName() + "_" + userUniverse.getAccessRight().toString()));
			// owner ; read ; readWrite
			// hashUniver_owner ; hashUniver_read ; hashUniver_readWrite
		});
		authorities.add(new SimpleGrantedAuthority("USER"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnable();
	}

}
