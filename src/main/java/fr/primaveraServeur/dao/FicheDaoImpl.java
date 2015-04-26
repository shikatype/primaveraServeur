package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.DangerPrim;
import fr.primaveraServeur.model.EtatPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("ficheDao")
@Transactional
public class FicheDaoImpl implements FicheDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(FichePrim fiche) {
		sessionFactory.getCurrentSession().saveOrUpdate(fiche);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FichePrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(FichePrim.class).list();
	}

	@Override
	public FichePrim findById(Integer id) {
		return (FichePrim) sessionFactory.getCurrentSession().get(FichePrim.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FichePrim> findAllByUserHisto(UserPrim userHisto) {
		return sessionFactory.getCurrentSession().createCriteria(FichePrim.class).add(Restrictions.eq("userHisto",userHisto)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FichePrim> findAllByEtat(EtatPrim etat) {
		return sessionFactory.getCurrentSession().createCriteria(FichePrim.class).add(Restrictions.eq("etatPrim",etat)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FichePrim> findAllByDanger(DangerPrim danger) {
		return sessionFactory.getCurrentSession().createCriteria(FichePrim.class).add(Restrictions.eq("dangerPrim",danger)).list();
	}

}
