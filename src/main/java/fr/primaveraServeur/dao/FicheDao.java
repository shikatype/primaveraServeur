package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

public interface FicheDao {

	/**
	 * permet de sauvegarder ou modifier un fiche en base
	 * @param fiche
	 */
	public void save(FichePrim fiche);
	
	
	/**
	 * permet de recuperer la fiche correspondant a lid
	 * @param id : identifiant de la fiche
	 * @return
	 */
	public FichePrim findById(Integer id);
	
	/**
	 * permet de recuperer toutes les fiches
	 * @return
	 */
	public List<FichePrim> findAll();
	
	/**
	 * permet de recuperer toute les fiches affecté a un utilisateur correspondant a l'id
	 * @param userHisto : identifiant de l'utilisateur 
	 * @return
	 */
	public List<FichePrim> findAllByUserHisto(UserPrim userHisto);
	
	/**
	 * recuperation de toutes les fiches correspondant au niveau danger
	 * @param danger
	 * @return
	 */
	public List<FichePrim> findAllByDanger(DangerPrim danger);
	
	/**
	 * recuperation de toutes les fiche correspondant a l'etat
	 * @param etat
	 * @return
	 */
	public List<FichePrim> findAllByEtat(EtatPrim etat);
	
}
