package org.itis.hib;

import java.util.List;

import org.hibernate.Session;
import org.itis.hib.entity.Order;
import org.itis.hib.entity.User;
import org.itis.hib.repository.OrderRepository;
import org.itis.hib.repository.OrderRepositoryImpl;
import org.itis.hib.repository.UserRepositoryImpl;
import org.itis.hib.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class DAOApp 
{
    public static void main( String[] args )
    {
    	try{
	    	UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(HibernateUtil.getSessionFactory());
	    	OrderRepositoryImpl orderRepositoryImpl = new OrderRepositoryImpl(HibernateUtil.getSessionFactory());
	    	User user = new User();
	    	user.setId(45);
	    	user.setAge(20);
	    	user.setFirstname("fn");
	    	user.setLastname("ln");
//	    	userRepositoryImpl.saveUser(user);
//	    	userRepositoryImpl.updateUser(user);
//	    	userRepositoryImpl.deleteUser(user);
	    	Order order = new Order();
	    	order.setPrice(100);
	    	order.setProduct("Product 1");
	    	order.setUser(user);
	    	orderRepositoryImpl.saveOrder(order);
	    	List<User> list = userRepositoryImpl.getAllUsers();
	    	List<Order> list1 = orderRepositoryImpl.getAllOrders();
	    	for (User u: list) {
				System.out.println("User: " + u.getFirstname() + "|" + u.getLastname() + "|age=" + u.getAge()+"|ID="+u.getId());
		 	}
	    	for (Order o: list1) {
				System.out.println("Product: " + o.getProduct() + "|" + o.getPrice() + "|user=" + o.getUser().getFirstname());
		 	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		HibernateUtil.shutdown();	
    	}
    }
}
