package pers.yijin.crm.classes.service;

import java.util.List;

import pers.yijin.crm.classes.domain.CrmClasses;

public interface ClassesService {

	/**
	 * 查询所有的课程
	 * @return
	 */
	public List<CrmClasses> findAll();
	
	/**
	 * 通过Id查询
	 * @param crmClasses
	 * @return
	 */
	public	CrmClasses findById(CrmClasses crmClasses);

	/**
	 * 上传文件后更新数据
	 * @param model
	 */
	public void updateUpload(CrmClasses crmClasses);
}
