package org.itis.hib;

import java.util.List;
import org.hibernate.Session;
import org.itis.hib.entity.Order;
import org.itis.hib.entity.User;
import org.itis.hib.util.HibernateUtil;

public class CascadeApp {
	public static void main( String[] args )
    {
    	System.out.println("Hibernate + MySQL + Maven");
    	try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<Order> allOrders = session.createCriteria(Order.class).list();
			User user = null;
			for (Order o: allOrders){
				user = o.getUser();
				break;
			}
			user.setAge(20);
			session.update(user);
			session.getTransaction().commit();
			allOrders = session.createCriteria(Order.class).list();
			for (Order o: allOrders){
				System.out.println(o.getUser().getAge());
				break;
			}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		HibernateUtil.shutdown();
    	}
    }
}
