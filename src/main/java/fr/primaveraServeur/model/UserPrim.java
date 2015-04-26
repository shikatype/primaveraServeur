package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user_prim database table.
 * 
 */
@Entity
@Table(name="user_prim")
@NamedQuery(name="UserPrim.findAll", query="SELECT u FROM UserPrim u")
public class UserPrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iduser;

	@Column(nullable=false, length=45)
	private String addresseMail;

	@Column(length=45)
	private String affiliation;

	@Column(nullable=false, length=45)
	private String mdp;

	@Column(length=45)
	private String nom;

	@Column(length=45)
	private String prénom;

	//uni-directional many-to-one association to RolePrim
	@ManyToOne
	@JoinColumn(name="roleFK")
	private RolePrim rolePrim;

	public UserPrim() {
	}

	public UserPrim(String addresseMail, String mdp) {
		this.addresseMail = addresseMail;
		this.mdp = mdp;
	}

	public UserPrim(String addresseMail, String affiliation, String mdp,
			String nom, String prénom, RolePrim rolePrim) {
		this.addresseMail = addresseMail;
		this.affiliation = affiliation;
		this.mdp = mdp;
		this.nom = nom;
		this.prénom = prénom;
		this.rolePrim = rolePrim;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getAddresseMail() {
		return this.addresseMail;
	}

	public void setAddresseMail(String addresseMail) {
		this.addresseMail = addresseMail;
	}

	public String getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return this.prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public RolePrim getRolePrim() {
		return this.rolePrim;
	}

	public void setRolePrim(RolePrim rolePrim) {
		this.rolePrim = rolePrim;
	}

	@Override
	public String toString() {
		return "UserPrim [iduser=" + iduser + ", addresseMail=" + addresseMail
				+ ", affiliation=" + affiliation + ", mdp=" + mdp + ", nom="
				+ nom + ", prénom=" + prénom + ", rolePrim=" + rolePrim + "]";
	}

}