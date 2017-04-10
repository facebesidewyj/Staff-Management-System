package pers.yijin.crm.staff.web.action;

import java.util.List;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.staff.domain.CrmStaff;

import com.opensymphony.xwork2.ActionContext;

public class StaffAction extends BaseAction<CrmStaff> {
	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		CrmStaff loginStaff = this.getStaffService().login(getModel());
		//�ж��Ƿ��ѯ������Ϣ
		if(loginStaff != null){
			//����session��
			this.putSession("staff", loginStaff);
			return SUCCESS;
		}
		//δ�鵽����ʾ��Ϣ
		this.addFieldError("", "�û��������벻��ȷ��");
		return "login";
	}
	
	/**
	 * ��ҳչʾ
	 */
	public String home(){
		return "home";
	}
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public String findAll(){
		List<CrmStaff> allStaff = this.getStaffService().findAllStaff();
		//�ѽ������ֵջ��ContextMap��
		this.set("allStaff", allStaff);
		return "findAll";
	}
	
	/**
	 * �༭Ա��ǰ�����ݻ���
	 * @return
	 */
	public String editUI(){
		CrmStaff findStaff = this.getStaffService().findStaffById(this.getModel().getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		//��Ҫ�ֶ�������в��ŵļ��ϣ���Ϊ����������û�в��ż�����һ�ֶ�
		List<CrmDepartment> findAllDepartment = this.getDepartmentService().findAllDepartment();
		this.set("findAllDepartment", findAllDepartment);
		return "editUI";
	}
	
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
}
