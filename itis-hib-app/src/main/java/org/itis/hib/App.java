package org.itis.hib;

import java.util.List;

import org.hibernate.Session;
import org.itis.hib.entity.User;
import org.itis.hib.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Hibernate + MySQL + Maven");
    	try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String[] firstnames = new String[]{"Ramil", "Marat", "Damir", "Ilnur", "Ruslan"};
			String[] lastnames = new String[]{"Shigapov", "Nizamv", "Misbahov", "Galimov", "Zapipov"};
			int randage = (int)(Math.random()*20)+17;
			User newUser = new User();
			newUser.setAge(randage);
			newUser.setFirstname(firstnames[(int) (Math.random()*firstnames.length)]);
			newUser.setLastname(lastnames[(int) (Math.random()*lastnames.length)]);
			session.save(newUser);
			session.getTransaction().commit();
			@SuppressWarnings("unchecked")
			List<User> allUsers = session.createCriteria(User.class).list();
			for (User user : allUsers) {
				System.out.println("User: " + user.getFirstname() + "|" + user.getLastname() + "|age=" + user.getAge());
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
