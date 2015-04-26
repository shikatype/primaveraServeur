package fr.primaveraServeur.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the danger_prim database table.
 * 
 */
@Entity
@Table(name="danger_prim")
@NamedQuery(name="DangerPrim.findAll", query="SELECT d FROM DangerPrim d")
public class DangerPrim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int iddanger;

	@Column(name="niveau_danger", nullable=false)
	private int niveauDanger;

	@Column(nullable=false, length=45)
	private String nom;

	public DangerPrim() {
	}

	public DangerPrim(int niveauDanger, String nom) {
		this.niveauDanger = niveauDanger;
		this.nom = nom;
	}

	public int getIddanger() {
		return this.iddanger;
	}

	public void setIddanger(int iddanger) {
		this.iddanger = iddanger;
	}

	public int getNiveauDanger() {
		return this.niveauDanger;
	}

	public void setNiveauDanger(int niveauDanger) {
		this.niveauDanger = niveauDanger;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "DangerPrim [iddanger=" + iddanger + ", niveauDanger="
				+ niveauDanger + ", nom=" + nom + "]";
	}

}