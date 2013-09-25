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

import com.yada180.sms.domain.MedicalCondition;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class MedicalConditionDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(MedicalConditionDao.class.getName());
	private static Session session;
	
	public MedicalConditionDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public MedicalCondition findById(Integer id) {
		
		MedicalCondition MedicalCondition = (MedicalCondition) session.get(MedicalCondition.class, id);
		
		return MedicalCondition;
	}
	
	public List listMedicalConditions() {
		LOGGER.setLevel(Level.INFO);
	    List<MedicalCondition> list = new ArrayList<MedicalCondition>();
	    Transaction tx = null;        
        try {
            tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM MedicalCondition").list();                       
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
	
	/* Method to INSERT MedicalCondition */
	public Long addMedicalCondition(MedicalCondition obj){
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
	

	/* Method to UPDATE MedicalCondition */
	public void updateMedicalCondition(MedicalCondition obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//MedicalCondition MedicalCondition =
		//(MedicalCondition)session.get(MedicalCondition.class, MedicalConditionID);
		//MedicalCondition.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE MedicalCondition */
	public void deleteMedicalCondition(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			MedicalCondition obj =
			(MedicalCondition)session.get(MedicalCondition.class, key);
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


