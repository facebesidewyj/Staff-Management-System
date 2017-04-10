package pers.yijin.crm.post.service;

import java.util.List;

import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.post.domain.CrmPost;

public interface PostService {
	/**
	 * 根据部门查询所有职务
	 * @return
	 */
	public List<CrmPost> findAllWithDepartment(CrmDepartment crmDepartment);
}
