package pers.yijin.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.staff.domain.CrmStaff;

/**
 * 职务类
 * 
 * @author wyj
 * 
 */
public class CrmPost {
	private String postId;
	private String postName;

	// 多对一：多个职务对应一个部门
	// 注意不要实例化
	private CrmDepartment department;

	// 一对多：一个职务对应多个员工
	private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public CrmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}

	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}

	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}

}
