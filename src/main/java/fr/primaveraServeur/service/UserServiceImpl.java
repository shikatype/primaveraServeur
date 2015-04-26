package fr.primaveraServeur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.dao.UserDao;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.ServicePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public UserPrim connection(String eMail, String motDePasse) {
		UserPrim user=userDao.findByMail(eMail);
		if(user!=null){
			if(user.getMdp().equals(motDePasse)){
				return user;
			}
		}
		return null;
	}
	
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
	public List<String> listHistorique(Integer idUser){
		UserPrim user=userDao.findById(idUser);
		Set<EtatPrim> listEtat=user.getRolePrim().getEtatPrims();
		List<String> list=new ArrayList<String>();
		for(EtatPrim etat:listEtat){
			list.add(etat.getEtat());
		}
		return list;
	}

}
