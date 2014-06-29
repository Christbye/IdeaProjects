package org.tfm.struts;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.Kind;

/**
 * Created by christ on 14-6-18.
 * Make move.
 */
@Controller("kind")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class KindAction extends KindBaseActionSupport {
    private String json;
    private Kind myKind;

    public void setMyKind(Kind myKind) {
        this.myKind = myKind;
    }

    public String getJson() {
        return json;
    }

    public String add() {
        json = "" + service.save(myKind);
        return "json";
    }

    public String delete() {
        json = "" + service.delete(myKind.getId());
        return "json";
    }

    public String update() {
        json = "" + service.update(myKind);
        return "json";
    }
}
