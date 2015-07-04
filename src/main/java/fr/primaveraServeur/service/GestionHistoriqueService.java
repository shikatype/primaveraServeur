package fr.primaveraServeur.service;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

public interface GestionHistoriqueService {
	
	/**
	 * permet de récupérer toute les fiches affecté a un utilisateur
	 * pour un etat donnée
	 * @param etatName : nom de l'etat
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public List<FichePrim> recupListFiche(EtatPrim etat,UserPrim user);
	
	/**
	 * permet de récupérer tout les groupes de fiche affecté a un utilisateur
	 * pour un etat donnée
	 * @param etatName : nom de l'etat
	 * @param idUser : id de l'utilisateur
	 * @return
	 */
	public List<GroupePrim> recupListGroupeParEtat(EtatPrim etat,UserPrim user);

}
