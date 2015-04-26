package fr.primaveraServeur.service;

import java.util.Date;
import java.util.List;

import fr.primaveraServeur.model.FichePrim;

public interface FicheService {
	
	public void creationFiche(String titre,String longitude,String latitude,Date dateCreation,
			String txtDescription,Integer idUserCreateur,Integer idUserHisto,Integer idEtat,Integer idDanger);
	
	
	public List<FichePrim> recupListFicheAssigne(Integer idUserHisto);
	public List<FichePrim> recupListFicheParEtat(String etatName);
	public List<FichePrim> recupListFiche(String etatName,Integer idUser);
	public FichePrim recupFiche(Integer idFiche);

}
