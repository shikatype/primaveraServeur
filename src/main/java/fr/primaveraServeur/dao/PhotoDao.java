package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.PhotoPrim;

public interface PhotoDao {
	
	public List<PhotoPrim> findAll();
	public List<PhotoPrim> findAllByFiche(FichePrim fiche);
	public PhotoPrim findById(Integer id);
	public PhotoPrim findByName(String name);
	
}
