package fr.afcepf.al28.banque.entity;
 
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CREDIT")
public class Credit extends Operation {

    public Credit() {
    	super();
    }
    
    public Credit(Integer id, Date dateOp, Double montant, String libelle, Compte compte) {
		super(id, dateOp, montant, libelle, compte);
	}
    

}