package pers.yijin.crm.department.service;

import java.util.List;

import pers.yijin.crm.department.domain.CrmDepartment;

public interface DepartmentService {
	/**
	 * ��ѯ���в���
	 * @return
	 */
	public List<CrmDepartment> findAllDepartment();
}
