package universe.model;

import java.lang.annotation.Inherited;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table( name = "entities" )
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "type", discriminatorType = DiscriminatorType.STRING, length = 20 )
@SequenceGenerator( name = "seqEntities", sequenceName = "seq_entities", allocationSize = 1, initialValue = 50 )
public abstract class Element {
    @Id
    @Column( name = "id" )
    private Integer id;
    @Column( name = "name" )
    private String name;
    @Column( name = "description" )
    private String description;
    //TODO: private Float date;

    @Column( name = "unique" )
    private Boolean unique;

    @OneToMany( mappedBy = "id.element" )
    private Set<Relation> parentElements;
    @OneToMany( mappedBy = "id.element" )
    private Set<Relation> childElements;
    
    public Element() {
        
    }
    
    public Set<Element> getChildElements() {
        return this.childElements;
    }

    public Set<Element> getParentElements() {
        return parentElements;
    }
    
    public Set<Element> getChildElements( Class<? extends Element> clazz ) {
        //TODO 
        //this.childElements.stream().filter( el -> el instanceof clazz ) ;
        return null;
    }
    
    public Set<Element> getParentElements( Class<? extends Element> c ) {
        //TODO
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Element other = (Element) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
    
}