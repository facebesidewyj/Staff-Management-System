package pers.yijin.crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import pers.yijin.crm.classes.domain.CrmClasses;

/**
 * 课程类别类
 * 
 * @author wyj
 * 
 */
public class CrmCourseType {
	private String courseTypeId;
	private Double courseCost; // 课程费用
	private Integer total; // 总课时
	private String courseName;
	private String remark; // 课程介绍

	// 一对多：一个课程对应多个班级
	private Set<CrmClasses> classesSet = new HashSet<CrmClasses>();

	// 为条件查找增加四条数据列，以便获取数据
	private String totalStart;
	private String totalEnd;
	private String lessonCostStart;
	private String lessonCostEnd;

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	public Double getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(Double courseCost) {
		this.courseCost = courseCost;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<CrmClasses> getClassesSet() {
		return classesSet;
	}

	public void setClassesSet(Set<CrmClasses> classesSet) {
		this.classesSet = classesSet;
	}

	public String getTotalStart() {
		return totalStart;
	}

	public void setTotalStart(String totalStart) {
		this.totalStart = totalStart;
	}

	public String getTotalEnd() {
		return totalEnd;
	}

	public void setTotalEnd(String totalEnd) {
		this.totalEnd = totalEnd;
	}

	public String getLessonCostStart() {
		return lessonCostStart;
	}

	public void setLessonCostStart(String lessonCostStart) {
		this.lessonCostStart = lessonCostStart;
	}

	public String getLessonCostEnd() {
		return lessonCostEnd;
	}

	public void setLessonCostEnd(String lessonCostEnd) {
		this.lessonCostEnd = lessonCostEnd;
	}

}
