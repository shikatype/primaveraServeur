package fr.primaveraServeur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.dao.DangerDao;
import fr.primaveraServeur.dao.EtatDao;
import fr.primaveraServeur.dao.FicheDao;
import fr.primaveraServeur.dao.GroupeDao;
import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.ServicePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("gestionHistoriqueService")
@Transactional
public class GestionHistoriqueServiceImpl implements GestionHistoriqueService {

	@Autowired
	FicheDao ficheDao;
	@Autowired
	EtatDao etatDao;
	@Autowired
	UserDao userDao;
	@Autowired
	DangerDao dangerDao;
	@Autowired
	GroupeDao groupeDao;
	

	@Override
	public List<FichePrim> recupListFiche(EtatPrim etat,UserPrim user){
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("recupFicheParUser")){
				return filtreFiche(recupListFicheAssigne(user,etat));
			}
		}
		List<FichePrim> listFiche=recupListFicheParEtat(etat);
		return filtreFiche(listFiche);
	}

	@Override
	public List<GroupePrim> recupListGroupeParEtat(EtatPrim etat,UserPrim user){
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("recupFicheParUser")){
				return filtreGroupe(recupListGroupeAssigne(user,etat));
			}
		}
		return filtreGroupe(recupListGroupeParEtat(etat));	
	}
	
	//pour les fiches

	/**
	 * on recupere les fiches via l'user et l'etat
	 * car pour un userHisto plusieurs etats sont possible
	 * @param userHisto
	 * @param etat
	 * @return
	 */
	private List<FichePrim> recupListFicheAssigne(UserPrim userHisto,EtatPrim etat) {
		List<FichePrim> listFiche=ficheDao.findAllByUserHisto(userHisto);
		return filtreListFicheParEtat(listFiche,etat);
	}

	/**
	 * recuperation des fiches par etat
	 * @param etat
	 * @return
	 */
	private List<FichePrim> recupListFicheParEtat(EtatPrim etat) {
		List<FichePrim> listFicheParEtat=ficheDao.findAllByEtat(etat);
		return listFicheParEtat;
	}
	
	/**
	 * recuperation des fiches de la list correspondant a l'etat donnée
	 * @param listParUser
	 * @param etat
	 * @return
	 */
	private List<FichePrim> filtreListFicheParEtat(List<FichePrim> listParUser,EtatPrim etat){
		List<FichePrim> listFiche=new ArrayList<FichePrim>();
		for(FichePrim fiche:listParUser){
			if(fiche.getEtatPrim().getEtat().equals(etat.getEtat())){
				listFiche.add(fiche);
			}
		}
		return listFiche;
	}
	
	//pour les groupes de fiche
	
	/**
	 * recuperation des groupe de fiche par etat
	 * @param etat
	 * @return
	 */
	private List<GroupePrim> recupListGroupeAssigne(UserPrim userHisto,EtatPrim etat) {
		List<GroupePrim> listGroupe=groupeDao.findAllByUserHisto(userHisto);
		return filtreListGroupeParEtat(listGroupe,etat);
	}

	/**
	 * recuperation des groupe de fiche par etat
	 * @param etat
	 * @return
	 */
	private List<GroupePrim> recupListGroupeParEtat(EtatPrim etat) {
		return groupeDao.findAllByEtat(etat);
	}
	
	/**
	 * recuperation des groupes de fiche de la list correspondant a l'etat donnée
	 * @param listParUser
	 * @param etat
	 * @return
	 */
	private List<GroupePrim> filtreListGroupeParEtat(List<GroupePrim> listParUser,EtatPrim etat){
		List<GroupePrim> listGroupe=new ArrayList<GroupePrim>();
		for(GroupePrim groupe:listParUser){
			if(groupe.getEtatPrim().getEtat().equals(etat.getEtat())){
				listGroupe.add(groupe);
			}
		}
		return listGroupe;
	}
	
	private ArrayList<FichePrim> filtreFiche(List<FichePrim> list){
		ArrayList<FichePrim> listfiltre=new ArrayList<FichePrim>();
		for(FichePrim fiche:list){
			if(!listfiltre.contains(fiche)){
				listfiltre.add(fiche);
				}
		}
		return listfiltre;
	}
	
	private ArrayList<GroupePrim> filtreGroupe(List<GroupePrim> list){
		ArrayList<GroupePrim> listfiltre=new ArrayList<GroupePrim>();
		for(GroupePrim groupe:list){
			if(!listfiltre.contains(groupe)){
				listfiltre.add(groupe);
				}
		}
		return listfiltre;
	}

}
