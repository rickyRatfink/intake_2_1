package com.yada180.sms.domain;

// Generated Sep 18, 2013 1:34:39 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class IntakeMedicalCondition.
 * @see com.yada180.sms.domain.IntakeMedicalCondition
 * @author Hibernate Tools
 */
public class IntakeMedicalConditionHome {

	private static final Log log = LogFactory
			.getLog(IntakeMedicalConditionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(IntakeMedicalCondition transientInstance) {
		log.debug("persisting IntakeMedicalCondition instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IntakeMedicalCondition instance) {
		log.debug("attaching dirty IntakeMedicalCondition instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IntakeMedicalCondition instance) {
		log.debug("attaching clean IntakeMedicalCondition instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IntakeMedicalCondition persistentInstance) {
		log.debug("deleting IntakeMedicalCondition instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IntakeMedicalCondition merge(IntakeMedicalCondition detachedInstance) {
		log.debug("merging IntakeMedicalCondition instance");
		try {
			IntakeMedicalCondition result = (IntakeMedicalCondition) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IntakeMedicalCondition findById(java.lang.Long id) {
		log.debug("getting IntakeMedicalCondition instance with id: " + id);
		try {
			IntakeMedicalCondition instance = (IntakeMedicalCondition) sessionFactory
					.getCurrentSession()
					.get("com.yada180.sms.domain.IntakeMedicalCondition", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(IntakeMedicalCondition instance) {
		log.debug("finding IntakeMedicalCondition instance by example");
		try {
			List results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.yada180.sms.domain.IntakeMedicalCondition")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
