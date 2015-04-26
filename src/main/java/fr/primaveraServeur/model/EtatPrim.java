package fr.primaveraServeur.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the etat_prim database table.
 * 
 */
@Entity
@Table(name="etat_prim")
@NamedQuery(name="EtatPrim.findAll", query="SELECT e FROM EtatPrim e")
public class EtatPrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idetat;

	@Column(nullable=false, length=45)
	private String etat;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean groupe;
	
	//uni-directional many-to-many association to ServicePrim
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinTable(name="etat_role_prim", 
	joinColumns=@JoinColumn(name="etatFK"),
	inverseJoinColumns=@JoinColumn(name="roleFK"))
	private Set<RolePrim> rolePrims;

	public EtatPrim() {
	}

	public EtatPrim(String etat,boolean groupe) {
		this.etat = etat;
		this.groupe = groupe;
		rolePrims=new HashSet<RolePrim>();
	}

	public int getIdetat() {
		return this.idetat;
	}

	public void setIdetat(int idetat) {
		this.idetat = idetat;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isGroupe() {
		return groupe;
	}

	public void setGroupe(boolean groupe) {
		this.groupe = groupe;
	}
	
	public Set<RolePrim> getRolePrims() {
		return this.rolePrims;
	}

	public void setRolePrims(Set<RolePrim> rolePrims) {
		this.rolePrims = rolePrims;
	}
	
	public void addRole(RolePrim role){
		this.rolePrims.add(role);
	}

	@Override
	public String toString() {
		return "EtatPrim [idetat=" + idetat + ", etat=" + etat
				+", groupe=" + groupe
				 + ", rolePrim="+ rolePrims + "]";
	}

}