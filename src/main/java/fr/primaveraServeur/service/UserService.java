package fr.primaveraServeur.service;

import java.util.List;

import fr.primaveraServeur.model.UserPrim;

public interface UserService {
	
	public UserPrim connection(String eMail,String motDePasse);
	public boolean serviceCreationFiche(Integer idUser);
	public List<String> listHistorique(Integer idUser);
	

}
