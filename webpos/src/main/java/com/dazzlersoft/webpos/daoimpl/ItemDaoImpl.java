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

import com.dazzlersoft.webpos.dao.ItemDao;
import com.dazzlersoft.webpos.model.Item;

/**
 * Home object for domain model class Item.
 * @see com.dazzlersoft.webpos.model.Item
 * @author Hibernate Tools
 */
@Repository
public class ItemDaoImpl implements ItemDao{

	private static final Log log = LogFactory.getLog(ItemDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Item transientInstance) {
		log.debug("persisting Item instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Item instance) {
		log.debug("attaching dirty Item instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Item instance) {
		log.debug("attaching clean Item instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Item persistentInstance) {
		log.debug("deleting Item instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Item merge(Item detachedInstance) {
		log.debug("merging Item instance");
		try {
			Item result = (Item) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Item findById(long id) {
		log.debug("getting Item instance with id: " + id);
		try {
			Item instance = (Item) sessionFactory.getCurrentSession().get(
					"com.dazzlersoft.webpos.model.Item", id);
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
	public List<Item> findByExample(Item instance) {
		log.debug("finding Item instance by example");
		try {
			List<Item> results = sessionFactory.getCurrentSession()
					.createCriteria("com.dazzlersoft.webpos.model.Item")
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
