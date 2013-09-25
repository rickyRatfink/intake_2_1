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

import com.yada180.sms.domain.CwtProgramMetricModules;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtProgramMetricModulesDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtProgramMetricModulesDao.class.getName());
	private static Session session;
	
	public CwtProgramMetricModulesDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtProgramMetricModules findById(Integer id) {
		
		CwtProgramMetricModules CwtProgramMetricModules = (CwtProgramMetricModules) session.get(CwtProgramMetricModules.class, id);
		
		return CwtProgramMetricModules;
	}
	
	public List listCwtProgramMetricModuless() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtProgramMetricModules> list = new ArrayList<CwtProgramMetricModules>();
	    Transaction tx = null;        
        try {
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtProgramMetricModules").list();                       
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
	
	/* Method to INSERT CwtProgramMetricModules */
	public Long addCwtProgramMetricModules(CwtProgramMetricModules obj){
		Transaction tx = null;
		Long key = null;
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
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
	

	/* Method to UPDATE CwtProgramMetricModules */
	public void updateCwtProgramMetricModules(CwtProgramMetricModules obj){
		Transaction tx = null;
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
		//CwtProgramMetricModules CwtProgramMetricModules =
		//(CwtProgramMetricModules)session.get(CwtProgramMetricModules.class, CwtProgramMetricModulesID);
		//CwtProgramMetricModules.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtProgramMetricModules */
	public void deleteCwtProgramMetricModules(Integer key){
		Transaction tx = null;
		
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			CwtProgramMetricModules obj =
			(CwtProgramMetricModules)session.get(CwtProgramMetricModules.class, key);
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


