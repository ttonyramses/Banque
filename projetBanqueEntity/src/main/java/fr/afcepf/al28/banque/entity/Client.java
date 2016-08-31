package fr.afcepf.al28.banque.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "CLIENT")
public class Client extends Utilisateur {

	@Column(name = "firstConnection", nullable=true)
	private Boolean firstConnection;
	
	@OneToMany(mappedBy="client")
	private Set<Compte> comptes;

	@ManyToOne
	@JoinColumn(name="numero_conseiller")
	private Conseiller conseiller;

	public Client() {
	}

	public Client(Integer id, String nom, String prenom, String mdp, String mail, String adresse,
			Boolean firstConnection, Conseiller conseiller) {
		super(id, nom, prenom, mdp, mail, adresse);
		this.firstConnection = firstConnection;
		this.conseiller = conseiller;
	}

	public Boolean getFirstConnection() {
		return firstConnection;
	}

	public void setFirstConnection(Boolean firstConnection) {
		this.firstConnection = firstConnection;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

}