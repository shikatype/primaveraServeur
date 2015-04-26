package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.RolePrim;

@Service("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(RolePrim role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

	@Override
	public void delete(RolePrim role) {
		sessionFactory.getCurrentSession().delete(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolePrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(RolePrim.class).list();
	}

	@Override
	public RolePrim findById(Integer id) {
		return (RolePrim) sessionFactory.getCurrentSession().get(RolePrim.class, id);
	}

	@Override
	public RolePrim findByName(String name) {
		return (RolePrim) sessionFactory.getCurrentSession().createCriteria(RolePrim.class).add(Restrictions.eq("nom",name)).uniqueResult();
	}

}
