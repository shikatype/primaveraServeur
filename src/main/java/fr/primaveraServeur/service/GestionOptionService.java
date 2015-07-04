package fr.primaveraServeur.service;

import java.util.List;

import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;

public interface GestionOptionService {

	/**
	 * recuperation de tous les utilisateurs qui sont
	 * contenu dans les roles ou l'affectation des fiches et groupes de fiche
	 * est fait par utilisateur à l'etat plus un.
	 * @param idetat : id de l'etat courant de la fiche
	 * @return
	 */
	public List<UserPrim> affectation(Integer idetat);
	
	/**
	 * permet de connaitre si l'utilisateurs a le droit de cloturer un fiche
	 * ou groupe de fiche
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public boolean cloture(Integer idUser);
	
	/**
	 * permet de connaitre si l'utilisateur a le droit de crée une fiche
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public boolean serviceCreationFiche(Integer idUser);
	
	/**
	 * permet de connaitre si l'utilisateur a le droit de crée un groupe de fiche
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public boolean serviceCreationGroupe(Integer idUser);
	
	/**
	 * permet de connaitre si l'utilisateur a le droit de crée un utilisateur
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public boolean serviceCreationUser(Integer idUser);
	
	/**
	 * permet de connaitre si l'utilisateur a le droit de recuperer toute les fiches
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public boolean serviceRecupAllFiche(Integer idUser);
	
	/**
	 * permet de récupérer toute la liste de danger
	 * @return
	 */
	public List<DangerPrim> listDanger();
	
	/**
	 * permet de récupérer toute la liste de role
	 * @return
	 */
	public List<RolePrim> listRole();
	
	/**
	 * permet de récupérer toute la liste de fiche
	 * @return
	 */
	public List<FichePrim> listAllFiche();
	
}
