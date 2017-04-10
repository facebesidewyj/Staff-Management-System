package pers.yijin.crm.post.web.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost> {
	public String findAllWithDepartment() throws Exception{
		//查询所有与部门相关的职务
		List<CrmPost> findAllWithDepartment = this.getPostService().findAllWithDepartment(this.getModel().getDepartment());
		//将java对象装换为json数据
		//1.排除不需要的数据，因为会产生关联数据，进入死循环
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		//2.转换
		String jsonData = JSONArray.fromObject(findAllWithDepartment, jsonConfig).toString();
		//3.处理乱码
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		//4.发送给浏览器
		ServletActionContext.getResponse().getWriter().print(jsonData);
		return "none";
	}
}
