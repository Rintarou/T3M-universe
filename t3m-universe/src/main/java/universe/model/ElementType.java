package universe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "types" )
@SequenceGenerator( name = "seqTypes", sequenceName = "seq_types", allocationSize = 1, initialValue = 10 )
public class ElementType {
    @Id
    @Column( name = "id" )
    private String id;

    public ElementType( String s ) {
        this.id = s;
    }
}
