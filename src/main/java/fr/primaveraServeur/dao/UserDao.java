package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.UserPrim;

public interface UserDao {

	public void save(UserPrim user);
	public void delete(UserPrim user);
	
	public List<UserPrim> findAll();
	public UserPrim findById(Integer id);
	public UserPrim findByMail(String addresseMail);
	
}
