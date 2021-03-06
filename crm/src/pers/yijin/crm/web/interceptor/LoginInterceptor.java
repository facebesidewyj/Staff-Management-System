package pers.yijin.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session中的对象
		Object obj = ActionContext.getContext().getSession().get("staff");
		if(obj == null){
			//获得当前action
			Object action = invocation.getAction();
			//判断是否继承了ActionSupport
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport) action;
				//使用ActionSupport类添加提示信息
				actionSupport.addFieldError("", "您还未登录，请登录！");
			}
			//未登录，需要登录
			return "login";
		}
		//登录过，直接放行
		return invocation.invoke();
	}

}
