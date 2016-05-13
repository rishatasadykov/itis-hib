package org.itis.hib.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.itis.hib.entity.Order;
import org.itis.hib.entity.User;

public class OrderRepositoryImpl implements OrderRepository {
	private SessionFactory sessionFactory;
	List<Order> orders = new ArrayList<>();
	public List<Order> getAllOrders() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Order> allOrders = session.createCriteria(Order.class).list();
		
		return allOrders;
	}
	public OrderRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void updateOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void deleteOrder(Order order) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally{
			session.close();
		}
	}
}
