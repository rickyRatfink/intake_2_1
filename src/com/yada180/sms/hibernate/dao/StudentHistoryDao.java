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

import com.yada180.sms.domain.StudentHistory;
import com.yada180.sms.domain.SystemUser;
import com.yada180.sms.hibernate.HibernateUtil;

public class StudentHistoryDao {
	private static SessionFactory factory;
	private final static Logger LOGGER = Logger.getLogger(StudentHistoryDao.class.getName());
	private static Session session;
	
	public StudentHistoryDao() { 
		
		LOGGER.setLevel(Level.INFO);
		   
		try{
			session = HibernateUtil.openSession();
			}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
			}
	}
	
	public StudentHistory findById(Integer id) {
		
		StudentHistory StudentHistory = (StudentHistory) session.get(StudentHistory.class, id);
		
		return StudentHistory;
	}
	
	public List listStudentHistorys() {
		LOGGER.setLevel(Level.INFO);
	    List<StudentHistory> list = new ArrayList<StudentHistory>();
	    Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("FROM StudentHistory").list();                       
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
	
	/* Method to INSERT StudentHistory */
	public Long addStudentHistory(StudentHistory obj){
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
	

	/* Method to UPDATE StudentHistory */
	public void updateStudentHistory(StudentHistory obj){
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		//StudentHistory StudentHistory =
		//(StudentHistory)session.get(StudentHistory.class, StudentHistoryID);
		//StudentHistory.setSalary( salary );
		session.update(obj);
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		}
	
	/* Method to DELETE StudentHistory */
	public void deleteStudentHistory(Integer key){
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			StudentHistory obj =
			(StudentHistory)session.get(StudentHistory.class, key);
			session.delete(obj);
			tx.commit();
			}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			}

	public List search(Long key) {
		
		StringBuffer query = new StringBuffer("from StudentHistory");
			query.append(" where intakeId = :intakeId ");
		Query q = session.createQuery(query.toString());
		q.setLong("intakeId", key);
		
		List list = q.list();
		return list;
	}
}


