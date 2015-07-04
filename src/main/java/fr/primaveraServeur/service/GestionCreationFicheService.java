package fr.primaveraServeur.service;

import java.util.Date;

public interface GestionCreationFicheService {

	public void creationFiche(String titre,String longitude,String latitude,Date dateCreation,
			String txtDescription,Integer idUserCreateur,Integer idUserHisto,Integer idEtat,Integer idDanger);
	
}
