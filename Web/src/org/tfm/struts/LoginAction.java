package org.tfm.struts;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.User;

import java.util.Map;

/**
 * Created by christ on 14-6-18.
 * Make move.
 */
@Controller("login")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LoginAction implements SessionAware{
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String execute(){
        System.out.println(user);
        if(user == null||!user.getPassword().equals("thisispassword"))
            return "input";
        //System.out.println("jump");
        session.put("user",user);
        return "jump";
    }
    private Map<String,Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }
}
