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
import fr.primaveraServeur.dao.RoleDao;
import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.ServicePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("gestionOptionService")
@Transactional
public class GestionOptionServiceImpl implements GestionOptionService {

	@Autowired
	UserDao userDao;
	@Autowired
	EtatDao etatDao;
	@Autowired
	DangerDao dangerDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	FicheDao ficheDao;
	
	@Override
	public List<UserPrim> affectation(Integer idEtat) {
		EtatPrim etat=etatDao.findById(idEtat+1);
		if(etat!=null && !etat.getEtat().equals("cloturer")){
			Set<RolePrim> setRole=etat.getRolePrims();
			for(RolePrim role:setRole){
				if(role!=null && affectationParUser(role)){
					return filtreUser(userDao.findByRole(role));
				}
			}
		}
		return null;
	}

	@Override
	public boolean cloture(Integer idUser) {
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("Cloture")) return true;
		}
		return false;
	}

	/**
	 * permet de savoir si l'onglet de creation de service doit apparaitre.
	 */
	@Override
	public boolean serviceCreationFiche(Integer idUser){
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("CreationFiche")) return true;
		}
		return false;
	}
	
	@Override
	public List<DangerPrim> listDanger() {
		return dangerDao.findAll();
	}
	
	@Override
	public List<RolePrim> listRole() {
		return filtreRole(roleDao.findAll());
	}
	
	@Override
	public List<FichePrim> listAllFiche() {
		return filtreFiche(ficheDao.findAll());
	}
	
	@Override
	public boolean serviceCreationGroupe(Integer idUser) {
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("CreationGroupe")) return true;
		}
		return false;
	}
	
	@Override
	public boolean serviceCreationUser(Integer idUser) {
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> listService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:listService){
			if(service.getNom().equals("CreationUser")) return true;
		}
		return false;
	}
	
	@Override
	public boolean serviceRecupAllFiche(Integer idUser) {
		UserPrim user=userDao.findById(idUser);
		Set<ServicePrim> setService=user.getRolePrim().getServicePrims();
		for(ServicePrim service:setService){
			if(service.getNom().equals("recupAllFiche")) return true;
		}
		return false;
	}

	//methode privee

	private boolean affectationParUser(RolePrim role){
		Set<ServicePrim> setService=role.getServicePrims();
		for(ServicePrim service:setService){
			if(service.getNom().equals("recupFicheParUser")) return true;
		}
		return false;
	}
	
	private ArrayList<UserPrim> filtreUser(List<UserPrim> list){
		ArrayList<UserPrim> listfiltre=new ArrayList<UserPrim>();
		for(UserPrim user:list){
			if(!listfiltre.contains(user)){
				listfiltre.add(user);
				}
		}
		return listfiltre;
	}
	
	private List<RolePrim> filtreRole(List<RolePrim> list){
		List<RolePrim> listfiltre=new ArrayList<RolePrim>();
		for(RolePrim role:list){
			if(!listfiltre.contains(role)){
				listfiltre.add(role);
				}
		}
		return listfiltre;
	}
	
	private List<FichePrim> filtreFiche(List<FichePrim> list){
		List<FichePrim> listfiltre=new ArrayList<FichePrim>();
		for(FichePrim fiche:list){
			if(!listfiltre.contains(fiche)){
				listfiltre.add(fiche);
				}
		}
		return listfiltre;
	}

}
