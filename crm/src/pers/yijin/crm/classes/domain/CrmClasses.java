package pers.yijin.crm.classes.domain;

import java.util.Date;

import pers.yijin.crm.coursetype.domain.CrmCourseType;

/**
 * 班级类
 * 
 * @author wyj
 * 
 */
public class CrmClasses {
	private String classId;
	private String name;

	private Date beginTime; // 开班时间
	private Date endTime; // 毕业时间
	private String status; // 状态

	private Integer totalCount; // 学生总数
	private Integer upgradeCount; // 升学数
	private Integer changeCount; // 转班数（转来）
	private Integer runoffCount; // 退费数（流失）

	private String remark; // 其他说明
	private Date uploadTime; // 课表路径
	private String uploadPath; // 课表名称
	private String uploadFilename; // 上传时间

	// 多对一：多个班级对应一个课程
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
