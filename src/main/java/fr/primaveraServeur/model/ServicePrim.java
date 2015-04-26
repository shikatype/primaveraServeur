package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the service_prim database table.
 * 
 */
@Entity
@Table(name="service_prim")
@NamedQuery(name="ServicePrim.findAll", query="SELECT s FROM ServicePrim s")
public class ServicePrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idservice;

	@Column(nullable=false, length=45)
	private String nom;

	public ServicePrim() {
	}

	public ServicePrim(String nom) {
		this.nom = nom;
	}

	public int getIdservice() {
		return this.idservice;
	}

	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "ServicePrim [idservice=" + idservice + ", nom=" + nom + "]";
	}

}