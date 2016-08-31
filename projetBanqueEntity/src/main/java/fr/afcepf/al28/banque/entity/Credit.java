package fr.afcepf.al28.banque.entity;
 
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CREDIT")
public class Credit extends Operation {

    public Credit() {
    	super();
    }

}