package pers.yijin.crm.classes.service.impl;

import java.util.List;

import pers.yijin.crm.classes.dao.ClassesDao;
import pers.yijin.crm.classes.domain.CrmClasses;
import pers.yijin.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
	
	private ClassesDao classesDao;
	
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public List<CrmClasses> findAll() {
		return classesDao.findAll();
	}

	@Override
	public CrmClasses findById(CrmClasses crmClasses) {
		return classesDao.findById(crmClasses.getClassId());
	}

	@Override
	public void updateUpload(CrmClasses crmClasses) {
		CrmClasses findClasses = this.classesDao.findById(crmClasses.getClassId());
		findClasses.setUploadFilename(crmClasses.getUploadFilename());
		findClasses.setUploadPath(crmClasses.getUploadPath());
		findClasses.setUploadTime(crmClasses.getUploadTime());
	}

}
