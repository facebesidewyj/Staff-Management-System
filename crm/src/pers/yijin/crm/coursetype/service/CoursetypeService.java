package pers.yijin.crm.coursetype.service;

import pers.yijin.crm.coursetype.domain.CrmCourseType;
import pers.yijin.crm.page.PageBean;

public interface CoursetypeService {


	/**
	 * ����Id���ҿγ�
	 * 
	 * @param crmCourseType
	 * @return
	 */
	public CrmCourseType findCourseById(CrmCourseType crmCourseType);

	/**
	 * ��ӻ�༭����
	 * 
	 * @param crmCourseType
	 */
	public void addOrEdit(CrmCourseType crmCourseType);

	/**
	 * ��ҳ+������ѯ
	 * 
	 * @param courseType
	 * @return
	 */
	public PageBean<CrmCourseType> findAllByCondition(CrmCourseType crmCourseType,
			int pageNum, int pageSize);
}
