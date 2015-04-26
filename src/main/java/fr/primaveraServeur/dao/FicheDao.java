package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

public interface FicheDao {

	public void save(FichePrim fiche);
	
	public FichePrim findById(Integer id);
	public List<FichePrim> findAll();
	public List<FichePrim> findAllByUserHisto(UserPrim userHisto);
	public List<FichePrim> findAllByDanger(DangerPrim danger);
	public List<FichePrim> findAllByEtat(EtatPrim etat);
	
}
