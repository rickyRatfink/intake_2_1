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

import com.yada180.sms.domain.CwtModuleStudent;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class CwtModuleStudentDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(CwtModuleStudentDao.class.getName());
	private static Session session;
	
	public CwtModuleStudentDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public CwtModuleStudent findById(Integer id) {
		
		CwtModuleStudent CwtModuleStudent = (CwtModuleStudent) session.get(CwtModuleStudent.class, id);
		
		return CwtModuleStudent;
	}
	
	public List listCwtModuleStudents() {
		LOGGER.setLevel(Level.INFO);
	    List<CwtModuleStudent> list = new ArrayList<CwtModuleStudent>();
	    Transaction tx = null;        
        try {
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM CwtModuleStudent").list();                       
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
	
	/* Method to INSERT CwtModuleStudent */
	public Long addCwtModuleStudent(CwtModuleStudent obj){
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
	

	/* Method to UPDATE CwtModuleStudent */
	public void updateCwtModuleStudent(CwtModuleStudent obj){
		Transaction tx = null;
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
		//CwtModuleStudent CwtModuleStudent =
		//(CwtModuleStudent)session.get(CwtModuleStudent.class, CwtModuleStudentID);
		//CwtModuleStudent.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE CwtModuleStudent */
	public void deleteCwtModuleStudent(Integer key){
		Transaction tx = null;
		
		try{
			if (!session.isOpen())
				session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			CwtModuleStudent obj =
			(CwtModuleStudent)session.get(CwtModuleStudent.class, key);
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


