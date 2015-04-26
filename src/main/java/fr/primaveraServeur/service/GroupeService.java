package fr.primaveraServeur.service;

import java.util.Date;
import java.util.List;

import fr.primaveraServeur.model.GroupePrim;

public interface GroupeService {
	
	public void creationGroupeDeFiche(String titre,String description,Date dateCreation,
			Integer idUserCreateur,Integer idEtat,Integer idUserHisto,List<Integer> listIdFiche);
	
	public List<GroupePrim> recupListGroupeAssigne(Integer idUserHisto);
	public List<GroupePrim> recupListGroupeParEtat(String etatName);
	public List<GroupePrim> recupListGroupeParEtat(String etatName,Integer idUser);
	public GroupePrim recupGroupe(Integer idGroupe);

}
