package com.yada180.sms.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yada180.sms.domain.Intake;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class IntakeDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(IntakeDao.class.getName());
	private static Session session;
	
	public IntakeDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public Intake findById(Long id) {
		
		Intake Intake = (Intake) session.get(Intake.class, id);
		
		return Intake;
	}
	
	public List listIntakes() {
		LOGGER.setLevel(Level.INFO);
	    List<Intake> list = new ArrayList<Intake>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM Intake").list();                       
        	tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}	
	
	/* Method to INSERT Intake */
	public Long addIntake(Intake obj){
		Transaction tx = null;
		Long key = null;
		try{
		tx = session.beginTransaction();
		key = (Long) session.save(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return key;
		}
	

	/* Method to UPDATE Intake */
	public void updateIntake(Intake obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//Intake Intake =
		//(Intake)session.get(Intake.class, IntakeID);
		//Intake.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE Intake */
	public void deleteIntake(Long key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Intake obj =
			(Intake)session.get(Intake.class, key);
			session.delete(obj);
			tx.commit();
			}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			}

	public List search(String entryDate, String exitDate, String lastname, 
			String firstname, String ssn, 
			String dob, String farm) {
		
		StringBuffer query = new StringBuffer("from Intake");
		if (lastname!=null&&lastname.length()>0)
			query.append(" where lastname = :lastname ");
		if (firstname!=null&&firstname.length()>0)
			query.append(" where firstname = :firstname ");
		if (ssn!=null&&ssn.length()>0)
			query.append(" where ssn = :ssn ");
		if (dob!=null&&dob.length()>0)
			query.append(" where dob = :dob ");
		if (farm!=null&&farm.length()>0&&!farm.equals("ALL"))
			query.append(" where farmBase = :farmBase ");
		
		Query q = session.createQuery(query.toString());
		
		if (lastname!=null&&lastname.length()>0)
			q.setString("lastname", lastname);
		if (firstname!=null&&firstname.length()>0)
			q.setString("firstname", firstname);
		if (ssn!=null&&ssn.length()>0)
			q.setString("ssn", ssn);
		if (dob!=null&&dob.length()>0)
			q.setString("dob", dob);
		if (farm!=null&&farm.length()>0&&!farm.equals("ALL"))
			q.setString("farmBase", farm);
		
		List list = q.list();
		return list;
	}
}


