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
	private Compte compte_credite;

	public Debit() {
	}

	

	public Debit(Integer id, Date dateOp, Double montant, String libelle, Compte compte) {
		super(id, dateOp, montant, libelle, compte);
	}
	
	public Debit(Integer id, Date dateOp, Double montant, String libelle, Compte compte, Compte compte_credite) {
		super(id, dateOp, montant, libelle, compte);
		this.compte_credite = compte_credite;
	}




	public Compte getCompte_credite() {
		return compte_credite;
	}



	public void setCompte_credite(Compte compte_credite) {
		this.compte_credite = compte_credite;
	}



}