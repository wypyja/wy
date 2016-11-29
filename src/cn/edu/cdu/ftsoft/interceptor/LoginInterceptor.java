package cn.edu.cdu.ftsoft.interceptor;

import java.util.Map;

import cn.edu.cdu.ftsoft.utils.Constants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("action之前运行");
		// 取得请求相关的ActionContext实例    
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get(Constants.USER_SESSION);  
        // 如果没有登陆，或者登陆所有的用户名不是dennis，都返回重新登陆  
        if (user != null && user.equals("dennis")) {  
            System.out.println("test");  
            return invocation.invoke();  
        }  
        ctx.put("tip", "你还没有登录");  
        return "login";  
	}
}
