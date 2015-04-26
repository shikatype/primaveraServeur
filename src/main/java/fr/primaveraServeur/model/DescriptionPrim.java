package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the description_prim database table.
 * 
 */
@Entity
@Table(name="description_prim")
@NamedQuery(name="DescriptionPrim.findAll", query="SELECT d FROM DescriptionPrim d")
public class DescriptionPrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iddescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dateCreation;

	@Column(nullable=false, length=45)
	private String description;

	//bi-directional many-to-one association to FichePrim
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ficheFK", nullable=true)
	private FichePrim fichePrim;

	//uni-directional many-to-one association to UserPrim
	@ManyToOne
	@JoinColumn(name="userCreateurFK", nullable=false)
	private UserPrim userPrim;

	public DescriptionPrim() {
	}

	public DescriptionPrim(Date dateCreation, String description,
			UserPrim userPrim) {
		this.dateCreation = dateCreation;
		this.description = description;
		this.userPrim = userPrim;
	}

	public int getIddescription() {
		return this.iddescription;
	}

	public void setIddescription(int iddescription) {
		this.iddescription = iddescription;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FichePrim getFichePrim() {
		return this.fichePrim;
	}

	public void setFichePrim(FichePrim fichePrim) {
		this.fichePrim = fichePrim;
	}

	public UserPrim getUserPrim() {
		return this.userPrim;
	}

	public void setUserPrim(UserPrim userPrim) {
		this.userPrim = userPrim;
	}

	@Override
	public String toString() {
		return "DescriptionPrim [iddescription=" + iddescription
				+ ", dateCreation=" + dateCreation + ", description="
				+ description + ", userPrim=" + userPrim + "]";
	}

}