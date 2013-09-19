package com.yada180.sms.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yada180.sms.domain.CwtSupervisor;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtSupervisorDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtSupervisorDao.class.getName());
	private static Session session;
	
	public CwtSupervisorDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtSupervisor findById(Integer id) {
		
		CwtSupervisor CwtSupervisor = (CwtSupervisor) session.get(CwtSupervisor.class, id);
		
		return CwtSupervisor;
	}
	
	public List listCwtSupervisors() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtSupervisor> list = new ArrayList<CwtSupervisor>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtSupervisor").list();                       
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
	
	/* Method to INSERT CwtSupervisor */
	public Long addCwtSupervisor(CwtSupervisor obj){
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
	

	/* Method to UPDATE CwtSupervisor */
	public void updateCwtSupervisor(CwtSupervisor obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//CwtSupervisor CwtSupervisor =
		//(CwtSupervisor)session.get(CwtSupervisor.class, CwtSupervisorID);
		//CwtSupervisor.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtSupervisor */
	public void deleteCwtSupervisor(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			CwtSupervisor obj =
			(CwtSupervisor)session.get(CwtSupervisor.class, key);
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


