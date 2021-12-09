package universe.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("character")
public class Character extends Element {
    
    public Character() {
        super();
    }
}
