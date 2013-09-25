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

import com.yada180.sms.domain.JobSkill;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class JobSkillDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(JobSkillDao.class.getName());
	private static Session session;
	
	public JobSkillDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public JobSkill findById(Integer id) {
		
		JobSkill JobSkill = (JobSkill) session.get(JobSkill.class, id);
		
		return JobSkill;
	}
	
	public List listJobSkills() {
		LOGGER.setLevel(Level.INFO);
	    List<JobSkill> list = new ArrayList<JobSkill>();
	    Transaction tx = null;        
        try {
            tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM JobSkill").list();                       
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
	
	/* Method to INSERT JobSkill */
	public Long addJobSkill(JobSkill obj){
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
	

	/* Method to UPDATE JobSkill */
	public void updateJobSkill(JobSkill obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//JobSkill JobSkill =
		//(JobSkill)session.get(JobSkill.class, JobSkillID);
		//JobSkill.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE JobSkill */
	public void deleteJobSkill(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			JobSkill obj =
			(JobSkill)session.get(JobSkill.class, key);
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


