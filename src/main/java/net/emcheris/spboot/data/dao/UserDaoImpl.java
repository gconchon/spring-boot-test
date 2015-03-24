package net.emcheris.spboot.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.emcheris.spboot.data.entity.User;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager em;

	@Override
	public User get(long id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> list(User criteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 
	  CriteriaQuery<User> q = cb.createQuery(User.class);
	  Root<User> c = q.from(User.class);
	  q.select(c);
	  
	  // Recherche par login
	  if (!StringUtils.isEmpty(criteria.getLogin())) {
	  	q.where(cb.like(c.get("login"), criteria.getLogin().trim()));
	  }
	  
	  return em.createQuery(q).getResultList();
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}
	
}
