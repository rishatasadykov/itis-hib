package org.itis.hib.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.itis.hib.entity.User;

public class UserRepositoryImpl implements UserRepository {
	List<User> users = new ArrayList<>();
	private SessionFactory sessionFactory;
	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void deleteUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> allUsers = session.createCriteria(User.class).list();
		session.close();
		return allUsers;
	}
}
