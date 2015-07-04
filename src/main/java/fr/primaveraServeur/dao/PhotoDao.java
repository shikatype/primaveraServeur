package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.PhotoPrim;

public interface PhotoDao {
	
	/**
	 * permet de recuperer toutes les photos
	 * @return
	 */
	public List<PhotoPrim> findAll();
	
	/**
	 * permet de recuperer toutes les photos par fiche
	 * @param fiche
	 * @return
	 */
	public List<PhotoPrim> findAllByFiche(FichePrim fiche);
	
	/**
	 * permet de recuperer la photo correspondant a l'id
	 * @param id : identifiant de la photo
	 * @return
	 */
	public PhotoPrim findById(Integer id);
	
	/**
	 * permet de recuperer la photo correspondant au lien
	 * @param name : lien de la photo
	 * @return
	 */
	public PhotoPrim findByName(String name);
	
}
