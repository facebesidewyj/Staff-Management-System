package pers.yijin.crm.coursetype.service;

import pers.yijin.crm.coursetype.domain.CrmCourseType;
import pers.yijin.crm.page.PageBean;

public interface CoursetypeService {


	/**
	 * 根据Id查找课程
	 * 
	 * @param crmCourseType
	 * @return
	 */
	public CrmCourseType findCourseById(CrmCourseType crmCourseType);

	/**
	 * 添加或编辑操作
	 * 
	 * @param crmCourseType
	 */
	public void addOrEdit(CrmCourseType crmCourseType);

	/**
	 * 分页+条件查询
	 * 
	 * @param courseType
	 * @return
	 */
	public PageBean<CrmCourseType> findAllByCondition(CrmCourseType crmCourseType,
			int pageNum, int pageSize);
}
