package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

public interface DescriptionDao {
	
	public DescriptionPrim findById(Integer id);
	public List<DescriptionPrim> findAll();
	public List<DescriptionPrim> findAllByUser(UserPrim user);
	public List<DescriptionPrim> findAllByFiche(FichePrim fiche);
	
}
