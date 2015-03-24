package net.emcheris.spboot.core.service;

import java.util.List;

import net.emcheris.spboot.data.entity.User;

public interface UserService {
	
	User getUser(long id);
	
	void saveUser(User user);
	
	List<User> listUsers(User criteria);
	
}
