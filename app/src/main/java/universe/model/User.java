package universe.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_")
@SequenceGenerator(name = "seqUser", sequenceName = "seq_user", allocationSize = 1, initialValue = 100)
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
	private Long id;
	@Column(name = "login", length = 100)
	private String login;
	@Column(name = "password", length = 100)
	private String password;
	@OneToMany(mappedBy = "id.user")
	private List<UserUniverse> userUniverses;
	
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

	public List<UserUniverse> getUserUniverses() {
		return userUniverses;
	}

	public void setUserUniverses(List<UserUniverse> userUniverses) {
		this.userUniverses = userUniverses;
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
		
	
}
