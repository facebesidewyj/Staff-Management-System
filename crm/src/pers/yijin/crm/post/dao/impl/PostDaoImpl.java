package pers.yijin.crm.post.dao.impl;

import java.util.List;

import pers.yijin.crm.base.impl.BaseDaoImpl;
import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.post.dao.PostDao;
import pers.yijin.crm.post.domain.CrmPost;

public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CrmPost> findAllWithDepartment(CrmDepartment crmDepartment) {
		return this.getHibernateTemplate().find("from CrmPost where department = ?", crmDepartment);
	}

}
