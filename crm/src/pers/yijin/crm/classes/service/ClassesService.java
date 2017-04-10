package pers.yijin.crm.classes.service;

import java.util.List;

import pers.yijin.crm.classes.domain.CrmClasses;

public interface ClassesService {

	/**
	 * ��ѯ���еĿγ�
	 * @return
	 */
	public List<CrmClasses> findAll();
	
	/**
	 * ͨ��Id��ѯ
	 * @param crmClasses
	 * @return
	 */
	public	CrmClasses findById(CrmClasses crmClasses);

	/**
	 * �ϴ��ļ����������
	 * @param model
	 */
	public void updateUpload(CrmClasses crmClasses);
}
