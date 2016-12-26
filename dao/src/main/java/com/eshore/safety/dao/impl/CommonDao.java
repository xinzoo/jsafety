package com.eshore.prip.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eshore.prip.dao.ICommonDao;

@Repository("commonDao")
public class CommonDao implements ICommonDao {
	// private static Logger logger = LoggerFactory.getLogger(CommonDao.class);

	@Autowired
	protected SessionFactory sessionFactory;

	// @Autowired
	// protected HibernateTemplate hibernateTemplate;
	@Transactional
	public Integer executeHql(final String hql, final Map<String, Object> params) {
		return this.doExecute(hql, params, true);
	}

	@Transactional
	public Integer executeSql(final String sql, final Map<String, Object> params) {
		return this.doExecute(sql, params, false);
	}
	
	@Transactional
	public void doWork(final Work work) {
		Session session = sessionFactory.getCurrentSession();
		session.doWork(work);
	}


	private Integer doExecute(final String hqlOrSql,
			final Map<String, Object> params, final boolean isHql) {
		Session session = sessionFactory.getCurrentSession();
		Query query;
		if (isHql) {
			query = session.createQuery(hqlOrSql);
		} else {
			query = session.createSQLQuery(hqlOrSql);
		}
		Set<String> pNames = params.keySet();
		for (String pName : pNames) {
			Object param = params.get(pName);
			if (param instanceof Collection<?>) {
				query.setParameterList(pName, (Collection<?>) param);
			} else if (param instanceof Object[]) {
				query.setParameterList(pName, (Object[]) param);
			} else {
				query.setParameter(pName, params.get(pName));
			}
		}
		return query.executeUpdate();

	}
	
	@Transactional
	public Integer executeHql(final String hql, final Object... params) {
		return this.doExecute(hql, params, true);
	}
	@Transactional
	public Integer executeSql(final String sql, final Object... params) {
		return this.doExecute(sql, params, false);
	}


