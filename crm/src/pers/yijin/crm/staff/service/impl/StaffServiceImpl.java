package pers.yijin.crm.staff.service.impl;

import java.util.List;

import pers.yijin.crm.staff.dao.StaffDao;
import pers.yijin.crm.staff.domain.CrmStaff;
import pers.yijin.crm.staff.service.StaffService;
import pers.yijin.crm.util.MD5Util;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public CrmStaff login(CrmStaff staff) {
		//使用MD5加密
		String loginPwd = MD5Util.getMD5(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd);
	}

	@Override
	public List<CrmStaff> findAllStaff() {
		return staffDao.findAll();
	}

	@Override
	public CrmStaff findStaffById(String staffId) {
		return staffDao.findById(staffId);
	}

	@Override
	public void updateStaff(CrmStaff crmStaff) {
		CrmStaff findStaff = staffDao.findById(crmStaff.getStaffId());
		if(!findStaff.getLoginPwd().equals(crmStaff.getLoginPwd())){
			String pwd = MD5Util.getMD5(crmStaff.getLoginPwd());
			findStaff.setLoginPwd(pwd);
		}
		//无须调用dao方法，hibernate会进行一级缓存与快照对比，自动更新到数据库
		findStaff.setLoginName(crmStaff.getLoginName());
		findStaff.setStaffName(crmStaff.getStaffName());
		findStaff.setGender(crmStaff.getGender());
		findStaff.setOnDutyDate(crmStaff.getOnDutyDate());
		//不设置职务和部门会报错，待解决
		findStaff.setPost(crmStaff.getPost());
	}
}
