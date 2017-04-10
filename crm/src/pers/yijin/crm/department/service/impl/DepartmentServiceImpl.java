package pers.yijin.crm.department.service.impl;

import java.util.List;

import pers.yijin.crm.department.dao.DepartmentDao;
import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<CrmDepartment> findAllDepartment() {
		return departmentDao.findAll();
	}

}
