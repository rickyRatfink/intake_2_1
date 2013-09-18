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
 * Home object for domain model class CwtJobAssignment.
 * @see com.yada180.sms.domain.CwtJobAssignment
 * @author Hibernate Tools
 */
public class CwtJobAssignmentHome {

	private static final Log log = LogFactory
			.getLog(CwtJobAssignmentHome.class);

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

	public void persist(CwtJobAssignment transientInstance) {
		log.debug("persisting CwtJobAssignment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CwtJobAssignment instance) {
		log.debug("attaching dirty CwtJobAssignment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CwtJobAssignment instance) {
		log.debug("attaching clean CwtJobAssignment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CwtJobAssignment persistentInstance) {
		log.debug("deleting CwtJobAssignment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CwtJobAssignment merge(CwtJobAssignment detachedInstance) {
		log.debug("merging CwtJobAssignment instance");
		try {
			CwtJobAssignment result = (CwtJobAssignment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CwtJobAssignment findById(java.lang.Long id) {
		log.debug("getting CwtJobAssignment instance with id: " + id);
		try {
			CwtJobAssignment instance = (CwtJobAssignment) sessionFactory
					.getCurrentSession().get(
							"com.yada180.sms.domain.CwtJobAssignment", id);
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

	public List findByExample(CwtJobAssignment instance) {
		log.debug("finding CwtJobAssignment instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.yada180.sms.domain.CwtJobAssignment")
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
