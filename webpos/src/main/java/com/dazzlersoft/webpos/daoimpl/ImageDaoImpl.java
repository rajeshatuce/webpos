package com.dazzlersoft.webpos.daoimpl;

// Generated Jul 20, 2014 1:48:03 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dazzlersoft.webpos.dao.ImageDao;
import com.dazzlersoft.webpos.model.Image;

/**
 * Home object for domain model class Image.
 * @see com.dazzlersoft.webpos.model.Image
 * @author Hibernate Tools
 */
@Repository
public class ImageDaoImpl implements ImageDao {

	private static final Log log = LogFactory.getLog(ImageDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Image transientInstance) {
		log.debug("persisting Image instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Image instance) {
		log.debug("attaching dirty Image instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Image instance) {
		log.debug("attaching clean Image instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Image persistentInstance) {
		log.debug("deleting Image instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Image merge(Image detachedInstance) {
		log.debug("merging Image instance");
		try {
			Image result = (Image) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Image findById(long id) {
		log.debug("getting Image instance with id: " + id);
		try {
			Image instance = (Image) sessionFactory.getCurrentSession().get(
					"com.dazzlersoft.webpos.model.Image", id);
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

	@SuppressWarnings("unchecked")
	public List<Image> findByExample(Image instance) {
		log.debug("finding Image instance by example");
		try {
			List<Image> results = sessionFactory.getCurrentSession()
					.createCriteria("com.dazzlersoft.webpos.model.Image")
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
