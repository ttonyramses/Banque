package fr.afcepf.al28.banque.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero", nullable = false)
	private Integer numero;
	@Column(name = "libelle", nullable = false)
	private String libelle;

	@Column(name = "solde", nullable = false)
	private Double solde;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	public Compte() {
	}

	public Compte(Integer numero, String libelle, Double solde, Client client) {
		super();
		this.numero = numero;
		this.libelle = libelle;
		this.solde = solde;
		this.client = client;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

}