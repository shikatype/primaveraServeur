package fr.primaveraServeur.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.primaveraServeur.model.UserPrim;

@Service("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(UserPrim user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void delete(UserPrim user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserPrim> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(UserPrim.class).list();
	}

	@Override
	public UserPrim findById(Integer id) {
		return (UserPrim) sessionFactory.getCurrentSession().get(UserPrim.class, id);
	}

	@Override
	public UserPrim findByMail(String addresseMail) {
		return (UserPrim) sessionFactory.getCurrentSession().createCriteria(UserPrim.class).add(Restrictions.eq("addresseMail",addresseMail)).uniqueResult();
	}

}
