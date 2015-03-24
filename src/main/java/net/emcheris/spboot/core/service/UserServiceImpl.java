package net.emcheris.spboot.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emcheris.spboot.data.dao.UserDao;
import net.emcheris.spboot.data.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUser(long id) {
		return userDao.get(id);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public List<User> listUsers(User criteria) {
		return userDao.list(criteria);
	}

}
