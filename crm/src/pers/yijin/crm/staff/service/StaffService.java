package pers.yijin.crm.staff.service;

import java.util.List;

import pers.yijin.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * 登录方法
	 * 
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);

	/**
	 * 查找所有员工
	 * 
	 * @return
	 */
	public List<CrmStaff> findAllStaff();

	/**
	 * 根据Id查找员工
	 * 
	 * @param staffId
	 * @return
	 */
	public CrmStaff findStaffById(String staffId);

	/**
	 * 编辑员工
	 * 
	 * @param crmStaff
	 */
	public void updateStaff(CrmStaff crmStaff);
}
