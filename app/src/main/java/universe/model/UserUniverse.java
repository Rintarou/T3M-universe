package universe.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_universe")
public class UserUniverse {
	@EmbeddedId
	private UserUniverseKey id;
	private AccessRight accessRight;
	
	public UserUniverse() {
		
	}
	
	public AccessRight getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(AccessRight accessRight) {
		this.accessRight = accessRight;
	}
	
	public UserUniverseKey getId() {
		return id;
	}
	
	public void setId(UserUniverseKey id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserUniverse other = (UserUniverse) obj;
		return Objects.equals(id, other.id);
	}
	

}
