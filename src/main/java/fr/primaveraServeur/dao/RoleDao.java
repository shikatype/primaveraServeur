package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.RolePrim;

public interface RoleDao {

	/**
	 * permet de sauvegarder ou modifier un role en base
	 * @param role
	 */
	public void save(RolePrim role);
	
	/**
	 * permet de supprimer un role en base
	 * @param role
	 */
	public void delete(RolePrim role);
	
	
	/**
	 * permet de recuperer tous les role en base
	 * @return
	 */
	public List<RolePrim> findAll();
	
	/**
	 * permet de recuperer le role correspondant a l'id
	 * @param id : identifiant du role 
	 * @return
	 */
	public RolePrim findById(Integer id);
	
	/**
	 * permet de recuperer le role correspondant au nom
	 * @param name : nom du role
	 * @return
	 */
	public RolePrim findByName(String name);
	
}
