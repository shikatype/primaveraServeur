package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.RolePrim;

public interface RoleDao {

	public void save(RolePrim role);
	public void delete(RolePrim role);
	
	public List<RolePrim> findAll();
	public RolePrim findById(Integer id);
	public RolePrim findByName(String name);
	
}
