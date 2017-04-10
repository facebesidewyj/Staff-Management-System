package pers.yijin.crm.post.dao;

import java.util.List;

import pers.yijin.crm.base.BaseDao;
import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.post.domain.CrmPost;

public interface PostDao extends BaseDao<CrmPost> {
	/**
	 * 根据部门查所有职务
	 * @param crmDepartment
	 * @return
	 */
	public List<CrmPost> findAllWithDepartment(CrmDepartment crmDepartment);
}
