package org.itis.hib.repository;

import java.util.List;

import org.itis.hib.entity.User;

public interface UserRepository {
	public List<User> getAllUsers();
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}
