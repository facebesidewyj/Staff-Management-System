package pers.yijin.crm.staff.web.action;

import java.util.List;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.staff.domain.CrmStaff;

import com.opensymphony.xwork2.ActionContext;

public class StaffAction extends BaseAction<CrmStaff> {
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		CrmStaff loginStaff = this.getStaffService().login(getModel());
		//判断是否查询到了信息
		if(loginStaff != null){
			//放入session中
			this.putSession("staff", loginStaff);
			return SUCCESS;
		}
		//未查到，提示信息
		this.addFieldError("", "用户名或密码不正确！");
		return "login";
	}
	
	/**
	 * 首页展示
	 */
	public String home(){
		return "home";
	}
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public String findAll(){
		List<CrmStaff> allStaff = this.getStaffService().findAllStaff();
		//把结果存入值栈或ContextMap中
		this.set("allStaff", allStaff);
		return "findAll";
	}
	
	/**
	 * 编辑员工前的数据回显
	 * @return
	 */
	public String editUI(){
		CrmStaff findStaff = this.getStaffService().findStaffById(this.getModel().getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		//需要手动获得所有部门的集合，因为关联数据中没有部门集合这一字段
		List<CrmDepartment> findAllDepartment = this.getDepartmentService().findAllDepartment();
		this.set("findAllDepartment", findAllDepartment);
		return "editUI";
	}
	
	public String edit(){
		this.getStaffService().updateStaff(this.getModel());
		return "edit";
	}
}
