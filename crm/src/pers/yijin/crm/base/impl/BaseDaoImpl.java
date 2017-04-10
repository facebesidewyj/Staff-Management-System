package pers.yijin.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pers.yijin.crm.base.BaseDao;
import pers.yijin.crm.classes.domain.CrmClasses;
import pers.yijin.crm.page.PageHibernateCallBack;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<?> beanClass;

	//����<T>�ڱ���ʱ�������͵ģ�ֻ�Ǳ�����Tֻ���������Ժ�ſ��Ի�þ������ͣ����౻newʱ������Ĺ��췽����ִ��
	public BaseDaoImpl() {
		//ParameterizedType�Ǳ��������˵����ͣ����磺BaseDaoImpl<CrmClasses>
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		//getActualTypeArguments()�������ʵ�ʲ���ֵ�����Ƿ��͵����ͣ�һ�������Ϊ1������������Ϊ.class���ֽ����ļ�
		beanClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// getName()���ȫ�޶���
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByCondition(String condition, Object[] params) {
		String hql = "from " + beanClass.getName() + " where 1 = 1 "
				+ condition;
		return this.getHibernateTemplate().find(hql, params);
	}

	@Override
	public List<T> findAllByPage(String condition, Object[] params,
			int startIndex, int pageSize) {
		String hql = "from " + beanClass.getName() + " where 1 = 1 "
				+ condition;
		return this.getHibernateTemplate().execute(
				new PageHibernateCallBack<T>().setHql(hql).setParams(params)
						.setStartIndex(startIndex).setPageSize(pageSize));
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalRecord(String condition, Object[] params) {
		String hql = "select count(c) from " + beanClass.getName()
				+ " as c where 1 = 1 " + condition;
		List<Long> list = this.getHibernateTemplate().find(hql, params);
		return list.get(0).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByQBC(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAllByPage(DetachedCriteria criteria, int startIndex,
			int pageSize) {
		return this.getHibernateTemplate().findByCriteria(criteria, startIndex,
				pageSize);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

}
