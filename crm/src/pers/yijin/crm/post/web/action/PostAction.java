package pers.yijin.crm.post.web.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import pers.yijin.crm.base.BaseAction;
import pers.yijin.crm.post.domain.CrmPost;

public class PostAction extends BaseAction<CrmPost> {
	public String findAllWithDepartment() throws Exception{
		//��ѯ�����벿����ص�ְ��
		List<CrmPost> findAllWithDepartment = this.getPostService().findAllWithDepartment(this.getModel().getDepartment());
		//��java����װ��Ϊjson����
		//1.�ų�����Ҫ�����ݣ���Ϊ������������ݣ�������ѭ��
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		//2.ת��
		String jsonData = JSONArray.fromObject(findAllWithDepartment, jsonConfig).toString();
		//3.��������
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		//4.���͸������
		ServletActionContext.getResponse().getWriter().print(jsonData);
		return "none";
	}
}
