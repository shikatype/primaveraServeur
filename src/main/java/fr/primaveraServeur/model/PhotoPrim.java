package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the photo_prim database table.
 * 
 */
@Entity
@Table(name="photo_prim")
@NamedQuery(name="PhotoPrim.findAll", query="SELECT p FROM PhotoPrim p")
public class PhotoPrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idphoto;

	@Column(nullable=false, length=45)
	private String lien;

	//bi-directional many-to-one association to FichePrim
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ficheFK", nullable=true)
	private FichePrim fichePrim;

	public PhotoPrim() {
	}

	public PhotoPrim(String lien) {
		super();
		this.lien = lien;
	}

	public int getIdphoto() {
		return this.idphoto;
	}

	public void setIdphoto(int idphoto) {
		this.idphoto = idphoto;
	}

	public String getLien() {
		return this.lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public FichePrim getFichePrim() {
		return this.fichePrim;
	}

	public void setFichePrim(FichePrim fichePrim) {
		this.fichePrim = fichePrim;
	}

	@Override
	public String toString() {
		return "PhotoPrim [idphoto=" + idphoto + ", lien=" + lien + "]";
	}

}