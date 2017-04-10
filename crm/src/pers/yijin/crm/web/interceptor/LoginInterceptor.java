package pers.yijin.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//���session�еĶ���
		Object obj = ActionContext.getContext().getSession().get("staff");
		if(obj == null){
			//��õ�ǰaction
			Object action = invocation.getAction();
			//�ж��Ƿ�̳���ActionSupport
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				//ʹ��ActionSupport�������ʾ��Ϣ
				actionSupport.addFieldError("", "����δ��¼�����¼��");
			}
			//δ��¼����Ҫ��¼
			return "login";
		}
		//��¼����ֱ�ӷ���
		return invocation.invoke();
	}

}
