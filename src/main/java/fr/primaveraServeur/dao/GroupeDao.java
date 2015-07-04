package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

public interface GroupeDao {

	/**
	 * permet de sauvegarder ou modifier un groupe de fiche en base
	 * @param groupe
	 */
	public void save(GroupePrim groupe);
	
	
	/**
	 * permet de recuperer le groupe de fiche correspondant a l'id
	 * @param id : identifiant du groupe de fiche
	 * @return
	 */
	public GroupePrim findById(Integer id);
	
	/**
	 * permet de recuperer tous les groupes de fiche
	 * @return
	 */
	public List<GroupePrim> findAll();
	
	/**
	 * permet de recuperer tous les groupes de fiche affecté a un utilisateur
	 * @param userHisto : identifant de l'utilisateur au quel le groupe de fiche est affecté
	 * @return
	 */
	public List<GroupePrim> findAllByUserHisto(UserPrim userHisto);
	
	/**
	 * permet de recuperer tous les groupes de fiche a un etat donnée
	 * @param etat
	 * @return
	 */
	public List<GroupePrim> findAllByEtat(EtatPrim etat);
	
}
