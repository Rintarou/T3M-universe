package universe.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "user_universes")
public class UserUniverse {

	@EmbeddedId
	@JsonView(JsonViews.Common.class)
	private UserUniverseKey id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "access_right", length = 30)
	@JsonView(JsonViews.Common.class)
	private AccessRight accessRight;
	
	public UserUniverse() {
		
	}
	
	public UserUniverse(UserUniverseKey key, AccessRight accessRight) {
		this.id = key;
		this.accessRight = accessRight;
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
