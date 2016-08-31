package fr.afcepf.al28.banque.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "DEBIT")
public class Debit extends Operation {

	@ManyToOne
	@JoinColumn(name="numero_compte_credite")
	private Compte compte;

	public Debit() {
	}

	public Debit(Integer id, Date dateOp, Double montant, String libelle, Compte compte, Compte compte2) {
		super(id, dateOp, montant, libelle, compte);
		compte = compte2;
	}
	
	public Compte getCompte() {
		return compte;
	}

	

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}