package universe.model;

import java.util.List;
import java.util.Objects;

public class User {
	private Long id;
	private String login;
	private String password;
	//OnetoMany
	private List<UserUniverseKey> userUniverseKeys;
	
	public User(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	// renvoie le droit d'accès à partir d'un univers
	
	
}
