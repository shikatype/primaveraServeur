package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.ServicePrim;

public interface ServiceDao {

	/**
	 * permet de sauvegarder un service ou modifier une fiche en base
	 * @param service
	 */
	public void save(ServicePrim service);
	
	/**
	 * permet de supprimer un service en base
	 * @param service
	 */
	public void delete(ServicePrim service);
	
	
	/**
	 * permet de recuperer tous les services
	 * @return
	 */
	public List<ServicePrim> findAll();
	
	/**
	 * permet de recuperer le service correspondant a l'id
	 * @param id : identifiant du service
	 * @return
	 */
	public ServicePrim findById(Integer id);
	
	/**
	 * permet de recuperer le service correspondant au nom
	 * @param name : nom du service
	 * @return
	 */
	public ServicePrim findByName(String name);
	
}
