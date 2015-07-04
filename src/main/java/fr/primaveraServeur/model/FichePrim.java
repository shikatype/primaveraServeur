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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the fiche_prim database table.
 * 
 */
@Entity
@Table(name="fiche_prim")
@NamedQuery(name="FichePrim.findAll", query="SELECT f FROM FichePrim f")
public class FichePrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idfiche;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dateCreation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean rempli;

	@Column(length=45)
	private String latitude;

	@Column(length=45)
	private String longitude;

	@Column(nullable=false, length=45)
	private String titre;

	//bi-directional many-to-one association to DescriptionPrim
	@OneToMany(mappedBy="fichePrim",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<DescriptionPrim> descriptionPrims;

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

	//bi-directional many-to-one association to PhotoPrim
	@OneToMany(mappedBy="fichePrim",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<PhotoPrim> photoPrims;

	//uni-directional many-to-one association to DangerPrim
	@ManyToOne
	@JoinColumn(name="dangerFK", nullable=false)
	private DangerPrim dangerPrim;

	public FichePrim() {
	}

	public FichePrim(Date dateCreation, String latitude, String longitude,
			String titre,
			EtatPrim etatPrim, UserPrim userPrim,
			DangerPrim dangerPrim) {
		this.dateCreation = dateCreation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.titre = titre;
		this.descriptionPrims = new HashSet<DescriptionPrim>();
		this.etatPrim = etatPrim;
		this.userCreateur = userPrim;
		this.photoPrims = new HashSet<PhotoPrim>();
		this.dangerPrim = dangerPrim;
	}

	public int getIdfiche() {
		return this.idfiche;
	}

	public void setIdfiche(int idfiche) {
		this.idfiche = idfiche;
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

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean rempli) {
		this.rempli = rempli;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<DescriptionPrim> getDescriptionPrims() {
		return this.descriptionPrims;
	}

	public void setDescriptionPrims(Set<DescriptionPrim> descriptionPrims) {
		this.descriptionPrims = descriptionPrims;
	}

	public DescriptionPrim addDescriptionPrim(DescriptionPrim descriptionPrim) {
		getDescriptionPrims().add(descriptionPrim);
		descriptionPrim.setFichePrim(this);

		return descriptionPrim;
	}

	public DescriptionPrim removeDescriptionPrim(DescriptionPrim descriptionPrim) {
		getDescriptionPrims().remove(descriptionPrim);
		descriptionPrim.setFichePrim(null);

		return descriptionPrim;
	}

	public EtatPrim getEtatPrim() {
		return this.etatPrim;
	}

	public void setEtatPrim(EtatPrim etatPrim) {
		this.etatPrim = etatPrim;
	}

	public UserPrim getUserCreator() {
		return this.userCreateur;
	}

	public void setUserCreator(UserPrim userCreator) {
		this.userCreateur = userCreator;
	}

	public UserPrim getUserHisto() {
		return this.userHisto;
	}

	public void setUserHisto(UserPrim userHisto) {
		this.userHisto = userHisto;
	}
	
	public Set<PhotoPrim> getPhotoPrims() {
		return this.photoPrims;
	}

	public void setPhotoPrims(Set<PhotoPrim> photoPrims) {
		this.photoPrims = photoPrims;
	}

	public PhotoPrim addPhotoPrim(PhotoPrim photoPrim) {
		getPhotoPrims().add(photoPrim);
		photoPrim.setFichePrim(this);

		return photoPrim;
	}

	public PhotoPrim removePhotoPrim(PhotoPrim photoPrim) {
		getPhotoPrims().remove(photoPrim);
		photoPrim.setFichePrim(null);

		return photoPrim;
	}

	public DangerPrim getDangerPrim() {
		return this.dangerPrim;
	}

	public void setDangerPrim(DangerPrim dangerPrim) {
		this.dangerPrim = dangerPrim;
	}

	@Override
	public String toString() {
		return "FichePrim [idfiche=" + idfiche + ", dateCreation="
				+ dateCreation + ", dateFin=" + dateFin + ", latitude="
				+ latitude + ", longitude=" + longitude + ", titre=" + titre
				+ ", descriptionPrims=" + descriptionPrims + ", etatPrim="
				+ etatPrim + ", userPrim=" + userCreateur + ", photoPrims="
				+ photoPrims + ", dangerPrim=" + dangerPrim + "]";
	}

}