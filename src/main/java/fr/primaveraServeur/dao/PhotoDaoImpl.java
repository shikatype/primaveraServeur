package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.FichePrim;
import fr.primaveraServeur.model.PhotoPrim;

@Service("photoDao")
@Transactional
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<PhotoPrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(PhotoPrim.class).list();
	}

	@Override
	public PhotoPrim findById(Integer id) {
		return (PhotoPrim) sessionFactory.getCurrentSession().get(PhotoPrim.class, id);
	}

	@Override
	public PhotoPrim findByName(String lien) {
		return (PhotoPrim) sessionFactory.getCurrentSession().createCriteria(PhotoPrim.class).add(Restrictions.eq("lien",lien)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhotoPrim> findAllByFiche(FichePrim fiche) {
		return sessionFactory.getCurrentSession().createCriteria(PhotoPrim.class).add(Restrictions.eq("fichePrim",fiche)).list();
	}

}
