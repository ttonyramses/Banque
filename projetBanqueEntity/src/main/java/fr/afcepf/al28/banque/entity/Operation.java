package fr.afcepf.al28.banque.entity;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_operation")
public class Operation {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable= false)
    private Integer id;
	
	@Column(name="dateOp", nullable= false)
    private Date dateOp;
	
	@Column(name="montant", nullable= false)
    private Double montant;
	
	@Column(name="libelle", nullable= false)
    private String libelle;

	@ManyToOne
	@JoinColumn(name="numero_compte")
    private Compte compte;

    public Operation() {
    }

	public Operation(Integer id, Date dateOp, Double montant, String libelle, Compte compte) {
		super();
		this.id = id;
		this.dateOp = dateOp;
		this.montant = montant;
		this.libelle = libelle;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateOp() {
		return dateOp;
	}

	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

    
}