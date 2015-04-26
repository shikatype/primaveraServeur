package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.DangerPrim;

public interface DangerDao {

	public void save(DangerPrim danger);
	public void delete(DangerPrim danger);
	
	public List<DangerPrim> findAll();
	public DangerPrim findById(Integer id);
	public DangerPrim findByName(String name);
	public DangerPrim findByNiveauDanger(Integer niveauDanger);
	
}
