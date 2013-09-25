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

import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class SystemUserDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(SystemUserDao.class.getName());
	private static Session session;
	
	public SystemUserDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public SystemUser findById(Long id) {
		
		SystemUser SystemUser = (SystemUser) session.get(SystemUser.class, id);
		
		return SystemUser;
	}
	
	public SystemUser authenticate(String username, String password) {
		Query q = session.createQuery("from SystemUser where username = :username and password = :password");
		q.setString("username", username);
		q.setString("password", password);
		
		List result = q.list();
		if (result.size()>0)
			return (SystemUser)result.get(0);
		else 
			return null;
	}
	
	public List listSystemUsers() {
		LOGGER.setLevel(Level.INFO);
	    List<SystemUser> list = new ArrayList<SystemUser>();
	    Transaction tx = null;        
        try {
            tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM SystemUser").list();                       
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
	
	/* Method to INSERT SystemUser */
	public Long addSystemUser(SystemUser obj){
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
	

	/* Method to UPDATE SystemUser */
	public void updateSystemUser(SystemUser obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//SystemUser SystemUser =
		//(SystemUser)session.get(SystemUser.class, SystemUserID);
		//SystemUser.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE SystemUser */
	public void deleteSystemUser(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			SystemUser obj =
			(SystemUser)session.get(SystemUser.class, key);
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


