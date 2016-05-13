package org.itis.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itis.hib.entity.Order;
import org.itis.hib.entity.User;
import org.itis.hib.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class OrderApp 
{
    public static void main( String[] args )
    {
    	System.out.println("Hibernate + MySQL + Maven");
    	try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    		    Session session = sessionFactory.openSession()) {
    		 
    		 @SuppressWarnings("unchecked")
    		 List<Order> allOrders = session.createCriteria(Order.class).list();
    		 System.out.println("Orders count: " + allOrders.size());
    		 for (Order order : allOrders) {
    			 System.out.println(order.getProduct());
    			 System.out.println(order.getUser().getFirstname());
    			 System.out.println(order.getUser().getOrderList().size());
    		 }
    	} catch (Exception e) {
    		e.printStackTrace();
    	} catch (Error e) {
    		e.printStackTrace();
    	} finally {
    		HibernateUtil.shutdown();
    	}
    }
}
