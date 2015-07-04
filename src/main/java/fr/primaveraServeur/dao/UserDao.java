package fr.primaveraServeur.dao;

import java.util.List;

import fr.primaveraServeur.model.RolePrim;
import fr.primaveraServeur.model.UserPrim;

public interface UserDao {

	/**
	 * permet de sauvegarder un utilisateur en base de donnée
	 * @param user
	 */
	public void save(UserPrim user);
	
	/**
	 * permet de supprimer un utilisateur en base de donnée
	 * @param user
	 */
	public void delete(UserPrim user);
	
	
	/**
	 * permet de récuperer tous les utilisateurs
	 * @return
	 */
	public List<UserPrim> findAll();
	
	/**
	 * permet de recuperer l'utilisateur correspondant a l'id
	 * @param id : identifiant de l'utilisateur
	 * @return
	 */
	public UserPrim findById(Integer id);
	
	/**
	 * permet de recuperer l'utilisateur correspondant a l'adresse mail
	 * @param addresseMail : adresse mail d'un l'utilisateur
	 * @return
	 */
	public UserPrim findByMail(String addresseMail);
	
	/**
	 * permet de recuperer le role correspondant a l'id
	 * @param role : identifiant du role
	 * @return
	 */
	public List<UserPrim> findByRole(RolePrim role);
	
}
