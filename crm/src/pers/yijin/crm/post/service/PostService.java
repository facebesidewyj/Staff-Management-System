package pers.yijin.crm.post.service;

import java.util.List;

import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.post.domain.CrmPost;

public interface PostService {
	/**
	 * ���ݲ��Ų�ѯ����ְ��
	 * @return
	 */
	public List<CrmPost> findAllWithDepartment(CrmDepartment crmDepartment);
}
