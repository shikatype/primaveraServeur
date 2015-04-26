package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.DescriptionPrim;
import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.UserPrim;

@Service("descriptionDao")
@Transactional
public class DescriptionDaoImpl implements DescriptionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DescriptionPrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(DescriptionPrim.class).list();
	}

	@Override
	public DescriptionPrim findById(Integer id) {
		return (DescriptionPrim) sessionFactory.getCurrentSession().get(DescriptionPrim.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DescriptionPrim> findAllByUser(UserPrim user) {
		return sessionFactory.getCurrentSession().createCriteria(DescriptionPrim.class).add(Restrictions.eq("userPrim",user)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DescriptionPrim> findAllByFiche(FichePrim fiche) {
		return sessionFactory.getCurrentSession().createCriteria(DescriptionPrim.class).add(Restrictions.eq("fichePrim",fiche)).list();
	}

}
