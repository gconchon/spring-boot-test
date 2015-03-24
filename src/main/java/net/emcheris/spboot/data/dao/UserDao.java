package net.emcheris.spboot.data.dao;

import java.util.List;

import net.emcheris.spboot.data.entity.User;

public interface UserDao {

	User get(long id);
	
	List<User> list(User criteria);
	
	void save(User user);
}
