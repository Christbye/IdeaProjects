package org.tfm.struts;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.Album;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Controller("album")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AlbumAction extends AlbumBaseActionSupport {
    private String json;
    private Album myAlbum;

    public String execute() {
        //System.out.println("exec");
        return "input";
    }

    public void setMyAlbum(Album album) {
        this.myAlbum = album;
    }

//    public Album getMyAlbum() {
//        return myAlbum;
//    }

    public String getJson() {
        return json;
    }

    public String add() {
        json = "" + service.save(myAlbum);
        return "json";
    }

    public String delete() {
        json = service.delete(myAlbum.getId()) + "";
        return "json";
    }

    public String update() {
        json = service.update(myAlbum) + "";
        return "json";
    }

}
