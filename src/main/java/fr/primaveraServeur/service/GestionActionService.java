package fr.primaveraServeur.service;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

public interface GestionActionService {

	
	
	//service fiche
	
	
	/**
	 * permet la creation de fiche en base de donnée ainsi que l'attribution à
	 * un utilisateur ou groupe d'utilisateur.
	 * @param titre : titre de l'alerte
	 * @param longitude : longitude de l'emplacement de l'alerte
	 * @param latitude : latitude de l'emplacement de l'alerte
	 * @param txtDescription : description de l'alerte
	 * @param idUserCreateur : id de l'utilisateur qui a créé l'alerte
	 * @param idUserHisto : id de l'utilisateur a qui on fournie l'alerte
	 * @param idDanger : id du niveau de danger de l'alerte
	 */
	public void creationFiche(String titre,String longitude,String latitude,
			String txtDescription,Integer idUserCreateur,Integer idUserHisto,Integer idDanger);
	
	/**
	 * modifie la fiche en base de donnée
	 * en mettant a l'etat suivant
	 * @param fiche
	 */
	public void envoyerFiche(FichePrim fiche);
	
	/**
	 * modifie la fiche en base de donnée
	 * @param fiche
	 */
	public void sauvegardeFiche(FichePrim fiche);
	
	/**
	 * permet de récupérer la fiche avec l'id donnée
	 * @param idFiche
	 * @return
	 */
	public FichePrim recupFiche(Integer idFiche);
	
	/**
	 * permet de cloturer la fiche
	 * @param fiche
	 */
	public void cloturationFiche(FichePrim fiche);
	
	
	
					//service groupe de fiche
	
	/**
	 * permet la creation de groupe de fiche en base de donnée ainsi que l'attribution à
	 * un utilisateur ou groupe d'utilisateur.
	 * @param titre : titre du groupe de fiche
	 * @param description : description du groupe de fiche
	 * @param idUserCreateur : id de l'utilisateur qui a créé le groupe de fiche
	 * @param idEtat : id de l'etat que prendra le groupe de fiche
	 * @param idUserHisto : id de l'utilisateur au quel sera affecté la fiche
	 * @param listIdFiche : la liste des fiche contenue dans le groupe de fiche
	 */
	public void creationGroupeDeFiche(String titre,String description,
			Integer idUserCreateur,Integer idEtat,Integer idUserHisto,List<Integer> listIdFiche);
	
	/**
	 * modifie le groupe de fiche en base de donnée
	 * @param groupe
	 */
	public void envoyerGroupe(GroupePrim groupe);
	
	/**
	 * permet de récupérer le groupe de fiche correspondant a l'id
	 * @param idGroupe : identifiant du groupe de fiche
	 * @return
	 */
	public GroupePrim recupGroupe(Integer idGroupe);
	
	/**
	 * permet de cloturer un groupe de fiche avec toute les
	 * fiches lié
	 * @param groupe
	 */
	public void cloturationGroupe(GroupePrim groupe);
	
	
	
					//autres service
	/**
	 * renvoie l'utilisateur qui correspond à l'adresse mail et le mot de passe
	 * si l'utilisateur est inexistant on renvoie null
	 * @param email : adresse mail
	 * @param password : mot de passe
	 * @return
	 */
	public UserPrim connexion(String email,String password);
	
	/**
	 * permet de recuperer l'utilisateur correspondant à l'id
	 * @param idUser : identifiant de l'utilisateur
	 * @return
	 */
	public UserPrim recupUser(Integer idUser);
	
	/**
	 * permet de recuperer l'etat correspondant au nom
	 * @param etatName : nom de l'etat
	 * @return
	 */
	public EtatPrim recupEtatAvecNom(String etatName);
	
	/**
	 * permet de recuperer l'etat suivant de l'etat correspond a l'id
	 * @param id : identifiant de l'etat courant
	 * @return
	 */
	public EtatPrim recupEtatPlusAvecId(Integer id);
	
	/**
	 * permet de savoir si un l'adresse mail existe deja
	 * @param email : adresse mail
	 * @return
	 */
	public boolean userExisting(String email);
	
	/**
	 * permet de creer un utilisateur en base
	 * @param nom
	 * @param prenom
	 * @param affiliation
	 * @param email
	 * @param mdp
	 * @param role
	 * @return
	 */
	public void creationUser(String nom,String prenom,String affiliation,String email,String mdp,Integer role);
	
}
