package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

public interface GroupeDao {

	public void save(GroupePrim groupe);
	
	public GroupePrim findById(Integer id);
	public List<GroupePrim> findAll();
	public List<GroupePrim> findAllByUserHisto(UserPrim userHisto);
	public List<GroupePrim> findAllByEtat(EtatPrim etat);
	
}
