package pers.yijin.crm.staff.dao.impl;

import java.util.List;

import pers.yijin.crm.base.impl.BaseDaoImpl;
import pers.yijin.crm.staff.dao.StaffDao;
import pers.yijin.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {

	@SuppressWarnings("unchecked")
	@Override
	public CrmStaff find(String loginName, String loginPwd) {
		String HQL = "from CrmStaff as staff where staff.loginName=? and staff.loginPwd=?";
		List<CrmStaff> staff = this.getHibernateTemplate().find(HQL, loginName,
				loginPwd);
		if (staff.size() == 1) {
			return staff.get(0);
		}
		return null;
	}

}
