package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;

public interface EtatDao {

	/**
	 * permet de sauvegarder ou modifier un etat en base
	 * @param etat
	 */
	public void save(EtatPrim etat);
	
	/**
	 * permet de supprimer un etat en base
	 * @param etat
	 */
	public void delete(EtatPrim etat);
	
	
	/**
	 * permet de recuperer tous les etats
	 * @return
	 */
	public List<EtatPrim> findAll();
	
	/**
	 * permet de recuperer l'etat correspondant a l'id
	 * @param id : identifiant de l'etat
	 * @return
	 */
	public EtatPrim findById(Integer id);
	
	/**
	 * permet de recuperer l'etat correspondant au nom
	 * @param etat : nom de l'etat
	 * @return
	 */
	public EtatPrim findByName(String etat);
	
}
