package fr.primaveraServeur.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.dao.DangerDao;
import fr.primaveraServeur.dao.EtatDao;
import fr.primaveraServeur.dao.FicheDao;
import fr.primaveraServeur.dao.GroupeDao;
import fr.primaveraServeur.dao.RoleDao;
import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("gestionActionService")
@Transactional
public class GestionActionServiceImpl implements GestionActionService {

	@Autowired
	FicheDao ficheDao;
	@Autowired
	GroupeDao groupeDao;
	@Autowired
	EtatDao etatDao;
	@Autowired
	UserDao userDao;
	@Autowired
	DangerDao dangerDao;
	@Autowired
	RoleDao roleDao;
	
	
	@Override
	public UserPrim connexion(String email, String password) {
		
		UserPrim user=userDao.findByMail(email);
		if(user!=null && user.getMdp().equals(password)){
			return user;
		}
		return null;
	}
	
	@Override
	public void creationFiche(String titre, String longitude,
			String latitude,String txtDescription, Integer idUserCreateur,
			Integer idUserHisto, Integer idDanger) {
	UserPrim userCreateur=userDao.findById(idUserCreateur);
	UserPrim userHisto=userDao.findById(idUserHisto);
	EtatPrim etat=etatDao.findById(1001);
	DangerPrim danger=dangerDao.findById(idDanger);	
	Date date=new Date();
	
	DescriptionPrim description=new DescriptionPrim(date, txtDescription, userCreateur);
	//TODO voir pour le cas des photos
	
	FichePrim fiche=new FichePrim(date, latitude, longitude, titre, etat, userCreateur, danger);	
	fiche.setUserHisto(userHisto);
	fiche.addDescriptionPrim(description);
	
	ficheDao.save(fiche);

	}

	@Override
	public void envoyerFiche(FichePrim fiche) {
		EtatPrim etat=etatDao.findById(fiche.getEtatPrim().getIdetat()+1);
		if(etat!=null){
			fiche.setEtatPrim(etat);
			ficheDao.save(fiche);
		}
	}
	
	@Override
	public void sauvegardeFiche(FichePrim fiche) {
		ficheDao.save(fiche);
	}

	@Override
	public FichePrim recupFiche(Integer idFiche) {
		return ficheDao.findById(idFiche);
	}

	@Override
	public void cloturationFiche(FichePrim fiche) {
		EtatPrim etat=etatDao.findByName("cloturer");
		fiche.setEtatPrim(etat);
		ficheDao.save(fiche);
	}

	@Override
	public void creationGroupeDeFiche(String titre, String description,
			Integer idUserCreateur, Integer idEtat,
			Integer idUserHisto, List<Integer> listIdFiche) {

		EtatPrim etat=etatDao.findById(idEtat+1);
		UserPrim userCreateur=userDao.findById(idUserCreateur);
		GroupePrim groupe=new GroupePrim(new Date(), description, titre, etat, userCreateur);

		UserPrim userHisto=userDao.findById(idUserHisto);
		groupe.setUserHisto(userHisto);

		Set<FichePrim> setFiche=createSetFicheByListIdFiche(listIdFiche);
		for(FichePrim fiche:setFiche){
			fiche.setEtatPrim(etat);
		}
		groupe.setFichePrims(setFiche);
		
		groupeDao.save(groupe);

	}

	@Override
	public void envoyerGroupe(GroupePrim groupe) {
		EtatPrim etat=etatDao.findById(groupe.getEtatPrim().getIdetat()+1);
		for(FichePrim fiche:groupe.getFichePrims()){
			fiche.setRempli(false);
		}
		if(etat!=null){
			groupe.setEtatPrim(etat);
			for(FichePrim fiche:groupe.getFichePrims()){
				fiche.setEtatPrim(etat);
			}
			groupeDao.save(groupe);
		}
	}

	@Override
	public GroupePrim recupGroupe(Integer idGroupe) {
		return groupeDao.findById(idGroupe);
	}

	@Override
	public void cloturationGroupe(GroupePrim groupe) {
		EtatPrim etat=etatDao.findByName("cloturer");
		groupe.setEtatPrim(etat);
		for(FichePrim fiche:groupe.getFichePrims()){
			fiche.setEtatPrim(etat);
		}
		groupeDao.save(groupe);
	}
	
	@Override
	public UserPrim recupUser(Integer idUser) {
		return userDao.findById(idUser);
	}
	
	@Override
	public boolean userExisting(String email) {
		if(userDao.findByMail(email)!=null){
			return true;
		}
		return false;
	}
	
	@Override
	public EtatPrim recupEtatAvecNom(String etatName) {
		return etatDao.findByName(etatName);
	}
	
	@Override
	public EtatPrim recupEtatPlusAvecId(Integer id) {
		return etatDao.findById(id+1);
	}

	@Override
	public void creationUser(String nom, String prenom, String affiliation,
			String email, String mdp, Integer role) {
		
		UserPrim user = new UserPrim(email, affiliation, mdp, nom, prenom, roleDao.findById(role));
		userDao.save(user);
	}
	
	//methode private
	
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
