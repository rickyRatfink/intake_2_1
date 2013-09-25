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

import com.yada180.sms.domain.Question;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class QuestionDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(QuestionDao.class.getName());
	private static Session session;
	
	public QuestionDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public Question findById(Integer id) {
		
		Question Question = (Question) session.get(Question.class, id);
		
		return Question;
	}
	
	public List listQuestions() {
		LOGGER.setLevel(Level.INFO);
	    List<Question> list = new ArrayList<Question>();
	    Transaction tx = null;        
        try {
            tx = session.beginTransaction();
            tx.begin();
            list = session.createQuery("FROM Question").list();                       
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
	
	/* Method to INSERT Question */
	public Long addQuestion(Question obj){
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
	

	/* Method to UPDATE Question */
	public void updateQuestion(Question obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//Question Question =
		//(Question)session.get(Question.class, QuestionID);
		//Question.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE Question */
	public void deleteQuestion(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Question obj =
			(Question)session.get(Question.class, key);
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


