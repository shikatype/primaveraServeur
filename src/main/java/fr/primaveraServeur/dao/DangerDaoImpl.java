package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.DangerPrim;

@Service("dangerDao")
@Transactional
public class DangerDaoImpl implements DangerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(DangerPrim danger) {
		sessionFactory.getCurrentSession().saveOrUpdate(danger);
	}

	@Override
	public void delete(DangerPrim danger) {
		sessionFactory.getCurrentSession().delete(danger);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DangerPrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(DangerPrim.class).list();
	}

	@Override
	public DangerPrim findById(Integer id) {
		return (DangerPrim) sessionFactory.getCurrentSession().get(DangerPrim.class, id);
	}

	@Override
	public DangerPrim findByName(String name) {
		return (DangerPrim) sessionFactory.getCurrentSession().createCriteria(DangerPrim.class).add(Restrictions.eq("nom",name)).uniqueResult();
	}

	@Override
	public DangerPrim findByNiveauDanger(Integer niveauDanger) {
		return (DangerPrim) sessionFactory.getCurrentSession().createCriteria(DangerPrim.class).add(Restrictions.eq("niveauDanger",niveauDanger)).uniqueResult();
	}

}
