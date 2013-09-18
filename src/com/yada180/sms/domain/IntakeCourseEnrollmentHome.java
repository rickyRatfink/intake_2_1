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
 * Home object for domain model class IntakeCourseEnrollment.
 * @see com.yada180.sms.domain.IntakeCourseEnrollment
 * @author Hibernate Tools
 */
public class IntakeCourseEnrollmentHome {

	private static final Log log = LogFactory
			.getLog(IntakeCourseEnrollmentHome.class);

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

	public void persist(IntakeCourseEnrollment transientInstance) {
		log.debug("persisting IntakeCourseEnrollment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IntakeCourseEnrollment instance) {
		log.debug("attaching dirty IntakeCourseEnrollment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IntakeCourseEnrollment instance) {
		log.debug("attaching clean IntakeCourseEnrollment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IntakeCourseEnrollment persistentInstance) {
		log.debug("deleting IntakeCourseEnrollment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IntakeCourseEnrollment merge(IntakeCourseEnrollment detachedInstance) {
		log.debug("merging IntakeCourseEnrollment instance");
		try {
			IntakeCourseEnrollment result = (IntakeCourseEnrollment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IntakeCourseEnrollment findById(long id) {
		log.debug("getting IntakeCourseEnrollment instance with id: " + id);
		try {
			IntakeCourseEnrollment instance = (IntakeCourseEnrollment) sessionFactory
					.getCurrentSession()
					.get("com.yada180.sms.domain.IntakeCourseEnrollment", id);
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

	public List findByExample(IntakeCourseEnrollment instance) {
		log.debug("finding IntakeCourseEnrollment instance by example");
		try {
			List results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.yada180.sms.domain.IntakeCourseEnrollment")
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
