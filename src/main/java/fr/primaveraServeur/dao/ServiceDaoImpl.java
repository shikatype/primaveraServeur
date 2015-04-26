package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.ServicePrim;

@Service("serviceDao")
@Transactional
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(ServicePrim service) {
		sessionFactory.getCurrentSession().saveOrUpdate(service);
	}

	@Override
	public void delete(ServicePrim service) {
		sessionFactory.getCurrentSession().delete(service);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServicePrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(ServicePrim.class).list();
	}

	@Override
	public ServicePrim findById(Integer id) {
		return (ServicePrim) sessionFactory.getCurrentSession().get(ServicePrim.class, id);
	}

	@Override
	public ServicePrim findByName(String name) {
		return (ServicePrim) sessionFactory.getCurrentSession().createCriteria(ServicePrim.class).add(Restrictions.eq("nom",name)).uniqueResult();
	}

}
