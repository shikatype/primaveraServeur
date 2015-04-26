package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;

public interface EtatDao {

	public void save(EtatPrim etat);
	public void delete(EtatPrim etat);
	
	public List<EtatPrim> findAll();
	public EtatPrim findById(Integer id);
	public EtatPrim findByName(String etat);
	
}
