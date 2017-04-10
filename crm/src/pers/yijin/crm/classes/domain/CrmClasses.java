package pers.yijin.crm.classes.domain;

import java.util.Date;

import pers.yijin.crm.coursetype.domain.CrmCourseType;

/**
 * �༶��
 * 
 * @author wyj
 * 
 */
public class CrmClasses {
	private String classId;
	private String name;

	private Date beginTime; // ����ʱ��
	private Date endTime; // ��ҵʱ��
	private String status; // ״̬

	private Integer totalCount; // ѧ������
	private Integer upgradeCount; // ��ѧ��
	private Integer changeCount; // ת������ת����
	private Integer runoffCount; // �˷�������ʧ��

	private String remark; // ����˵��
	private Date uploadTime; // �α�·��
	private String uploadPath; // �α�����
	private String uploadFilename; // �ϴ�ʱ��

	// ���һ������༶��Ӧһ���γ�
	private CrmCourseType courseType;

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getUpgradeCount() {
		return upgradeCount;
	}

	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}

	public Integer getChangeCount() {
		return changeCount;
	}

	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}

	public Integer getRunoffCount() {
		return runoffCount;
	}

	public void setRunoffCount(Integer runoffCount) {
		this.runoffCount = runoffCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadFilename() {
		return uploadFilename;
	}

	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	public CrmCourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CrmCourseType courseType) {
		this.courseType = courseType;
	}

}
