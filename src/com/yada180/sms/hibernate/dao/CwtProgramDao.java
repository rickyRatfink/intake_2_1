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

import com.yada180.sms.domain.CwtProgram;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtProgramDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtProgramDao.class.getName());
	private static Session session;
	
	public CwtProgramDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtProgram findById(Integer id) {
		
		CwtProgram CwtProgram = (CwtProgram) session.get(CwtProgram.class, id);
		
		return CwtProgram;
	}
	
	public List listCwtPrograms() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtProgram> list = new ArrayList<CwtProgram>();
	    Transaction tx = null;        
        try {
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtProgram").list();                       
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
	
	/* Method to INSERT CwtProgram */
	public Long addCwtProgram(CwtProgram obj){
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
	

	/* Method to UPDATE CwtProgram */
	public void updateCwtProgram(CwtProgram obj){
		Transaction tx = null;
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
		//CwtProgram CwtProgram =
		//(CwtProgram)session.get(CwtProgram.class, CwtProgramID);
		//CwtProgram.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtProgram */
	public void deleteCwtProgram(Integer key){
		Transaction tx = null;
		
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			CwtProgram obj =
			(CwtProgram)session.get(CwtProgram.class, key);
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


