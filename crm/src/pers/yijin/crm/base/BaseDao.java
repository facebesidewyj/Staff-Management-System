package pers.yijin.crm.base;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	/**
	 * ��Ӳ���
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * ɾ������
	 * 
	 * @param t
	 */
	public void delete(T t);

	/**
	 * �޸Ĳ���
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * ��ӻ���²���
	 * 
	 * @param t
	 */
	public void saveOrUpdate(T t);

	/**
	 * ͨ��Id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public T findById(java.io.Serializable id);

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * ͨ��������ѯ����
	 * 
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<T> findAllByCondition(String condition, Object[] params);

	/**
	 * ����+��ҳ��ѯ
	 * 
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAllByPage(String condition, Object[] params,
			int startIndex, int pageSize);

	/**
	 * ��ѯ�ܼ�¼��+������ѯ
	 * 
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);

	/**
	 * ���߲�ѯ
	 * 
	 * @param criteria
	 * @return
	 */
	public List<T> findAllByQBC(DetachedCriteria criteria);

	/**
	 * ʹ��QBC���з�ҳ��ѯ
	 * 
	 * @param criteria
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<T> findAllByPage(DetachedCriteria criteria, int startIndex,
			int pageSize);

}
