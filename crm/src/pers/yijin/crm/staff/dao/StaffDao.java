package pers.yijin.crm.staff.dao;

import pers.yijin.crm.base.BaseDao;
import pers.yijin.crm.staff.domain.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff>{
	/**
	 * Ô±¹¤µÇÂ¼
	 * 
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName, String loginPwd);
	
}
