package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

public interface DescriptionDao {
	
	/**
	 * permet de recuperer la description correspondant a l'id
	 * @param id : identifiant de la description
	 * @return
	 */
	public DescriptionPrim findById(Integer id);
	
	/**
	 * permet de recuperer toutes les descriptions
	 * @return
	 */
	public List<DescriptionPrim> findAll();
	
	/**
	 * permet de recuperer toutes les descriptions d'un utilisateur
	 * @param user
	 * @return
	 */
	public List<DescriptionPrim> findAllByUser(UserPrim user);
	
	/**
	 * permet de recuperer toutes les descriptions d'une fiche
	 * @param fiche
	 * @return
	 */
	public List<DescriptionPrim> findAllByFiche(FichePrim fiche);
	
}
