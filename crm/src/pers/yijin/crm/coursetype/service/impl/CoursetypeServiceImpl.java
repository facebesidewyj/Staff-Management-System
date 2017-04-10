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
		// 用于拼接HQL语句
		StringBuilder builder = new StringBuilder();
		// 用来封装参数，list有序，可以重复
		List<Object> list = new ArrayList<Object>();
		// 课程类别
		if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
			builder.append(" and courseName like ? ");
			list.add("%" + crmCourseType.getCourseName() + "%");
		}
		// 课程简介
		if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
			builder.append(" and remark like ? ");
			list.add("%" + crmCourseType.getRemark() + "%");
		}
		// 学时
		if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
			builder.append(" and total >= ? ");
			list.add(Integer.parseInt(crmCourseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
			builder.append(" and total <= ? ");
			list.add(Integer.parseInt(crmCourseType.getTotalEnd()));
		}
		// 费用
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
		
		//获取总记录数
		int totalRecord = this.coursetypeDao.getTotalRecord(condition,params);
		//创建pageBean对象
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		//进行分页查询，获得分页数据
		List<CrmCourseType> data = this.coursetypeDao.findAllByPage(condition, params, pageBean.getStartIndex(), pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
