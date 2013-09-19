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

import com.yada180.sms.domain.CwtJob;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtJobDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtJobDao.class.getName());
	private static Session session;
	
	public CwtJobDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtJob findById(Integer id) {
		
		CwtJob CwtJob = (CwtJob) session.get(CwtJob.class, id);
		
		return CwtJob;
	}
	
	public List listCwtJobs() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtJob> list = new ArrayList<CwtJob>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtJob").list();                       
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
	
	/* Method to INSERT CwtJob */
	public Long addCwtJob(CwtJob obj){
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
	

	/* Method to UPDATE CwtJob */
	public void updateCwtJob(CwtJob obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//CwtJob CwtJob =
		//(CwtJob)session.get(CwtJob.class, CwtJobID);
		//CwtJob.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtJob */
	public void deleteCwtJob(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			CwtJob obj =
			(CwtJob)session.get(CwtJob.class, key);
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


