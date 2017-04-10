package pers.yijin.crm.staff.service;

import java.util.List;

import pers.yijin.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * ��¼����
	 * 
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);

	/**
	 * ��������Ա��
	 * 
	 * @return
	 */
	public List<CrmStaff> findAllStaff();

	/**
	 * ����Id����Ա��
	 * 
	 * @param staffId
	 * @return
	 */
	public CrmStaff findStaffById(String staffId);

	/**
	 * �༭Ա��
	 * 
	 * @param crmStaff
	 */
	public void updateStaff(CrmStaff crmStaff);
}
