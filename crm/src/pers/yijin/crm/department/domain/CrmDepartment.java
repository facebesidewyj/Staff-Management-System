package pers.yijin.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import pers.yijin.crm.post.domain.CrmPost;

/**
 * 部门类
 * 
 * @author wyj
 * 
 */
public class CrmDepartment {
	private String depId;
	private String depName;

	// 一对多：一个部门对应多个职务
	private Set<CrmPost> postSet = new HashSet<CrmPost>();

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<CrmPost> getPostSet() {
		return postSet;
	}

	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}

}
