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

import com.yada180.sms.domain.IntakeJobSkill;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class IntakeJobSkillDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(IntakeJobSkillDao.class.getName());
	private static Session session;
	
	public IntakeJobSkillDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public List findById(Long id) {
		
		LOGGER.setLevel(Level.INFO);
	    List<IntakeJobSkill> list = new ArrayList<IntakeJobSkill>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            StringBuffer query = new StringBuffer("from IntakeJobSkill where intakeId = :intakeId ");
    		Query q = session.createQuery(query.toString());
    		q.setLong("intakeId", id);  
    		list = q.list();
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
	
	
	
	public List listIntakeJobSkills() {
		LOGGER.setLevel(Level.INFO);
	    List<IntakeJobSkill> list = new ArrayList<IntakeJobSkill>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM IntakeJobSkill").list();                       
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
	
	/* Method to INSERT IntakeJobSkill */
	public Long addIntakeJobSkill(IntakeJobSkill obj){
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
	

	/* Method to UPDATE IntakeJobSkill */
	public void updateIntakeJobSkill(IntakeJobSkill obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//IntakeJobSkill IntakeJobSkill =
		//(IntakeJobSkill)session.get(IntakeJobSkill.class, IntakeJobSkillID);
		//IntakeJobSkill.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE IntakeJobSkill */
	public void deleteIntakeJobSkill(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			IntakeJobSkill obj =
			(IntakeJobSkill)session.get(IntakeJobSkill.class, key);
			session.delete(obj);
			tx.commit();
			}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			}
	
}


