package pers.yijin.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import pers.yijin.crm.coursetype.dao.CoursetypeDao;
import pers.yijin.crm.coursetype.domain.CrmCourseType;
import pers.yijin.crm.coursetype.service.CoursetypeService;
import pers.yijin.crm.page.PageBean;

public class CoursetypeServiceImpl implements CoursetypeService {
	private CoursetypeDao coursetypeDao;

	public void setCoursetypeDao(CoursetypeDao coursetypeDao) {
		this.coursetypeDao = coursetypeDao;
	}

	@Override
	public CrmCourseType findCourseById(CrmCourseType crmCourseType) {
		return coursetypeDao.findById(crmCourseType.getCourseTypeId());
	}

	@Override
	public void addOrEdit(CrmCourseType crmCourseType) {
		coursetypeDao.saveOrUpdate(crmCourseType);
	}

	@Override
	public PageBean<CrmCourseType> findAllByCondition(CrmCourseType crmCourseType,
			int pageNum, int pageSize) {
		// ����ƴ��HQL���
		StringBuilder builder = new StringBuilder();
		// ������װ������list���򣬿����ظ�
		List<Object> list = new ArrayList<Object>();
		// �γ����
		if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
			builder.append(" and courseName like ? ");
			list.add("%" + crmCourseType.getCourseName() + "%");
		}
		// �γ̼��
		if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
			builder.append(" and remark like ? ");
			list.add("%" + crmCourseType.getRemark() + "%");
		}
		// ѧʱ
		if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
			builder.append(" and total >= ? ");
			list.add(Integer.parseInt(crmCourseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
			builder.append(" and total <= ? ");
			list.add(Integer.parseInt(crmCourseType.getTotalEnd()));
		}
		// ����
		if (StringUtils.isNotBlank(crmCourseType.getLessonCostStart())) {
			builder.append(" and courseCost >= ? ");
			list.add(Double.parseDouble(crmCourseType.getLessonCostStart()));
		}
		if (StringUtils.isNotBlank(crmCourseType.getLessonCostEnd())) {
			builder.append(" and courseCost <= ? ");
			list.add(Double.parseDouble(crmCourseType.getLessonCostEnd()));
		}
		String condition = builder.toString();
		Object[] params = list.toArray();
		
		//��ȡ�ܼ�¼��
		int totalRecord = this.coursetypeDao.getTotalRecord(condition,params);
		//����pageBean����
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		//���з�ҳ��ѯ����÷�ҳ����
		List<CrmCourseType> data = this.coursetypeDao.findAllByPage(condition, params, pageBean.getStartIndex(), pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
