package net.emcheris.spboot.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.emcheris.spboot.data.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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
	  	String login = criteria.getLogin().trim();
	  	q.where(cb.like(c.<String>get("login"), "%"+login.toUpperCase()+"%"));
	  }

	  // Recherche par entité
	  if (!StringUtils.isEmpty(criteria.getEntityCode())) {
	  	q.where(cb.equal(c.get("entityCode"), criteria.getEntityCode().trim()));
	  }

	  // Recherche par nom
	  if (!StringUtils.isEmpty(criteria.getLastname())) {
	  	String lastname = criteria.getLastname().trim();
	  	q.where(cb.like(cb.upper(c.<String>get("lastname")), "%"+lastname.toUpperCase()+"%"));
	  }

	  
	  return em.createQuery(q).getResultList();
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}
	
}
