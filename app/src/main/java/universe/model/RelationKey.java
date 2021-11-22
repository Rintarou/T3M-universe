package universe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Embeddable
public class RelationKey implements Serializable {
    @ManyToOne
    @JoinColumn( name = "parent_id", foreignKey = @ForeignKey( name = "relations_parent_element_id_fk") )
    private Element parent;
    @ManyToOne
    @JoinColumn( name = "child_id", foreignKey = @ForeignKey( name = "relations_child_element_id_fk") )
    private Element child;

    public RelationKey() {

    }

    public Element getParent() { return this.parent; }
    
    public Element getChild() { return this.child; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((child == null) ? 0 : child.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
        RelationKey other = (RelationKey) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
    }

}
