package general.spring.mvc.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import general.spring.mvc.entities.ComputerUsage;

@Repository
public class ComputerUsageRepository {
	@Autowired
	SessionFactory sf;
	
	public void saveComputerUsage(ComputerUsage post) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			if (post != null) {
				session.save(post);
				tx.commit();
				System.out.println("Insert Success!!!");
			} else {
				System.out.println("Insert Fail!!!");
			}

		} catch (HibernateException e) {
			if (tx != null)
				e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
