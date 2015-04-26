package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.GroupePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("groupeDao")
@Transactional
public class GroupeDaoImpl implements GroupeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(GroupePrim groupe) {
		sessionFactory.getCurrentSession().saveOrUpdate(groupe);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GroupePrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(GroupePrim.class).list();
	}

	@Override
	public GroupePrim findById(Integer id) {
		return (GroupePrim) sessionFactory.getCurrentSession().get(GroupePrim.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupePrim> findAllByUserHisto(UserPrim userHisto) {
		return sessionFactory.getCurrentSession().createCriteria(GroupePrim.class).add(Restrictions.eq("userHisto",userHisto)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupePrim> findAllByEtat(EtatPrim etat) {
		return sessionFactory.getCurrentSession().createCriteria(GroupePrim.class).add(Restrictions.eq("etatPrim",etat)).list();
	}

}
