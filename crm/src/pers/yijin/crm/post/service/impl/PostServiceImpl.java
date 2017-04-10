package pers.yijin.crm.post.service.impl;

import java.util.List;

import pers.yijin.crm.department.domain.CrmDepartment;
import pers.yijin.crm.post.dao.PostDao;
import pers.yijin.crm.post.domain.CrmPost;
import pers.yijin.crm.post.service.PostService;

public class PostServiceImpl implements PostService {
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Override
	public List<CrmPost> findAllWithDepartment(CrmDepartment crmDepartment) {
		return postDao.findAllWithDepartment(crmDepartment);
	}

}
