package fr.primaveraServeur.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.dao.EtatDao;
import fr.primaveraServeur.dao.FicheDao;
import fr.primaveraServeur.dao.GroupeDao;
import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.ServicePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("groupeService")
@Transactional
public class GroupeServiceImpl implements GroupeService {

	@Autowired
	GroupeDao groupeDao;
	@Autowired
	EtatDao etatDao;
	@Autowired
	UserDao userDao;
	@Autowired
	FicheDao ficheDao;

	@Override
	public void creationGroupeDeFiche(String titre, String description,
			Date dateCreation, Integer idUserCreateur, Integer idEtat,
			Integer idUserHisto, List<Integer> listIdFiche) {

		EtatPrim etat=etatDao.findById(idEtat);
		UserPrim userCreateur=userDao.findById(idUserCreateur);
		GroupePrim groupe=new GroupePrim(dateCreation, description, titre, etat, userCreateur);

		UserPrim userHisto=userDao.findById(idUserHisto);
		groupe.setUserHisto(userHisto);

		Set<FichePrim> setFiche=createSetFicheByListIdFiche(listIdFiche);
		groupe.setFichePrims(setFiche);
		
		groupeDao.save(groupe);

	}

	@Override
	public List<GroupePrim> recupListGroupeAssigne(Integer idUserHisto) {
		UserPrim user=userDao.findById(idUserHisto);
		return groupeDao.findAllByUserHisto(user);
	}

	@Override
	public List<GroupePrim> recupListGroupeParEtat(String etatName) {
		EtatPrim etat=etatDao.findByName(etatName);
		return groupeDao.findAllByEtat(etat);
	}

	@Override
	public List<GroupePrim> recupListGroupeParEtat(String etatName,Integer idUser){
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("recupGroupeParEtat")){
				return recupListGroupeParEtat(etatName);
			}
		}
		return recupListGroupeAssigne(idUser);
	}

	@Override
	public GroupePrim recupGroupe(Integer idGroupe){
		return groupeDao.findById(idGroupe);
	}

	private Set<FichePrim> createSetFicheByListIdFiche(List<Integer> listIdFiche){
		Set<FichePrim> setFiche=new HashSet<FichePrim>();
		FichePrim fiche=null;
		for(Integer idfiche:listIdFiche){
			fiche=ficheDao.findById(idfiche);
			if(fiche!=null){
				setFiche.add(fiche);
			}
		}
		return setFiche;
	}

}
