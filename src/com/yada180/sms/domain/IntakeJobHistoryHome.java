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
 * Home object for domain model class IntakeJobHistory.
 * @see com.yada180.sms.domain.IntakeJobHistory
 * @author Hibernate Tools
 */
public class IntakeJobHistoryHome {

	private static final Log log = LogFactory
			.getLog(IntakeJobHistoryHome.class);

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

	public void persist(IntakeJobHistory transientInstance) {
		log.debug("persisting IntakeJobHistory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IntakeJobHistory instance) {
		log.debug("attaching dirty IntakeJobHistory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IntakeJobHistory instance) {
		log.debug("attaching clean IntakeJobHistory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IntakeJobHistory persistentInstance) {
		log.debug("deleting IntakeJobHistory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IntakeJobHistory merge(IntakeJobHistory detachedInstance) {
		log.debug("merging IntakeJobHistory instance");
		try {
			IntakeJobHistory result = (IntakeJobHistory) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IntakeJobHistory findById(long id) {
		log.debug("getting IntakeJobHistory instance with id: " + id);
		try {
			IntakeJobHistory instance = (IntakeJobHistory) sessionFactory
					.getCurrentSession().get(
							"com.yada180.sms.domain.IntakeJobHistory", id);
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

	public List findByExample(IntakeJobHistory instance) {
		log.debug("finding IntakeJobHistory instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.yada180.sms.domain.IntakeJobHistory")
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