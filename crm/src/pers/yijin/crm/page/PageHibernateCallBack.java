package pers.yijin.crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * ���ڷ�ҳ�Ļص�����
 * 
 * @author wyj
 * 
 * @param <T>
 */
public class PageHibernateCallBack<T> implements HibernateCallback<List<T>> {
	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;

	// ��ʽ����
	public PageHibernateCallBack<T> setHql(String hql) {
		this.hql = hql;
		return this;
	}

	public PageHibernateCallBack<T> setParams(Object[] params) {
		this.params = params;
		return this;
	}

	public PageHibernateCallBack<T> setStartIndex(int startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public PageHibernateCallBack<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		// ���query����
		Query query = session.createQuery(hql);
		// �����������
		for (int i = 0; i < params.length; i++) {
			// ��query�������ò���
			query.setParameter(i, params[i]);
		}
		// ���÷�ҳ���õ�������
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		// ��ѯ����
		return query.list();
	}

}
