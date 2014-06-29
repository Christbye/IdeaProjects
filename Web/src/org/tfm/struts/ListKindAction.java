package org.tfm.struts;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.Kind;

import java.util.List;
import java.util.Map;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Controller("list-kind")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ListKindAction extends KindBaseActionSupport implements SessionAware{
    private List<Kind> list;
    private boolean unUseJson;
    private Map<String,Object> session;

    public void setUnUseJson(boolean unUseJson) {
        this.unUseJson = unUseJson;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }
    public List<Kind> getList() {
        return list;
    }

    public String execute() {
        list = service.list();
        //json = JSONArray.fromObject(list).toString();
        //System.out.println(list);
        //System.out.println(json);
        //ServletActionContext.getContext().getSession().put("msg","this is test");
        if(unUseJson) {
            session.put("kinds",list);
            return "success";
        }
        return "json";
    }
}
