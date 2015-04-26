package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.ServicePrim;

public interface ServiceDao {

	public void save(ServicePrim service);
	public void delete(ServicePrim service);
	
	public List<ServicePrim> findAll();
	public ServicePrim findById(Integer id);
	public ServicePrim findByName(String name);
	
}
