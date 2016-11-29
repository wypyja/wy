package cn.edu.cdu.ftsoft.interceptor;

import java.util.Map;

import cn.edu.cdu.ftsoft.utils.Constants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("action֮ǰ����");
		// ȡ��������ص�ActionContextʵ��    
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get(Constants.USER_SESSION);  
        // ���û�е�½�����ߵ�½���е��û�������dennis�����������µ�½  
        if (user != null && user.equals("dennis")) {  
            System.out.println("test");  
            return invocation.invoke();  
        }  
        ctx.put("tip", "�㻹û�е�¼");  
        return "login";  
	}
}
