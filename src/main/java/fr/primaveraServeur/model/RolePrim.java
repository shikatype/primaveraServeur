package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the role_prim database table.
 * 
 */
@Entity
@Table(name="role_prim")
@NamedQuery(name="RolePrim.findAll", query="SELECT r FROM RolePrim r")
public class RolePrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idrole;

	@Column(nullable=false, length=45)
	private String nom;

	//uni-directional many-to-many association to ServicePrim
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinTable(name="role_service_prim", 
	joinColumns=@JoinColumn(name="roleFK"),
	inverseJoinColumns=@JoinColumn(name="serviceFK"))
	private Set<ServicePrim> servicePrims;
	
	//uni-directional many-to-many association to ServicePrim
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinTable(name="etat_role_prim", 
	joinColumns=@JoinColumn(name="roleFK"),
	inverseJoinColumns=@JoinColumn(name="etatFK"))
	private Set<EtatPrim> etatPrims;

	public RolePrim() {
	}

	public RolePrim(String nom) {
		this.nom = nom;
		this.servicePrims =new HashSet<ServicePrim>();
		this.etatPrims =new HashSet<EtatPrim>();
	}

	public RolePrim(String nom, Set<ServicePrim> servicePrims) {
		this.nom = nom;
		this.servicePrims = servicePrims;
	}

	public int getIdrole() {
		return this.idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<ServicePrim> getServicePrims() {
		return this.servicePrims;
	}

	public void setServicePrims(Set<ServicePrim> servicePrims) {
		this.servicePrims = servicePrims;
	}
	
	public void addService(ServicePrim service){
		this.servicePrims.add(service);
	}
	
	public Set<EtatPrim> getEtatPrims() {
		return this.etatPrims;
	}

	public void setEtatPrims(Set<EtatPrim> etatPrims) {
		this.etatPrims = etatPrims;
	}
	
	public void addEtat(EtatPrim etat){
		this.etatPrims.add(etat);
	}

	@Override
	public String toString() {
		return "RolePrim [idrole=" + idrole + ", nom=" + nom
				+  ", servicePrims=" + servicePrims + "]";
	}

}