package pers.yijin.crm.department.service;

import java.util.List;

import pers.yijin.crm.department.domain.CrmDepartment;

public interface DepartmentService {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<CrmDepartment> findAllDepartment();
}
