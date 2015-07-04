package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DangerPrim;

public interface DangerDao {

	/**
	 * permet de sauvegarder ou modifier un danger en base
	 * @param danger
	 */
	public void save(DangerPrim danger);
	
	/**
	 * permet de supprimer un danger en base
	 * @param danger
	 */
	public void delete(DangerPrim danger);
	
	
	/**
	 * permet de recuperer tous les dangers
	 * @return
	 */
	public List<DangerPrim> findAll();
	
	/**
	 * permet de recuperer le danger correspondant a l'id
	 * @param id : identifiant du danger
	 * @return
	 */
	public DangerPrim findById(Integer id);
	
	/**
	 * permet de recuperer le danger corresponde au nom
	 * @param name : nom du danger
	 * @return
	 */
	public DangerPrim findByName(String name);
	
	/**
	 * permet de recuperer le danger correspondant au niveau de danger
	 * @param niveauDanger
	 * @return
	 */
	public DangerPrim findByNiveauDanger(Integer niveauDanger);
	
}
