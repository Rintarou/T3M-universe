package universe.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "universes")
@SequenceGenerator(name = "seqUniverses", sequenceName = "seq_universes", allocationSize = 1, initialValue = 100)
public class Universe {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUniverses")
	private Long id;
	@Column(name = "name", length = 100)
	private String name;
	@OneToMany(mappedBy = "id.universes")
	private List<UserUniverse> userUniverses;
	@OneToMany(mappedBy = "id.universes", fetch = FetchType.LAZY)
	private Set<Element> elements;
	
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
		Universe other = (Universe) obj;
		return Objects.equals(id, other.id);
	}
	
//	public void changeRights(UserUniverse admin, User user, AccessRight accessRight) {
//		if (this==admin.getId().getUniverse() && admin.getAccessRight().equals(AccessRight.owner)) {
//			
//		}
//		
//	}
		
	
	
}
