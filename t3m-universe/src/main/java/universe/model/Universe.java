package universe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import universe.exception.LimitedAssignationException;
import universe.exception.UniverseException;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "universes")
@SequenceGenerator(name = "seqUniverses", sequenceName = "seq_universes", allocationSize = 1, initialValue = 100)
public class Universe {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUniverses")
	@JsonView(JsonViews.Common.class)
	private Long id;

	@Column(name = "name", length = 100)
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String name;
	
	@Lob
    @Column( name = "image" )
    @JsonView( JsonViews.Common.class )
    private byte[] image;

	@OneToMany(mappedBy = "id.universe")
	@JsonView(JsonViews.UniverseWithUsers.class)
	private List<UserUniverse> userUniverses;

	@OneToMany(mappedBy = "universe", fetch = FetchType.LAZY)
	private Set<Element> elements;
	
	public Universe() {
		this.userUniverses = new ArrayList<UserUniverse>();
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) throws LimitedAssignationException {
		if( this.id == null) {
			this.id = id;
		} else {
			throw new LimitedAssignationException("Id is already set");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
	
	public void changeRights(UserUniverse admin, User user, AccessRight accessRight) {
		if (this.equals(admin.getId().getUniverse()) && admin.getAccessRight().equals(AccessRight.owner)) {
			int i = 0;
			while(!userUniverses.get(i).getId().getUser().equals(user) && i < userUniverses.size()) {
				System.out.println(i);
				i++;
			}
			if (i < userUniverses.size()) {
				userUniverses.get(i).setAccessRight(accessRight);
			}
		}
	}
	
	public void addUser(User user, AccessRight accessRight) {
		userUniverses.add(new UserUniverse(new UserUniverseKey(user, this), accessRight));
	}
	
	public void addUser(UserUniverse userUniverse) {
		userUniverses.add(userUniverse);
	}
		
	
	
}
