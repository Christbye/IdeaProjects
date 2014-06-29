package org.tfm.struts;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tfm.entity.FMFile;

import java.util.List;

/**
 * Created by christ on 14-6-16.
 * Make move.
 */
@Controller("file")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FileAction extends FileBaseActionSupport {
    private String json;
    private FMFile myFile;
    private List<Integer> ids;

    public void setMyFile(FMFile myFile) {
        this.myFile = myFile;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getJson() {
        return json;
    }

    //    public String add(){
//        try {
//            service.save(file);
//            json = JSONObject.fromObject(file).toString();
//        }catch (DataAccessException e){
//            e.printStackTrace();
//            json = JSONObject.fromObject(e).toString();
//        }
//        return "json";
//    }
    public String delete() {
        json = "" + service.delete(ids);
        return "json";
    }

    public String update() {
        json = "" + service.update(myFile);
        return "json";
    }
}
