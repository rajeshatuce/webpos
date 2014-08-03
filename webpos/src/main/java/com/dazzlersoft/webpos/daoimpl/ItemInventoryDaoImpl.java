package com.dazzlersoft.webpos.daoimpl;

// Generated Jul 20, 2014 1:48:03 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dazzlersoft.webpos.dao.ItemInventoryDao;
import com.dazzlersoft.webpos.model.ItemInventory;

/**
 * Home object for domain model class ItemInventory.
 * @see com.dazzlersoft.webpos.model.ItemInventory
 * @author Hibernate Tools
 */
@Repository
public class ItemInventoryDaoImpl implements ItemInventoryDao {

	private static final Log log = LogFactory.getLog(ItemInventoryDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory ;

	public void persist(ItemInventory transientInstance) {
		log.debug("persisting ItemInventory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ItemInventory instance) {
		log.debug("attaching dirty ItemInventory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ItemInventory instance) {
		log.debug("attaching clean ItemInventory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ItemInventory persistentInstance) {
		log.debug("deleting ItemInventory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ItemInventory merge(ItemInventory detachedInstance) {
		log.debug("merging ItemInventory instance");
		try {
			ItemInventory result = (ItemInventory) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ItemInventory findById(long id) {
		log.debug("getting ItemInventory instance with id: " + id);
		try {
			ItemInventory instance = (ItemInventory) sessionFactory
					.getCurrentSession().get(
							"com.dazzlersoft.webpos.model.ItemInventory", id);
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
	public List<ItemInventory> findByExample(ItemInventory instance) {
		log.debug("finding ItemInventory instance by example");
		try {
			List<ItemInventory> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.dazzlersoft.webpos.model.ItemInventory")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ItemInventory> findByInventoryIdList(List<Long> iventoryIdList) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(ItemInventory.class);
		criteria.add(Restrictions.in("itemInventoryId", iventoryIdList));
		criteria.createAlias("item", "i");
		criteria.addOrder(Order.asc("i.itemName"));
		return criteria.list();
	}
}
