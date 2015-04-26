package fr.primaveraServeur.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the groupe_prim database table.
 * 
 */
@Entity
@Table(name="groupe_prim")
@NamedQuery(name="GroupePrim.findAll", query="SELECT g FROM GroupePrim g")
public class GroupePrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idgroupe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dateCreation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	@Column(nullable=false, length=45)
	private String description;

	@Column(nullable=false, length=45)
	private String titre;

	//uni-directional many-to-one association to EtatPrim
	@ManyToOne
	@JoinColumn(name="etatFK", nullable=false)
	private EtatPrim etatPrim;

	//uni-directional many-to-one association to UserPrim
	@ManyToOne
	@JoinColumn(name="userCreateurFK", nullable=false)
	private UserPrim userCreateur;

	//uni-directional many-to-one association to UserPrim
	@ManyToOne
	@JoinColumn(name="userHistoFK")
	private UserPrim userHisto;

	//uni-directional many-to-many association to FichePrim
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="groupe_fiche_prim", 
	joinColumns=@JoinColumn(name="groupeFK"),
	inverseJoinColumns=@JoinColumn(name="ficheFK"))
	private Set<FichePrim> fichePrims;

	public GroupePrim() {
	}

	public GroupePrim(Date dateCreation,
			String description, String titre, EtatPrim etatPrim,
			UserPrim userCreateur) {
		this.dateCreation = dateCreation;
		this.description = description;
		this.titre = titre;
		this.etatPrim = etatPrim;
		this.userCreateur = userCreateur;
		this.fichePrims = new HashSet<FichePrim>();
	}

	public int getIdgroupe() {
		return this.idgroupe;
	}

	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public EtatPrim getEtatPrim() {
		return this.etatPrim;
	}

	public void setEtatPrim(EtatPrim etatPrim) {
		this.etatPrim = etatPrim;
	}

	public UserPrim getUserCreateur() {
		return this.userCreateur;
	}

	public void setUserCreateur(UserPrim userCreateur) {
		this.userCreateur = userCreateur;
	}

	public UserPrim getUserHisto() {
		return this.userHisto;
	}

	public void setUserHisto(UserPrim userHisto) {
		this.userHisto = userHisto;
	}

	public Set<FichePrim> getFichePrims() {
		return this.fichePrims;
	}

	public void setFichePrims(Set<FichePrim> fichePrims) {
		this.fichePrims = fichePrims;
	}

	@Override
	public String toString() {
		return "GroupePrim [idgroupe=" + idgroupe + ", dateCreation="
				+ dateCreation + ", dateFin=" + dateFin + ", description="
				+ description + ", titre=" + titre + ", etatPrim=" + etatPrim
				+ ", userPrim1=" + userCreateur + ", userPrim2=" + userHisto
				+ ", fichePrims=" + fichePrims + "]";
	}

}