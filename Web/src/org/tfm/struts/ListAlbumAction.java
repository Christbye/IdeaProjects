package org.tfm.struts;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.Album;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Controller("list-album")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ListAlbumAction extends AlbumBaseActionSupport {
    private int kind;
    private List<Album> list;
    private boolean unUseJson;

    public void setUnUseJson(boolean unUseJson) {
        this.unUseJson = unUseJson;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public List<Album> getList() {
        return list;
    }

    public String execute(){
        if(kind!=0)
            list = service.listByKind(kind);
        else
            list = service.list();
        if(unUseJson)
            return "success";
        return "json";
    }
}
