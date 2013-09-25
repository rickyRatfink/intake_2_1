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

import com.yada180.sms.domain.State;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class StateDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(StateDao.class.getName());
	private static Session session;
	
	public StateDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public State findById(Integer id) {
		
		State State = (State) session.get(State.class, id);
		
		return State;
	}
	
	public List listStates() {
		LOGGER.setLevel(Level.INFO);
	    List<State> list = new ArrayList<State>();
	    Transaction tx = null;        
        try {
            tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM State").list();                       
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
	
	/* Method to INSERT State */
	public Long addState(State obj){
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
	

	/* Method to UPDATE State */
	public void updateState(State obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//State State =
		//(State)session.get(State.class, StateID);
		//State.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE State */
	public void deleteState(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			State obj =
			(State)session.get(State.class, key);
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


