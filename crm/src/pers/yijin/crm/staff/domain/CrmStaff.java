package pers.yijin.crm.staff.domain;

import java.util.Date;

import pers.yijin.crm.post.domain.CrmPost;

/**
 * Ա����
 * 
 * @author wyj
 * 
 */
public class CrmStaff {
	private String staffId;
	private String loginName;	//��¼��
	private String loginPwd;	//����
	private String staffName;	//Ա����
	private String gender;		//�Ա�
	private Date onDutyDate;	//��ְ����

	// ���һ�����Ա����Ӧһ��ְ��
	private CrmPost post;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getOnDutyDate() {
		return onDutyDate;
	}

	public void setOnDutyDate(Date onDutyDate) {
		this.onDutyDate = onDutyDate;
	}

	public CrmPost getPost() {
		return post;
	}

	public void setPost(CrmPost post) {
		this.post = post;
	}

}
