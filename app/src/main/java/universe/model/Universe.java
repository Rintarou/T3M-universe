package universe.model;

import java.util.List;
import java.util.Objects;

public class Universe {
	private Long id;
	private String name;
	//OnetoMany
	private List<UserUniverseKey> userUniverseKeys;
	
	public Universe() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<UserUniverseKey> getUserUniverseKeys() {
		return userUniverseKeys;
	}

	public void setUserUniverseKeys(List<UserUniverseKey> userUniverseKeys) {
		this.userUniverseKeys = userUniverseKeys;
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
		Universe other = (Universe) obj;
		return Objects.equals(id, other.id);
	}
	
	// public void changeRights(UserUniverseKey adminKey, User user, AccessRight accessRight)
	//this==adminKey.getUniverse();
	//adminKey.getAccessRight.equals(AccessRight.owner);
	
	
}
