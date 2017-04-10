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
		//ʹ��MD5����
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
		//�������dao������hibernate�����һ����������նԱȣ��Զ����µ����ݿ�
		findStaff.setLoginName(crmStaff.getLoginName());
		findStaff.setStaffName(crmStaff.getStaffName());
		findStaff.setGender(crmStaff.getGender());
		findStaff.setOnDutyDate(crmStaff.getOnDutyDate());
		//������ְ��Ͳ��Żᱨ�������
		findStaff.setPost(crmStaff.getPost());
	}
}
