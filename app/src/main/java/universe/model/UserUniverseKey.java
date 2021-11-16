package universe.model;

import java.util.Objects;

public class UserUniverseKey {
	private AccessRight accessRight;
	// OneToOne
	private User user;
	// OneToOne
	private Universe universe;
	
	public UserUniverseKey() {
		
	}
	
	public AccessRight getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(AccessRight accessRight) {
		this.accessRight = accessRight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Universe getUniverse() {
		return universe;
	}
	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(universe, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserUniverseKey other = (UserUniverseKey) obj;
		return Objects.equals(universe, other.universe) && Objects.equals(user, other.user);
	}
	
	
	
	
}
