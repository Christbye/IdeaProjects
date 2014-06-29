package org.tfm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.tfm.entity.User;

/**
 * Created by christ on 14-6-18.
 * Make move.
 */
public class LoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) actionInvocation.getInvocationContext().getSession().get("user");
//        System.out.println(actionInvocation.getAction());
        //排除登录拦截
        if("LoginAction".equals(actionInvocation.getAction().getClass().getSimpleName()))
            return actionInvocation.invoke();
        //System.out.println(user);
        if(user == null||!user.getPassword().equals("thisispassword")) {
            //System.out.println("interceptor");
            return "input";
        }
        return actionInvocation.invoke();
    }
}
