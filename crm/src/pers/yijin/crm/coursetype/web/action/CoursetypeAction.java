package pers.yijin.crm.coursetype.web.action;

import org.apache.commons.lang3.StringUtils;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.coursetype.domain.CrmCourseType;
import pers.yijin.crm.page.PageBean;

public class CoursetypeAction extends BaseAction<CrmCourseType> {

	/**
	 * ��������+��ҳ
	 * 
	 * @return
	 */
	public String findCourseByCondition() {
	PageBean<CrmCourseType> pageBean = this.getCoursetypeService().findAllByCondition(this.getModel(), this.getPageNum(), this.getPageSize());
		this.push(pageBean);
		return "findCourseByCondition";
	}
	
	/**
	 * �༭ǰ�Ļ���
	 */
	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.getModel().getCourseTypeId())){
			CrmCourseType findCourse = this.getCoursetypeService().findCourseById(this.getModel());
			this.push(findCourse);
		}
		return "addOrEditUI";
	}
	
	/**
	 * �༭����²���
	 */
	public String addOrEdit(){
		this.getCoursetypeService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
}
