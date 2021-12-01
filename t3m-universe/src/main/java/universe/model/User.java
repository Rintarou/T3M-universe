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
import javax.validation.constraints.NotEmpty;

import org.springframework.data.web.JsonPath;

import universe.exception.UserException;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seqUsers", sequenceName = "seq_users", allocationSize = 1, initialValue = 100)
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsers")
	@JsonView(JsonViews.Common.class)
	private Long id;

	@Column(name = "login", length = 100)
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String login;

	@Column(name = "password", length = 100)
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String password;
	
	@OneToMany(mappedBy = "id.user")
	//rajouter requête pour remonter la liste des univers + créer projection
	private List<UserUniverse> userUniverses;
	
	public User(){
		
	}

	public Long getId() {
		return id;
	}

	//@Once
	public void setId(Long id) throws UserException {
		if( this.id == null ) { 
			this.id = id;
		} else {
			throw new UserException("Id is already set");
		}
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
