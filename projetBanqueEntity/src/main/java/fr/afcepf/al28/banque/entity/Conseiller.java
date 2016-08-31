package fr.afcepf.al28.banque.entity;
 
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "CONSEILLER")
public class Conseiller extends Utilisateur {
	
	 @OneToMany(mappedBy = "conseiller")
		private Set<Client> clients;

    public Conseiller() {
    }

    public Conseiller(Integer id, String nom, String prenom, String mdp, String mail, String adresse) {
		super(id, nom, prenom, mdp, mail, adresse);
	}

   


	public Set<Client> getClients() {
		return clients;
	}


	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	

}