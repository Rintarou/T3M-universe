package universe.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table( name = "relations" )
public class Relation {
    @ElementCollection
    @JsonView(JsonViews.Common.class)
    private Set<String> natures;

    @EmbeddedId
    private RelationKey id;
    
    public Relation() {
        
    }

    public Set<String> getNatures() {
        return natures;
    }

    public RelationKey getId() { return this.id; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Relation other = (Relation) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
