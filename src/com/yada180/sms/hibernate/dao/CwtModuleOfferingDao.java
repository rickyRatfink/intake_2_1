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

import com.yada180.sms.domain.CwtModuleOffering;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtModuleOfferingDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtModuleOfferingDao.class.getName());
	private static Session session;
	
	public CwtModuleOfferingDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtModuleOffering findById(Integer id) {
		
		CwtModuleOffering CwtModuleOffering = (CwtModuleOffering) session.get(CwtModuleOffering.class, id);
		
		return CwtModuleOffering;
	}
	
	public List listCwtModuleOfferings() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtModuleOffering> list = new ArrayList<CwtModuleOffering>();
	    Transaction tx = null;        
        try {
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtModuleOffering").list();                       
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
	
	/* Method to INSERT CwtModuleOffering */
	public Long addCwtModuleOffering(CwtModuleOffering obj){
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
	

	/* Method to UPDATE CwtModuleOffering */
	public void updateCwtModuleOffering(CwtModuleOffering obj){
		Transaction tx = null;
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
		//CwtModuleOffering CwtModuleOffering =
		//(CwtModuleOffering)session.get(CwtModuleOffering.class, CwtModuleOfferingID);
		//CwtModuleOffering.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtModuleOffering */
	public void deleteCwtModuleOffering(Integer key){
		Transaction tx = null;
		
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			CwtModuleOffering obj =
			(CwtModuleOffering)session.get(CwtModuleOffering.class, key);
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


