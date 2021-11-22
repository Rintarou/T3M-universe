package universe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table( name = "relations" )
public class Relation {
    @Column( name = "nature", length = 30 )
    private String nature;
    @ManyToOne
    @JoinColumn( name = "parent_id", foreignKey = @ForeignKey( name = "relations_parent_element_id_fk") )
    private Element parent;
    @ManyToOne
    @JoinColumn( name = "child_id", foreignKey = @ForeignKey( name = "relations_child_element_id_fk") )
    private Element child;
    
    
    public Relation() {
        
    }

    public String getNature() {
        return nature;
    }
    public void setNature(String nature) {
        this.nature = nature;
    }
    public Element getParent() {
        return parent;
    }
    public void setParent(Element parent) {
        this.parent = parent;
    }
    public Element getChild() {
        return child;
    }
    public void setChild(Element child) {
        this.child = child;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((child == null) ? 0 : child.hashCode());
        result = prime * result + ((nature == null) ? 0 : nature.hashCode());
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
        Relation other = (Relation) obj;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        if (nature == null) {
            if (other.nature != null)
                return false;
        } else if (!nature.equals(other.nature))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
    }

    
}