	private Integer doExecute(final String hqlOrSql, final Object[] params,
			final boolean isHql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (isHql) {
			query = session.createQuery(hqlOrSql);
		} else {
			query = session.createSQLQuery(hqlOrSql);
		}
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		return query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	private <T> List<T> find(final String sqlOrHql, Class<T> clazz,
			final boolean isHql, final int pageNo, final int pageSize,
			final Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (isHql) {
			query = session.createQuery(sqlOrHql);
		} else {
			query = session.createSQLQuery(sqlOrHql);
		}
		if (pageSize > 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}

		if (params != null) {
			Set<String> pNames = params.keySet();
			for (String pName : pNames) {
				Object param = params.get(pName);
				if (param instanceof Collection<?>) {
					query.setParameterList(pName, (Collection<?>) param);
				} else if (param instanceof Object[]) {
					query.setParameterList(pName, (Object[]) param);
				} else {
					query.setParameter(pName, params.get(pName));
				}
			}
		}

		return (List<T>) query.list();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	private <T> List<T> find(final String sqlOrHql, Class<T> clazz,
			final boolean isHql, final int pageNo, final int pageSize,
			final Object... params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (isHql) {
			query = session.createQuery(sqlOrHql);
		} else {
			query = session.createSQLQuery(sqlOrHql);
		}
		if (pageSize > 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}

		return query.list();

	}

	/**
	 * 根据SQL原生语句和查询参数获取数据持久化对象集合
	 * 
	 * @param <T>
	 * @param sql
	 * @return
	 */
	@Transactional(readOnly=true) 
	public <T> List<T> findBySql(final String sql, Class<T> clazz,
			final Map<String, Object> params) {
		return this.find(sql, clazz, false, 0, 0, params);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findByHql(final String hql, Class<T> clazz,
			final Map<String, Object> params) {
		return this.find(hql, clazz, true, 0, 0, params);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findByHql(final String hql, Class<T> clazz) {
		return this.find(hql, clazz, true, 0, 0, (Object[]) null);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findBySql(final String hql, Class<T> clazz) {
		return this.find(hql, clazz, false, 0, 0, (Object[]) null);
	}

	@Override
	@Transactional(readOnly=true)
	public <T> List<T> findBySql(final String sql, final Class<T> clazz,
			final Object... params) {
		return this.find(sql, clazz, false, 0, 0, params);
	}

	@Override
	@Transactional(readOnly=true)
	public <T> List<T> findByHql(final String hql, final Class<T> clazz,
			final Object... params) {
		return this.find(hql, clazz, true, 0, 0, params);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findBySqlPageable(final String sql, Class<T> clazz,
			final int pageNo, final int pageSize,
			final Map<String, Object> params) {
		return this.find(sql, clazz, false, pageNo, pageSize, params);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findByHqlPageable(final String hql, Class<T> clazz,
			final int pageNo, final int pageSize,
			final Map<String, Object> params) {
		return this.find(hql, clazz, true, pageNo, pageSize, params);
	}

	@Transactional(readOnly=true)
	public <T> List<T> findBySqlPageable(final String sql, Class<T> clazz,
			final int pageNo, final int pageSize) {
		return this.find(sql, clazz, false, pageNo, pageSize, (Object[]) null);
	}

	@Transactional
	public Integer executeHql(final String hql) {
		return this.doExecute(hql, true);
	}

	@Transactional
	public Integer executeSql(final String sql) {
		return this.doExecute(sql, false);
	}

	private Integer doExecute(final String hqlOrSql, final boolean isHql) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (isHql) {
			query = session.createQuery(hqlOrSql);
		} else {
			query = session.createSQLQuery(hqlOrSql);
		}
		return query.executeUpdate();

	}

	@Transactional
	public void deleteObject(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Transactional
	public Object mergeObject(Object obj) {
		return sessionFactory.getCurrentSession().merge(obj);
	}

	@Transactional
	public Serializable saveObject(Object obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	@Transactional
	public void saveOrUpdateObject(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	@Transactional
	public void updateObject(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	@Transactional
	public <T> List<T> findByHqlPageable(String hql, Class<T> clazz,
			int pageNo, int pageSize) {
		return this.find(hql, clazz, true, pageNo, pageSize, (Object[]) null);
	}

	@Transactional
	private <T> T findOne(String sqlOrHql, Class<T> clazz, boolean isHql,
			Map<String, Object> params) {
		List<T> list = this.find(sqlOrHql, clazz, isHql, 0, 0, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		// logger.info("findOne but found null");
		return null;
	}

	@Transactional
	private <T> T findOne(String sqlOrHql, Class<T> clazz, boolean isHql,
			Object... params) {
		List<T> list = this.find(sqlOrHql, clazz, isHql, 0, 0, params);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional
	public <T> T findOneByHql(String hql, Class<T> clazz,
			Map<String, Object> params) {
		return this.findOne(hql, clazz, true, params);
	}

	@Override
	@Transactional
	public <T> T findOneBySql(String sql, Class<T> clazz,
			Map<String, Object> params) {
		return this.findOne(sql, clazz, false, params);
	}

	@Override
	@Transactional
	public <T> T findOneByHql(String hql, Class<T> clazz) {
		return this.findOne(hql, clazz, true, (Object[]) null);
	}

	@Override
	@Transactional
	public <T> T findOneBySql(String sql, Class<T> clazz) {
		return this.findOne(sql, clazz, false, (Object[]) null);
	}

	@Override
	@Transactional
	public <T> T findOneByHql(String hql, Class<T> clazz, Object... params) {
		return this.findOne(hql, clazz, true, params);
	}

	@Override
	@Transactional
	public <T> T findOneBySql(String sql, Class<T> clazz, Object... params) {
		return this.findOne(sql, clazz, false, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> T getObject(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T> List<T> getAllObject(Class<T> clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	@Override
	@Transactional
	public <T> List<T> findBySql(String sql, Map<String, Object> params) {
		return this.find(sql, false, 0, 0, params);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	private <T> List<T> find(final String sqlOrHql, final boolean isHql,
			final int pageNo, final int pageSize,
			final Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (isHql) {
			query = session.createQuery(sqlOrHql);
		} else {
			query = session.createSQLQuery(sqlOrHql);
		}
		if (pageSize > 0) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}

		if (params != null) {
			Set<String> pNames = params.keySet();
			for (String pName : pNames) {
				Object param = params.get(pName);
				if (param instanceof Collection<?>) {
					query.setParameterList(pName, (Collection<?>) param);
				} else if (param instanceof Object[]) {
					query.setParameterList(pName, (Object[]) param);
				} else {
					query.setParameter(pName, params.get(pName));

				}
			}
		}

		return (List<T>) query.list();
	}

	@Override
	public void flush() {
		this.sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void evict(Object obj) {
		this.sessionFactory.getCurrentSession().evict(obj);
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
