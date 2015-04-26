package fr.primaveraServeur.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.dao.DangerDao;
import fr.primaveraServeur.dao.EtatDao;
import fr.primaveraServeur.dao.FicheDao;
import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.ServicePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("ficheService")
@Transactional
public class FicheServiceImpl implements FicheService {
	
	@Autowired
	FicheDao ficheDao;
	@Autowired
	EtatDao etatDao;
	@Autowired
	UserDao userDao;
	@Autowired
	DangerDao dangerDao;

	@Override
	public void creationFiche(String titre, String longitude,
			String latitude, Date dateCreation,String txtDescription, Integer idUserCreateur,
			Integer idUserHisto, Integer idEtat, Integer idDanger) {
	System.out.println(idUserCreateur);	
	UserPrim userCreateur=userDao.findById(idUserCreateur);
	System.out.println(userCreateur);
	UserPrim userHisto=userDao.findById(idUserHisto);
	EtatPrim etat=etatDao.findById(idEtat);
	DangerPrim danger=dangerDao.findById(idDanger);
	
	DescriptionPrim description=new DescriptionPrim(dateCreation, txtDescription, userCreateur);
	System.out.println(userCreateur);
	//TODO voir pour le cas des photos
	
	FichePrim fiche=new FichePrim(dateCreation, latitude, longitude, titre, etat, userCreateur, danger);	
	System.out.println(userCreateur);
	fiche.setUserHisto(userHisto);
	fiche.addDescriptionPrim(description);
	
	ficheDao.save(fiche);
	System.out.println(fiche.getIdfiche());	

	}

	@Override
	public List<FichePrim> recupListFicheAssigne(Integer idUserHisto) {
		UserPrim user=userDao.findById(idUserHisto);
		return ficheDao.findAllByUserHisto(user);
	}

	@Override
	public List<FichePrim> recupListFicheParEtat(String etatName) {
		EtatPrim etat=etatDao.findByName(etatName);
		return ficheDao.findAllByEtat(etat);
	}
	
	@Override
	public List<FichePrim> recupListFiche(String etatName,Integer idUser){
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("recupFicheParEtat")){
				return recupListFicheParEtat(etatName);
			}
		}
		return recupListFicheAssigne(idUser);
	}
	
	@Override
	public FichePrim recupFiche(Integer idFiche){
		return ficheDao.findById(idFiche);
	}

}
