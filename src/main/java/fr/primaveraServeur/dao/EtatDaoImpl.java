package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.EtatPrim;

@Service("etatDao")
@Transactional
public class EtatDaoImpl implements EtatDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(EtatPrim etat) {
		sessionFactory.getCurrentSession().saveOrUpdate(etat);
	}

	@Override
	public void delete(EtatPrim etat) {
		sessionFactory.getCurrentSession().delete(etat);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EtatPrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(EtatPrim.class).list();
	}

	@Override
	public EtatPrim findById(Integer id) {
		return (EtatPrim) sessionFactory.getCurrentSession().get(EtatPrim.class, id);
	}

	@Override
	public EtatPrim findByName(String etat) {
		return (EtatPrim) sessionFactory.getCurrentSession().createCriteria(EtatPrim.class).add(Restrictions.eq("etat",etat)).uniqueResult();
	}

}
