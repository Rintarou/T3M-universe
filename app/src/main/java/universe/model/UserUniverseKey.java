package universe.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserUniverseKey implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "user_universe_user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "user_universe_universe_id")
	private Universe universe;
	
	public UserUniverseKey() {
		
	}
	
	public UserUniverseKey(User user, Universe universe) {
		this.user = user;
		this.universe = universe;
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
